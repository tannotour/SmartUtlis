package com.mitnick.tannotour.smartutlis.gaea.area

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.model.LatLng
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.area.adapter.GaeaAreaCityCommentListAdapter
import com.mitnick.tannotour.smartutlis.gaea.area.bean.AreaCityCommentCacheBean
import com.mitnick.tannotour.smartutlis.gaea.area.comment.GaeaAreaCityCommentActivity
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.GaeaFieldDynamicSendActivity
import kotlinx.android.synthetic.main.gaea_area_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/12.
 * Description
 */
@CacheKey(keys = arrayOf(AreaCityCommentCacheBean::class))
class GaeaAreaActivity: AppCompatActivity(), AreaGetCityCommentFuncs {

    /* 定位相关 */
    private var mLocationClient: LocationClient? = null
    private val myListener = MyLocationListener()
    private var cityName = ""
    /* 城市留言 */
    private lateinit var adapter: GaeaAreaCityCommentListAdapter
    private val REQUEST_COMMENT_CITY = 13000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_area_activity)
        initLocation()
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_COMMENT_CITY){
                val cityName = data.getStringExtra("cityName")
                val userName = data.getStringExtra("userName")
                val content = data.getStringExtra("content")
                val score = data.getStringExtra("score")
                addCityComment(cityName = cityName, userName = userName, content = content, score = score){
                    when(it){
                        STATE.SUCCESS -> {
                            toast("添加城市留言成功")
                        }
                        STATE.FAILED -> {
                            toast("添加城市留言失败")
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        areaMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        areaMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        areaMapView.onDestroy()
        adapter.destory()
    }

    private fun init(){
        areaBack.setOnClickListener {
            finish()
        }
        areaToSendDynamic.setOnClickListener {
            startActivity(Intent(this, GaeaFieldDynamicSendActivity::class.java))
        }
        areaAddComment.setOnClickListener {
            val intent = Intent(this, GaeaAreaCityCommentActivity::class.java)
            intent.putExtra("cityName", cityName)
            startActivityForResult(intent, REQUEST_COMMENT_CITY)
        }
        val layoutManager = LinearLayoutManager(this)
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.isAutoMeasureEnabled = true
        areaCityComment.layoutManager = layoutManager
        areaCityComment.isNestedScrollingEnabled = true
        adapter = GaeaAreaCityCommentListAdapter(areaCityComment)
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
        areaMapView.map.uiSettings.setAllGesturesEnabled(true)
        /* 开启定位图层 */
        areaMapView.map.isMyLocationEnabled = true
    }

    internal inner class MyLocationListener : BDLocationListener {

        override fun onReceiveLocation(location: BDLocation) {
            /* 获取定位结果 */
            cityName = location.city
            getCityComment(cityName = cityName){
                when(it){
                    STATE.SUCCESS -> {

                    }
                    STATE.FAILED -> {
                        toast("没有查询到相关城市的留言")
                    }
                }
            }
            // 构造定位数据
            val locData = MyLocationData.Builder()
                    .accuracy(location.radius)
                    .direction(100f).latitude(location.latitude)
                    .longitude(location.longitude).build()
            // 设置定位数据
            areaMapView.map.setMyLocationData(locData)
            val ll = LatLng(location.latitude, location.longitude)
            val builder = MapStatus.Builder()
            builder.target(ll).zoom(18.0f)
            areaMapView.map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
        }
    }
}