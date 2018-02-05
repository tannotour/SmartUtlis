package com.mitnick.tannotour.smartutlis.test

import android.app.Application
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.SDKInitializer
import com.mitnick.tannotour.easylib.LibInit

/**
 * Created by mitnick on 2017/12/15.
 * Description
 */
class MyApp: Application() {

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

    private fun startLocation(){
        mLocationClient = LocationClient(applicationContext)
        mLocationClient?.registerLocationListener { location ->
            address = location.addrStr
            lon = location.longitude
            lat = location.latitude
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