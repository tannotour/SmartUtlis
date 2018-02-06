package com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
@CacheBean(isList = true, secondKeys = arrayOf("分享", "现场"), ramOnly = true)
class MyListCacheBean: CacheList<MyListBean>()