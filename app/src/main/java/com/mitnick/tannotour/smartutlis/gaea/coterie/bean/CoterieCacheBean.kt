package com.mitnick.tannotour.smartutlis.gaea.coterie.bean

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList

/**
 * Created by mitnick on 2018/2/2.
 * Description
 */
@CacheBean(isList = true, secondKeys = arrayOf("关注", "动态"))
class CoterieCacheBean: CacheList<CoterieBean>()