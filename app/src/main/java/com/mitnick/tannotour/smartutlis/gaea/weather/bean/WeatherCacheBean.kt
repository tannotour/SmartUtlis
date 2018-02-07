package com.mitnick.tannotour.smartutlis.gaea.weather.bean

import com.mitnick.tannotour.easylib.cache.CacheBean

/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
@CacheBean(autoSync = true)
class WeatherCacheBean {
    var weather: WeatherBean? = null
}