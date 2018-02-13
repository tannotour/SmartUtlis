package com.mitnick.tannotour.smartutlis.test

import android.app.Application
import android.content.Context
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.SDKInitializer
import com.mitnick.tannotour.easylib.LibInit
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.weather.GaeaWeatherFuncs
import android.support.multidex.MultiDex



/**
 * Created by mitnick on 2017/12/15.
 * Description
 */
class MyApp: Application(), GaeaWeatherFuncs {

    /* 定位 */
    private var mLocationClient: LocationClient? = null

    companion object {
        var address = ""
        var lon = 0.0
        var lat = 0.0
    }

    override fun onCreate() {
        super.onCreate()
        LibInit.appInit(this)
        SDKInitializer.initialize(applicationContext)
        startLocation()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun startLocation(){
        mLocationClient = LocationClient(applicationContext)
        mLocationClient?.registerLocationListener { location ->
            if(address.isEmpty()){
                Cache.use(UserBean::class.java){
                    this.address = location.addrStr
                    this.lat = location.latitude
                    this.lon = location.longitude
                }
            }
            address = location.addrStr
            lon = location.longitude
            lat = location.latitude
            getWeather(lat = lat.toString(), lon = lon.toString())
        }
        val option = LocationClientOption()
        option.locationMode = LocationClientOption.LocationMode.Battery_Saving
        option.setCoorType("bd09ll")
        val span = 300000
        option.setScanSpan(span)
        option.setIsNeedAddress(true)
        option.isOpenGps = true
        option.isLocationNotify = true
        option.setIgnoreKillProcess(false)
        option.setEnableSimulateGps(false)
        mLocationClient?.locOption = option
        mLocationClient?.start()
    }
}