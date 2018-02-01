package com.mitnick.tannotour.easylib.cache.value

import android.os.Looper
import com.mitnick.tannotour.easylib.cache.CacheObserver
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2017/11/5.
 * Description
 */
interface CacheValueObserver: CacheObserver {

    fun onUpdate(key: String, newValue: Any){
        if(Looper.getMainLooper() == Looper.myLooper()){
            onNotify(Class.forName(key.split("-").first()), newValue)
        }else{
            doAsync {
                uiThread {
                    onNotify(Class.forName(key.split("-").first()), newValue)
                }
            }
        }
    }

    //    fun <T> onNotify(key: String, newValue: T)
    fun onNotify(key: Class<*>, newValue: Any)

//    fun <T> onUpdate(key: String, newValue: T){
//        if(Looper.getMainLooper() == Looper.myLooper()){
//            onNotify(Class.forName(key), newValue)
//        }else{
//            doAsync {
//                uiThread {
//                    onNotify(Class.forName(key), newValue)
//                }
//            }
//        }
//    }
//
////    fun <T> onNotify(key: String, newValue: T)
//    fun <T> onNotify(key: Class<*>, newValue: T)
}