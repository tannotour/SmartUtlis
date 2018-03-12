package com.mitnick.tannotour.smart_lib.cache

import android.app.Application
import android.util.Log
import com.mitnick.tannotour.smart_lib.cache.bean.CacheBean
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.CacheObserver
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

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

    fun CacheObserver.register(){
        cacheKeys.forEach {
            val cacheBean = checkKey(it)
            cacheBean.addObserver(this)
            cacheBean.notifyObserver(this)
        }
    }

    fun CacheObserver.unRegister(){
        cacheKeys.forEach {
            val key = it.name
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

    @Synchronized fun <T: CacheBean> Any.use(clazz: Class<T>, immediately2Disk: Boolean = false, call: (T.() -> Unit)? = null){
        val cacheBean = checkKey(clazz) as T
        call?.invoke(cacheBean)
        cacheBean.notifyObserver()
        if(immediately2Disk){
            if(null == disk){
                Log.e(TAG, "disk未初始化，跳过硬盘缓存")
            }else{
                cacheBean.sync2Disk(disk!!)
            }
        }
//        return cacheBean
    }

    @Synchronized fun <T: CacheBean> Any.getAsync(clazz: Class<T>, call: (T.() -> Unit)? = null){
        var cacheBean: T
        val key = clazz.name
        if(caches.containsKey(key)){
            cacheBean = caches[key]!! as T
            call?.invoke(cacheBean)
        }else{
            doAsync {
                cacheBean = clazz.newInstance()
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

    private fun <T: CacheBean> checkKey(clazz: Class<T>): CacheBean{
        val key = clazz.name
        val cacheBean: CacheBean
        if(caches.containsKey(key)){
            cacheBean = caches[key]!!
        }else{
            cacheBean = clazz.newInstance()
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