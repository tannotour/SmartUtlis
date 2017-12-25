package com.mitnick.tannotour.easylib.cache.value

import android.os.Looper
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.CacheObserver
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2017/11/5.
 * Description
 */
interface CacheListValueObserver: CacheObserver {

    fun onUpdate(key: String, cache: CacheList<*>?){
        if(Looper.myLooper() == Looper.getMainLooper()){
            onNotify(Class.forName(key), cache)
        }else{
            doAsync {
                uiThread {
                    onNotify(Class.forName(key), cache)
                }
            }
        }
    }

    fun onNotify(key: Class<*>, cache: CacheList<*>?)
}