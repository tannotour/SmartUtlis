package com.mitnick.tannotour.smartutlis.gaea.dynamic.send

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.baidu.location.LocationClient
import com.baidu.mapapi.search.geocode.GeoCoder
import com.mitnick.tannotour.smartutlis.R
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.search.core.SearchResult
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption
import kotlinx.android.synthetic.main.gaea_dynamic_send_activity.*
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult
import com.baidu.mapapi.search.geocode.GeoCodeResult
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
import com.bigkoo.pickerview.OptionsPickerView
import com.google.gson.Gson
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter.SelectImgAdapter
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter.SelectImgClickListener
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.options.GetJsonDataUtil
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.options.JsonBean
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import me.nereo.multi_image_selector.MultiImageSelector
import me.nereo.multi_image_selector.MultiImageSelectorActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import java.util.*


/**
 * Created by mitnick on 2018/2/3.
 * Description
 */

@CacheKey(keys = arrayOf(UserBean::class))
class GaeaFieldDynamicSendActivity: AppCompatActivity(), GaeaDynamicSendFuncs, CacheValueObserver,  SelectImgClickListener {

    var userId = ""

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                userId = (newValue as UserBean).uuid
            }
        }
    }

    private val continueTimes = arrayListOf("2小时", "5小时", "12小时", "1天", "5天", "10天", "15天", "30天", "90天", "180天")
    private val eventLevel = arrayListOf("注意", "紧急", "较紧急", "非常紧急")

    /* 定位相关 */
    private var mLocationClient: LocationClient? = null
    private val myListener = MyLocationListener()
    /* 坐标 */
    private var latitude = ""
    private var longitude = ""
    /* 坐标反查 */
    private var geoCoder: GeoCoder? = null
    private val geoListener = MyGeoListener()
    /* 三级联动 选择事件类型*/
    private var pvOptions: OptionsPickerView<in Any>? = null
    private var options1Items = ArrayList<JsonBean>()
    private val options2Items = ArrayList<ArrayList<String>>()
    private val options3Items = ArrayList<ArrayList<ArrayList<String>>>()
    /* 选择预计持续时间 */
    private lateinit var timesSheet: QMUIBottomSheet
    /* 选择事件级别 */
    private lateinit var levelSheet: QMUIBottomSheet
    /* 图片 */
    private val imgs = LinkedList<String>()
    private var selectImgAdapter: SelectImgAdapter? = null
    private var curImgNum = 0
    private val SELECT_PICTURE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_dynamic_send_activity)
        initLocation()
        initJsonData(this)
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SELECT_PICTURE) {
            if (resultCode == Activity.RESULT_OK) {
                if(data == null) return
                val paths = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT)
                paths.asSequence().filterNot { imgs.contains(it) }.filter { curImgNum++ < 10 }.forEach {
                    imgs.add(0, it)
                    selectImgAdapter?.notifyItemInserted(0)
                }
            }
        }
    }

    private fun init(){
        sendImgs.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        imgs.add(0, "-")
        selectImgAdapter = SelectImgAdapter(this, imgs, this)
        sendImgs.adapter = selectImgAdapter
        sendImgs.isNestedScrollingEnabled = false
        val timesSheetBuilder = QMUIBottomSheet.BottomListSheetBuilder(this)
        continueTimes.forEach {
            timesSheetBuilder.addItem(it)
        }
        timesSheet = timesSheetBuilder.setOnSheetItemClickListener { dialog, itemView, position, tag ->
            run{
                fieldDynamicSendTime.text = continueTimes[position]
                dialog.dismiss()
            }
        }.build()
        val levelSheetBuilder = QMUIBottomSheet.BottomListSheetBuilder(this)
        eventLevel.forEach {
            levelSheetBuilder.addItem(it)
        }
        levelSheet = levelSheetBuilder.setOnSheetItemClickListener { dialog, itemView, position, tag ->
            run{
                fieldDynamicSendLevel.text = eventLevel[position]
                dialog.dismiss()
            }
        }.build()
        sendItem0.setOnClickListener {
            /* 选取事件类型 */
            pvOptions?.show()
        }
        sendItem1.setOnClickListener {
            /* 选取事件持续时间 */
            if(!timesSheet.isShowing){
                timesSheet.show()
            }
        }
        sendItem2.setOnClickListener {
            /* 选取事件级别 */
            if(!levelSheet.isShowing){
                levelSheet.show()
            }
        }
        back.setOnClickListener {
            finish()
        }
        send.setOnClickListener {
            val tip = checkInput()
            if(tip.isEmpty()){
                val tipDialog = TipDialog.showTip(send, QMUITipDialog.Builder.ICON_TYPE_LOADING, "正在上传", autoDismiss = false)
                sendFieldDynamic(
                        false,
                        userId,
                        sendContent.text.toString(),
                        myLocation.text.toString(),
                        fieldDynamicSendEventType.text.toString(),
                        fieldDynamicSendTime.text.toString(),
                        fieldDynamicSendLevel.text.toString(),
                        latitude,
                        longitude,
                        imgs
                ){
                    when(it){
                        STATE.SUCCESS -> {
                            toast("发表现场事件成功")
                        }
                        STATE.FAILED -> {
                            toast("发表现场事件失败")
                        }
                    }
                    tipDialog.dismiss()
                    val intent = Intent()
                    intent.putExtra("type", fieldDynamicSendEventType.text.toString().split("-").first())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }else{
                TipDialog.showTip(send, QMUITipDialog.Builder.ICON_TYPE_INFO, tip)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    private fun initLocation() {
        /* 坐标反查 */
        geoCoder = GeoCoder.newInstance()
        geoCoder?.setOnGetGeoCodeResultListener(geoListener)
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
        mapView.map.uiSettings.setAllGesturesEnabled(true)
        /* 开启定位图层 */
        mapView.map.isMyLocationEnabled = true
        /* 状态监听 */
        mapView.map.setOnMapStatusChangeListener(object : BaiduMap.OnMapStatusChangeListener {
            override fun onMapStatusChangeStart(p0: MapStatus?, p1: Int) {

            }

            override fun onMapStatusChangeStart(mapStatus: MapStatus) {

            }

            override fun onMapStatusChange(mapStatus: MapStatus) {

            }

            override fun onMapStatusChangeFinish(mapStatus: MapStatus) {
                latitude = mapStatus.bound.center.latitude.toString()
                longitude = mapStatus.bound.center.longitude.toString()
                geoCoder?.reverseGeoCode(ReverseGeoCodeOption().location(mapStatus.bound.center))
            }
        })
    }

    internal inner class MyLocationListener : BDLocationListener {

        override fun onReceiveLocation(location: BDLocation) {
            /* 获取定位结果 */
            myLocation.text = location.addrStr
            latitude = java.lang.Double.toString(location.latitude)
            longitude = java.lang.Double.toString(location.longitude)
            // 构造定位数据
            val locData = MyLocationData.Builder()
                    .accuracy(location.radius)
                    .direction(100f).latitude(location.latitude)
                    .longitude(location.longitude).build()
            // 设置定位数据
            mapView.map.setMyLocationData(locData)
            val ll = LatLng(location.latitude, location.longitude)
            val builder = MapStatus.Builder()
            builder.target(ll).zoom(18.0f)
            mapView.map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
        }
    }

    internal inner class MyGeoListener : OnGetGeoCoderResultListener {

        override fun onGetGeoCodeResult(result: GeoCodeResult) {

            if (result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
            }

            //获取地理编码结果
        }

        override fun onGetReverseGeoCodeResult(result: ReverseGeoCodeResult) {

            if (result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }else{
                myLocation.text = result.address
            }

            //获取反向地理编码结果
        }
    }

    fun initJsonData(context: Context){
        /* 初始化事件类型联动列表 */
        doAsync {
            val JsonData = GetJsonDataUtil().getJson(context, "eventtype.json")
            val jsonBean = parseData(JsonData)
            options1Items = jsonBean
            for (i in jsonBean.indices) {
                val CityList = ArrayList<String>()
                val Province_AreaList = ArrayList<ArrayList<String>>()
                for (c in 0..jsonBean[i].cityList.size - 1) {
                    val CityName = jsonBean[i].cityList[c].name
                    CityList.add(CityName)
                    val City_AreaList = ArrayList<String>()
                    if (jsonBean[i].cityList[c].area == null || jsonBean[i].cityList[c].area.size == 0) {
                        City_AreaList.add("")
                    } else {
                        for(d in 0..jsonBean[i].cityList[c].area.size - 1){
                            val AreaName = jsonBean[i].cityList[c].area[d]
                            City_AreaList.add(AreaName)
                        }
                    }
                    Province_AreaList.add(City_AreaList)
                }
                options2Items.add(CityList)
                options3Items.add(Province_AreaList)
            }
            uiThread {
                pvOptions = OptionsPickerView.Builder(context, OptionsPickerView.OnOptionsSelectListener { options1, options2, options3, v ->
                    var eventType = ""
                    if(options3Items[options1][options2][options3].replace(" ", "").isNotEmpty()){
                        fieldDynamicSendEventType.text = options3Items[options1][options2][options3]
                        eventType = options1Items[options1].name + "-" + options2Items[options1][options2] + "-" + options3Items[options1][options2][options3]
                    }else if(options2Items[options1][options2].replace(" ", "").isNotEmpty()){
                        fieldDynamicSendEventType.text = options2Items[options1][options2]
                        eventType = options1Items[options1].name + "-" + options2Items[options1][options2]
                    }else{
                        fieldDynamicSendEventType.text = options1Items[options1].name
                        eventType = options1Items[options1].name
                    }
                    fieldDynamicSendEventType.text = eventType
                }).setTitleText("请选择事件类型")
                        .setCancelColor(R.color.colorPrimary)
                        .setSubmitColor(R.color.colorPrimary)
                        .setDividerColor(Color.GRAY)
                        .setTextColorCenter(Color.BLACK)
                        .setContentTextSize(17)
                        .setLineSpacingMultiplier(3.2f)
                        .build()
                pvOptions?.setPicker(options1Items, options2Items, options3Items)//三级选择器
            }
        }
    }

    fun parseData(result: String): ArrayList<JsonBean> {
        val detail = ArrayList<JsonBean>()
        try {
            val data = JSONArray(result)
            val gson = Gson()
            for (i in 0..data.length() - 1) {
                val entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean::class.java)
                detail.add(entity)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return detail
    }

    override fun onImgItemClick(type: Int, position: Int) {
        when (type) {
            SelectImgClickListener.ITEM_TYPE_ADD -> if (curImgNum < 10) {
                MultiImageSelector.create(this)
                        .showCamera(true)
                        .count(9 - curImgNum)
                        .multi()
                        .start(this, SELECT_PICTURE)
            }
            SelectImgClickListener.ITEM_TYPE_IMG -> {
                /* 查看大图 */
            }
        }
    }

    override fun onImgDelItemClick(position: Int) {
        imgs.removeAt(position)
        selectImgAdapter?.notifyItemRemoved(position)
        selectImgAdapter?.notifyItemRangeChanged(0, imgs.size)
        curImgNum--
    }

    private fun checkInput(): String{
        if(fieldDynamicSendLevel.text.toString().isEmpty()){
//            toast("请选择事件级别")
            return "请选择事件级别"
        }else if(fieldDynamicSendTime.text.toString().isEmpty()){
//            toast("请选择预计持续时间")
            return "请选择预计持续时间"
        }else if(fieldDynamicSendEventType.text.toString().isEmpty()){
//            toast("请选择事件类别")
            return "请选择事件类别"
        }else if(sendContent.text.toString().isEmpty()){
//            toast("请输入现场内容")
            return "请输入现场内容"
        }else if(imgs.count() <= 1){
//            toast("请至少选择一张图片")
            return "请至少选择一张图片"
        }else{
            return ""
        }
    }
}