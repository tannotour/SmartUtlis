package com.mitnick.tannotour.smartutlis.test

import android.app.Application
import com.baidu.mapapi.SDKInitializer
import com.mitnick.tannotour.easylib.LibInit

/**
 * Created by mitnick on 2017/12/15.
 * Description
 */
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        LibInit.appInit(this)
        SDKInitializer.initialize(applicationContext)
    }
}