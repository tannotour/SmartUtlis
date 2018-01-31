package com.mitnick.tannotour.easylib.cache

import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created by mitnick on 2017/12/16.
 * Description
 */
abstract class CacheList<T>(var maxSize: Int = 128): CopyOnWriteArrayList<T>(), Cloneable {

    /* 更新记录 */
    var changes: LinkedList<ChangeSet> = LinkedList()

    override fun add(element: T): Boolean {
        if(size >= maxSize){
            removeRange(0, maxSize/2)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, size, size))
        return super.add(element)
    }

    override fun add(index: Int, element: T) {
        val position: Int
        if(size >= maxSize){
            removeRange(0, maxSize/2)
            if(index < maxSize/2){
                position = 0
            }else{
                position = minOf(index, size)
            }
        }else{
            position = minOf(maxOf(index, 0), size)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, position, position))
        super.add(position, element)
    }

    fun addRange(index: Int, elements: List<T>){
        val position = minOf(maxOf(index, 0), size)
        elements.reversed().forEach {
            super.add(position, it)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.ADD, position, position + elements.size))
    }

    override fun set(index: Int, element: T): T {
        changes.add(ChangeSet(ChangeSet.TYPE.SET, minOf(maxOf(index, 0), size), minOf(maxOf(index, 0), size)))
        return super.set(index, element)
    }

    override fun removeAt(index: Int): T {
        val position =  minOf(maxOf(index, 0), size)
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, position, position))
        return super.removeAt(index)
    }

    override fun remove(element: T): Boolean {
        val index = indexOf(element)
        if(index < 0 || index >= size){
            return false
        }
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, index, index))
        return super.remove(element)
    }

    fun removeRange(positionStart: Int, positionEnd: Int): Boolean{
        val start = maxOf(positionStart, 0)
        val end = minOf(positionEnd, size)
        if(start < end){
            return false
        }
        for (index in end..start step -1){
            super.removeAt(index)
        }
        changes.add(ChangeSet(ChangeSet.TYPE.REMOVE, start, end))
        return true
    }

    override fun clear() {
        changes.clear()
        changes.add(ChangeSet(ChangeSet.TYPE.CLEAR, size - 1, size - 1))
        super.clear()
    }

    fun clearRecord(){
        changes.clear()
    }

    fun updateChanges(){
        if(changes.isEmpty() && size > 0){
            changes.add(ChangeSet(ChangeSet.TYPE.CLEAR, 0, 0))
            changes.add(ChangeSet(ChangeSet.TYPE.ADD, 0, size - 1))
        }
    }

    override fun clone(): Any {
        val newCacheList = super<CopyOnWriteArrayList>.clone() as CacheList<T>
        newCacheList.changes = changes.clone() as LinkedList<ChangeSet>
        return newCacheList
    }
}