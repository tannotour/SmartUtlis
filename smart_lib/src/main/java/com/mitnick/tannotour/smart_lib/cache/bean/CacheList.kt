package com.mitnick.tannotour.smart_lib.cache.bean

import com.mitnick.tannotour.smart_lib.cache.bean.annos.RamOnly
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.CacheListValueObserver
import com.mitnick.tannotour.smart_lib.cache.observer.CacheObserver
import com.mitnick.tannotour.smart_lib.cache.observer.ChangeSet
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created by mitnick on 2017/12/16.
 * Description
 */
abstract class CacheList<T>(var maxSize: Int = 32): CacheBean {

    /* 数据 */
    private val dataSet: CopyOnWriteArrayList<T> = CopyOnWriteArrayList()
    /* 更新记录 */
    private val changes: LinkedList<ChangeSet> = LinkedList()
    /* 观察者链表 */
    private val observers: LinkedList<CacheListValueObserver> = LinkedList()

    override fun notifyObserver(observer: CacheObserver?) {
        updateChanges()
        if(observer == null){
            observers.forEach {
                it.onUpdate(this.javaClass.name, changes, dataSet)
            }
            clearRecord()
        }else{
            (observer as CacheListValueObserver).onUpdate(this.javaClass.name, changes, dataSet)
        }
    }

    override fun addObserver(observer: CacheObserver){
        if(!observers.contains(observer)){
            observers.add(observer as CacheListValueObserver)
        }
    }

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
        disk.writeToDisk(this.javaClass.name, dataSet)
    }

    override fun restore(disk: DiskCache) {
        if(this.javaClass.isAnnotationPresent(RamOnly::class.java)){
            return
        }
        var list = LinkedList<T>()
        list = disk.readFromDisk(this.javaClass.name, list.javaClass)
        clear()
        addRange(0, list)
    }

    fun add(element: T): Boolean {
        if(dataSet.size >= maxSize){
            removeRange(0, maxSize/2)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, dataSet.size, dataSet.size))
        return dataSet.add(element)
    }

    fun add(index: Int, element: T) {
        val position: Int
        if(dataSet.size >= maxSize){
            removeRange(0, maxSize/2)
            if(index < maxSize/2){
                position = 0
            }else{
                position = minOf(index, dataSet.size)
            }
        }else{
            position = minOf(maxOf(index, 0), dataSet.size)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, position, position))
        dataSet.add(position, element)
    }

    fun addRange(index: Int, elements: List<T>){
        if(elements.isEmpty()){
            return
        }
        val position = minOf(maxOf(index, 0), dataSet.size)
        elements.reversed().forEach {
            dataSet.add(position, it)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, position, position + elements.size - 1))
    }

    fun set(index: Int, element: T): T {
        changes.add(ChangeSet(ChangeSet.TYPE.SET, minOf(maxOf(index, 0), dataSet.size), minOf(maxOf(index, 0), dataSet.size)))
        return dataSet.set(index, element)
    }

    fun removeAt(index: Int): T {
        val position =  minOf(maxOf(index, 0), dataSet.size)
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, position, position))
        return dataSet.removeAt(index)
    }

    fun remove(element: T): Boolean {
        val index = dataSet.indexOf(element)
        if(index < 0 || index >= dataSet.size){
            return false
        }
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, index, index))
        return dataSet.remove(element)
    }

    fun removeRange(positionStart: Int, positionEnd: Int): Boolean{
        val start = maxOf(positionStart, 0)
        val end = minOf(positionEnd, dataSet.size)
        if(start < end){
            return false
        }
        for (index in end..start step -1){
            dataSet.removeAt(index)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, start, end))
        return true
    }

    fun findByCondition(condition: T.() -> Boolean): List<Int>{
        val result = LinkedList<Int>()
        dataSet.forEachIndexed { index, it ->
            if(it.condition()){
                result.add(index)
            }
        }
        return result
    }

    fun get(index: Int): T{
        val position = minOf(maxOf(index, 0), dataSet.size)
        return dataSet[position]
    }

    fun clear() {
        changes.clear()
        if(dataSet.isNotEmpty()){
            changes.add(ChangeSet(ChangeSet.TYPE.CLEAR, 0, 0))
            dataSet.clear()
        }
    }

    private fun clearRecord(){
        changes.clear()
    }

    private fun updateChanges(){
        if(changes.isEmpty() && dataSet.size > 0){
            changes.add(ChangeSet(ChangeSet.TYPE.CLEAR, 0, 0))
            changes.add(ChangeSet(ChangeSet.TYPE.ADD, 0, dataSet.size - 1))
        }
    }
}