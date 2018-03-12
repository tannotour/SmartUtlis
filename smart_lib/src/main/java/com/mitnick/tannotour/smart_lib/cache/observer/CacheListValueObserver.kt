package com.mitnick.tannotour.smart_lib.cache.observer

import android.os.Looper
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
interface CacheListValueObserver: CacheObserver {

    fun onUpdate(key: String, changes: List<ChangeSet>, dataSet: List<*>){
        if(Looper.myLooper() == Looper.getMainLooper()){
            onNotify(key, changes, dataSet)
        }else{
            doAsync {
                uiThread {
                    onNotify(key, changes, dataSet)
                }
            }
        }
    }

    fun onNotify(key: String, changes: List<ChangeSet>, dataSet: List<*>)
}