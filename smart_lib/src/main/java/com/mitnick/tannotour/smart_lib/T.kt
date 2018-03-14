package com.mitnick.tannotour.smart_lib

import android.util.Log
import com.mitnick.tannotour.smart_lib.cache.Cache.register
import com.mitnick.tannotour.smart_lib.cache.Cache.unRegister
import com.mitnick.tannotour.smart_lib.cache.Cache.use
import com.mitnick.tannotour.smart_lib.cache.bean.CacheBean
import com.mitnick.tannotour.smart_lib.cache.bean.CacheList
import com.mitnick.tannotour.smart_lib.cache.bean.CacheValue
import com.mitnick.tannotour.smart_lib.cache.observer.CacheValueObserver

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */

class T: CacheValueObserver {

    override val cacheKeys: Array<Class<out CacheBean>>
        get() = arrayOf(Bean2::class.java)

    override fun onNotify(key: String, newValue: Any?) {
        Log.e("onNotify", "$key -> $newValue")
    }

    fun test(){
        register()
        use(Bean::class){

        }
        use(Bean2::class){

        }
        unRegister()
    }

    class Bean: CacheList<Data>()
    class Bean2: CacheValue(){
        var userName2 = ""
        var userAge2 = ""
    }
    class Data{
        var userName = ""
        var userAge = ""
    }
}
