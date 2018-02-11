package com.mitnick.tannotour.smartutlis.gaea.weather

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherBean
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherCacheBean
import java.util.*

/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
class GaeaWeatherPresenter: INet {

    private val APPCODE = "5bd58179d07a4fe486ac1bf78c26593b"

    fun getWeather(
            lat: String,
            lon: String,
            need3HourForcast: String = "1",
            needAlarm: String = "1",
            needHourData: String = "0",
            needIndex: String = "1",
            needMoreDay: String = "1"
    ): STATE{
        var state: STATE = STATE.FAILED
        val time = Cache.get(WeatherCacheBean::class.java).updateTime
        val curTime = Date().time
        if(checkTime(time, curTime)){
            val result = get<WeatherBean> {
                url = "https://ali-weather.showapi.com/gps-to-weather"
                headers.put("Authorization", "APPCODE $APPCODE")
                params.put("from", "5")
                params.put("lat", lat)
                params.put("lng", lon)
                params.put("need3HourForcast", need3HourForcast)
                params.put("needAlarm", needAlarm)
                params.put("needHourData", needHourData)
                params.put("needIndex", needIndex)
                params.put("needMoreDay", needMoreDay)
            }.convert(WeatherBean::class.java){
                it.body != null && it.body!!.showapi_res_body.ret_code == 0
            }?.body
            if(result != null){
                state = STATE.SUCCESS
                Cache.use(WeatherCacheBean::class.java){
                    weather = result
                    updateTime = curTime
                }
            }
        }else{
            state = STATE.SUCCESS
        }
        return state
    }

    private fun checkTime(timeLeft: Long, timeRight: Long): Boolean{
        val result = Math.abs(timeLeft - timeRight)
        return (result * 1.0 / (1000 * 60 * 60)) <= 24
    }
}