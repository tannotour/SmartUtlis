package com.mitnick.tannotour.smart_lib.cache.bean

import com.mitnick.tannotour.smart_lib.cache.disk.DiskCache
import com.mitnick.tannotour.smart_lib.cache.observer.CacheObserver

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
interface CacheBean {
    fun notifyObserver(observer: CacheObserver? = null)
    fun addObserver(observer: CacheObserver)
    fun removeObserver(observer: CacheObserver): Boolean
    fun sync2Disk(disk: DiskCache)
    fun restore(disk: DiskCache)
}