package com.mitnick.tannotour.smart_lib.cache.observer

import android.os.Looper
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2017/11/5.
 * Description
 */
interface CacheValueObserver: CacheObserver {

    fun onUpdate(key: String, newValue: Any?){
        if(Looper.getMainLooper() == Looper.myLooper()){
            onNotify(key, newValue)
        }else{
            doAsync {
                uiThread {
                    onNotify(key, newValue)
                }
            }
        }
    }

    fun onNotify(key: String, newValue: Any?)
}