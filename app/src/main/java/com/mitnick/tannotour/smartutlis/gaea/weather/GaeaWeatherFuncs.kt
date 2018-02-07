package com.mitnick.tannotour.smartutlis.gaea.weather

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
interface GaeaWeatherFuncs: Funcs {

    fun getWeather(
            once: Boolean = true,
            lat: String,
            lon: String,
            need3HourForcast: String = "1",
            needAlarm: String = "1",
            needHourData: String = "0",
            needIndex: String = "1",
            needMoreDay: String = "1",
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaWeatherPresenter::class.java,
            once,
            doJob = {
                getWeather(lat, lon, need3HourForcast, needAlarm, needHourData, needIndex, needMoreDay)
            }
    ){
        call?.invoke(it)
    }
}