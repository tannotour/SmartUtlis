package com.mitnick.tannotour.smart_lib.cache.observer

import com.mitnick.tannotour.smart_lib.cache.bean.CacheBean

/**
 * Created by mitnick on 2017/11/9.
 * Description
 */
interface CacheObserver {

    val cacheKeys: Array<Class<out CacheBean>>
}