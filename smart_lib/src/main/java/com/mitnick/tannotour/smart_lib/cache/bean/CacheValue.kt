package com.mitnick.tannotour.smart_lib.cache.bean

import com.mitnick.tannotour.smart_lib.cache.bean.annos.RamOnly
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.CacheObserver
import com.mitnick.tannotour.smart_lib.cache.observer.CacheValueObserver
import com.mitnick.tannotour.smart_lib.cache.observer.annos.CacheReceiver
import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.full.memberProperties

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
abstract class CacheValue: CacheBean {

    /* 数据 */
//    private var data: Any? = null
    /* 观察者链表 */
    private val observers: LinkedList<CacheValueObserver> = LinkedList()
//    private val observers: HashMap<CacheValueObserver, String> = HashMap()

    override fun notifyObserver(observer: CacheObserver?) {
        if(observer == null){
            observers.forEach {
                it.onUpdate(this.javaClass.name, this)
            }
        }else{
            (observer as CacheValueObserver).onUpdate(this.javaClass.name, this)
        }
    }

    override fun addObserver(observer: CacheObserver){
        if(!observers.contains(observer)){
            observers.add(observer as CacheValueObserver)
        }
    }

//    fun addObserver(observer: Any){
//        if(!observers.contains(observer)){
//            val method = observer.javaClass.methods.filter {
//                it.isAnnotationPresent(CacheReceiver::class.java)
//            }.first()
//            observers.add(observer as CacheValueObserver)
//        }
//    }

    override fun removeObserver(observer: CacheObserver): Boolean {
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