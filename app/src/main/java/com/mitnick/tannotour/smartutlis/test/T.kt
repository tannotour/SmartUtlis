package com.mitnick.tannotour.smartutlis.test

import com.mitnick.tannotour.smart_lib.cache.Cache.register
import com.mitnick.tannotour.smart_lib.cache.Cache.unRegister
import com.mitnick.tannotour.smart_lib.cache.Cache.use
import com.mitnick.tannotour.smart_lib.cache.bean.CacheList
import com.mitnick.tannotour.smart_lib.cache.bean.CacheValue

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */

class T{

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
