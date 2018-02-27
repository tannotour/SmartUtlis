package com.mitnick.tannotour.smartutlis.gaea.sharesafe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.model.LatLng
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.GaeaFieldDynamicSendActivity
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.magnetic.GaeaMagneticMonitorActivity
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherCacheBean
import kotlinx.android.synthetic.main.gaea_share_safe_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */

@CacheKey(keys = arrayOf(WeatherCacheBean::class))
class GaeaShareSafeActivity: AppCompatActivity(), CacheValueObserver {

    lateinit var user: UserBean
    /* 定位相关 */
    private var mLocationClient: LocationClient? = null
    private val myListener = MyLocationListener()

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            WeatherCacheBean::class.java.name -> {
                val weather = (newValue as WeatherCacheBean).weather
                if(weather != null){
                    if(weather.showapi_res_body.alarmList.isNotEmpty()){
                        shareSafeWarnMsg.text = weather.showapi_res_body.alarmList.first().issueContent
                        shareSafeWarnMsg.setOnClickListener {

                        }
                    }else{
                        shareSafeWarnMsg.text = "暂无预警信息"
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_share_safe_activity)
        user = intent.getParcelableExtra<UserBean>("user")
        initLocation()
        init()
    }

    override fun onResume() {
        super.onResume()
        shareSafeMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        shareSafeMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        shareSafeMapView.onDestroy()
    }

    private fun init(){
        shareSafeCitySafeScore.text = "城市安全系数：${user.citySafeNumber}"
        shareSafeToSendDynamic.setOnClickListener {
            startActivity(Intent(this, GaeaFieldDynamicSendActivity::class.java))
        }
        shareSafeToMonitor.setOnClickListener {
            val intent = Intent(this, GaeaMagneticMonitorActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
        shareSafeToHelp.setOnClickListener {
            toast("暂未开发")
        }
        shareSafeCancel.setOnClickListener { finish() }
    }

    private fun initLocation() {
        /* 地图 */
        mLocationClient = LocationClient(applicationContext)
        mLocationClient?.registerLocationListener(myListener)
        val option = LocationClientOption()
        option.locationMode = LocationClientOption.LocationMode.Hight_Accuracy
        option.setCoorType("bd09ll")
        val span = 0
        option.setScanSpan(span)
        option.setIsNeedAddress(true)
        option.isOpenGps = true
        option.isLocationNotify = true
        option.setIgnoreKillProcess(false)
        option.setEnableSimulateGps(false)
        mLocationClient?.locOption = option
        /* 启动定位 */
        mLocationClient?.start()
        shareSafeMapView.map.uiSettings.setAllGesturesEnabled(true)
        /* 开启定位图层 */
        shareSafeMapView.map.isMyLocationEnabled = true
    }

    internal inner class MyLocationListener : BDLocationListener {

        override fun onReceiveLocation(location: BDLocation) {
            /* 获取定位结果 */
            shareSafeTitle.text = location.addrStr
            // 构造定位数据
            val locData = MyLocationData.Builder()
                    .accuracy(location.radius)
                    .direction(100f).latitude(location.latitude)
                    .longitude(location.longitude).build()
            // 设置定位数据
            shareSafeMapView.map.setMyLocationData(locData)
            val ll = LatLng(location.latitude, location.longitude)
            val builder = MapStatus.Builder()
            builder.target(ll).zoom(18.0f)
            shareSafeMapView.map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
        }
    }
}