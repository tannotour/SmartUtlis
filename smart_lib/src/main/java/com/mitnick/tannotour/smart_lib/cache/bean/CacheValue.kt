package com.mitnick.tannotour.smart_lib.cache.bean

import com.mitnick.tannotour.smart_lib.cache.bean.annos.RamOnly
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.CacheObserver
//import com.mitnick.tannotour.smart_lib.cache.observer.CacheValueObserver
import com.mitnick.tannotour.smart_lib.cache.observer.annos.CacheReceiver
import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
abstract class CacheValue: CacheBean {

    /* 观察者链表 */
    private val observers: LinkedList<Any> = LinkedList()

    override fun notifyObserver(observer: Any?) {
//        if(observer == null){
//            observers.forEach {
//                it.onUpdate(this.javaClass.name, this)
//            }
//        }else{
//            (observer as CacheValueObserver).onUpdate(this.javaClass.name, this)
//        }
        if(null != observer){
            executeNotify(observer, this, this::class.jvmName)
        }else{
            observers.forEach {
                executeNotify(it, this, this::class.jvmName)
            }
        }
    }

    override fun addObserver(observer: Any){
        if(!observers.contains(observer)){
            observers.add(observer)
        }
    }

    override fun removeObserver(observer: Any): Boolean {
        if(observers.contains(observer)){
            observers.remove(observer)
        }
        return observers.isEmpty()
    }

    override fun sync2Disk(disk: DiskCache) {
        if(this.javaClass.isAnnotationPresent(RamOnly::class.java)){
            return
        }
        disk.writeToDisk(this.javaClass.name, this)
    }

    override fun restore(disk: DiskCache) {
        if(this.javaClass.isAnnotationPresent(RamOnly::class.java)){
            return
        }
        val buffer = disk.readFromDisk(this.javaClass.name, this.javaClass)
        buffer.javaClass.declaredFields.filter {
            it.name != "serialVersionUID" && it.name != "\$change" && it.name != "observers"
        }.forEach {
            it.isAccessible = true
            val value = it.get(buffer)
            it.set(this, value)
        }
    }
}