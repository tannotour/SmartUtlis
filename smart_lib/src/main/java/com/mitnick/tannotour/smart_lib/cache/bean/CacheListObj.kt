package com.mitnick.tannotour.smart_lib.cache.bean

import com.mitnick.tannotour.smart_lib.cache.observer.ChangeSet
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created by mitnick on 2018/3/13.
 * Description
 */
class CacheListObj<T>(val changes: LinkedList<ChangeSet>, val dataSet: CopyOnWriteArrayList<T>) {
}