package com.mitnick.tannotour.smartutlis.gaea.dynamic.bean

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

@CacheBean(isList = true, secondKeys = arrayOf("实景", "热点", "附近", "出行", "市容环境", "危险区", "儿童安全"))
class FieldDynamicCacheBean: CacheList<FieldDynamicBean>()