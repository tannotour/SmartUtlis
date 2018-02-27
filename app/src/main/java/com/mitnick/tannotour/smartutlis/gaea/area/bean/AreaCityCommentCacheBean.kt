package com.mitnick.tannotour.smartutlis.gaea.area.bean

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList

/**
 * Created by mitnick on 2018/2/12.
 * Description
 */
@CacheBean(isList = true, ramOnly = true)
class AreaCityCommentCacheBean: CacheList<AreaCityCommentBean>()