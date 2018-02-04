package com.mitnick.tannotour.smartutlis.gaea.coterie.send

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter.SelectImgAdapter
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter.SelectImgClickListener
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.gaea_coterie_send_activity.*
import me.nereo.multi_image_selector.MultiImageSelector
import me.nereo.multi_image_selector.MultiImageSelectorActivity
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by mitnick on 2018/2/4.
 * Description
 */
@CacheKey(keys = arrayOf(UserBean::class))
class GaeaCoterieSendActivity: AppCompatActivity(), GaeaCoterieSendFuncs, CacheValueObserver, SelectImgClickListener {

    var userId = ""

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                userId = (newValue as UserBean).uuid
            }
        }
    }

    /* 图片 */
    private val imgs = LinkedList<String>()
    private var selectImgAdapter: SelectImgAdapter? = null
    private var curImgNum = 0
    private val SELECT_PICTURE = 1000
    /* 定位 */
    private var mLocationClient: LocationClient? = null
    private val myListener = MyLocationListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_coterie_send_activity)
        initLocation()
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
        coterieSendImg.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        imgs.add(0, "-")
        selectImgAdapter = SelectImgAdapter(this, imgs, this)
        coterieSendImg.adapter = selectImgAdapter
        coterieSendImg.isNestedScrollingEnabled = false
        coterieSendCancel.setOnClickListener { finish() }
        coterieSendSend.setOnClickListener {
            val tip = checkInput()
            if(tip.isEmpty()){
                val tipDialog = TipDialog.showTip(it, QMUITipDialog.Builder.ICON_TYPE_LOADING, "正在上传", autoDismiss = false)
                sendCoterie(
                        true,
                        userId,
                        coterieSendContent.text.toString(),
                        coterieSendContent.text.toString(),
                        imgs
                ){
                    when(it){
                        STATE.SUCCESS -> {
                            toast("发表动态成功")
                        }
                        STATE.FAILED -> {
                            toast("发表动态失败")
                        }
                    }
                    tipDialog.dismiss()
                    finish()
                }
            }else{
                TipDialog.showTip(it, QMUITipDialog.Builder.ICON_TYPE_INFO, tip)
            }
        }
    }

    private fun initLocation(){
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
        mLocationClient?.start()
    }

    internal inner class MyLocationListener : BDLocationListener {

        override fun onReceiveLocation(location: BDLocation) {
            coterieSendAddress.text = location.addrStr
        }
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
        if(coterieSendContent.text.isEmpty()){
            return "请输入内容"
        }else if(coterieSendAddress.text.isEmpty()){
            return "请等待定位成功后再发送"
        }else{
            return ""
        }
    }
}