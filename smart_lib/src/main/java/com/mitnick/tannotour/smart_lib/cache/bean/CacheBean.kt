package com.mitnick.tannotour.smart_lib.cache.bean

import android.os.Looper
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.annos.CacheReceiver
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
interface CacheBean {
    fun notifyObserver(observer: Any? = null)
    fun addObserver(observer: Any)
    fun removeObserver(observer: Any): Boolean
    fun sync2Disk(disk: DiskCache)
    fun restore(disk: DiskCache)

    fun executeNotify(observer: Any, param: Any, cacheName: String){
        runOnUIThread {
            val method = observer.javaClass.methods.filter {
                it.isAnnotationPresent(CacheReceiver::class.java)
            }.filter {
                it.getAnnotation(CacheReceiver::class.java).cacheBean.jvmName == cacheName
            }.first()
            try {
                method.invoke(observer, param)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun runOnUIThread(call: () -> Unit){
        if(Looper.getMainLooper() == Looper.myLooper()){
            call()
        }else{
            doAsync {
                uiThread {
                    call()
                }
            }
        }
    }
}