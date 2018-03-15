package com.mitnick.tannotour.smart_lib.cache

import android.app.Application
import android.util.Log
import com.mitnick.tannotour.smart_lib.cache.bean.CacheBean
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.SecondKey
import com.mitnick.tannotour.smart_lib.cache.observer.annos.CacheReceiver
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
object Cache {

    private val TAG = "Cache"
    private var disk: DiskCache? = null
    private val caches = HashMap<String, CacheBean>()

    fun init(application: Application, diskCache: DiskCache){
        if(disk != null){
            return
        }
        disk = diskCache
        disk!!.init(application.applicationContext)
    }

    fun Any.register(){
        this.javaClass.methods.filter {
            it.isAnnotationPresent(CacheReceiver::class.java)
        }.forEach {
            val clazz = it.getAnnotation(CacheReceiver::class.java).cacheBean
            val secondKey = if(this is SecondKey) this.getSecondKey() else ""
            val cacheBean = checkKey(clazz, secondKey)
            cacheBean.addObserver(this)
            cacheBean.notifyObserver(this)
        }
    }

    fun Any.unRegister(){
        this.javaClass.methods.filter {
            it.isAnnotationPresent(CacheReceiver::class.java)
        }.forEach {
            val clazz = it.getAnnotation(CacheReceiver::class.java).cacheBean
            val key = clazz.jvmName
            if(caches.containsKey(key)){
                if(caches[key]!!.removeObserver(this)){
                    if(null == disk){
                        Log.e(TAG, "disk未初始化，跳过硬盘缓存")
                    }else{
                        caches[key]!!.sync2Disk(disk!!)
                    }
                    caches.remove(key)
                }
            }else{
                Log.e(TAG, "${key}未被添加至观察链表中")
            }
        }
    }

    @Synchronized fun <T: CacheBean> Any.use(clazz: KClass<T>, secondKey: String = "", immediately2Disk: Boolean = false, call: (T.() -> Unit)? = null){
        val cacheBean = checkKey(clazz, secondKey) as T
        call?.invoke(cacheBean)
        cacheBean.notifyObserver()
        if(immediately2Disk){
            if(null == disk){
                Log.e(TAG, "disk未初始化，跳过硬盘缓存")
            }else{
                cacheBean.sync2Disk(disk!!)
            }
        }
    }

    @Synchronized fun <T: CacheBean> Any.getAsync(clazz: KClass<T>, call: (T.() -> Unit)? = null){
        var cacheBean: T
        val key = clazz.jvmName
        if(caches.containsKey(key)){
            cacheBean = caches[key]!! as T
            call?.invoke(cacheBean)
        }else{
            doAsync {
                cacheBean = clazz.java.newInstance()
                if(null == disk){
                    Log.e(TAG, "disk未初始化，跳过硬盘缓存")
                }else{
                    cacheBean.restore(disk!!)
                }
                caches.put(key, cacheBean)
                uiThread {
                    call?.invoke(cacheBean)
                }
            }
        }
    }

    private fun <T: CacheBean> checkKey(clazz: KClass<T>, secondKey: String = ""): CacheBean{
        val key: String
        if(secondKey.isNotEmpty()){
            key = clazz.jvmName + "-" + secondKey
        }else{
            key = clazz.jvmName
        }
        val cacheBean: CacheBean
        if(caches.containsKey(key)){
            cacheBean = caches[key]!!
        }else{
            cacheBean = clazz.java.newInstance()
            if(null == disk){
                Log.e(TAG, "disk未初始化，跳过硬盘缓存")
            }else{
                cacheBean.restore(disk!!)
            }
            caches.put(key, cacheBean)
        }
        return cacheBean
    }
}