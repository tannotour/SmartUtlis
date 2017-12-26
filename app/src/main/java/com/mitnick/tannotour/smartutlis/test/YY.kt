package com.mitnick.tannotour.smartutlis.test

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList

/**
 * Created by mitnick on 2017/11/9.
 * Description key = "user",
 */
@CacheBean(isList = true)
class YY: CacheList<TestCacheBean>() {

}