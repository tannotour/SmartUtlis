package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.AddressBean
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.AddressCacheBean
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.gaea_self_setting_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
@CacheKey(keys = arrayOf(AddressCacheBean::class))
class GaeaSelfSettingActivity: AppCompatActivity(), SelfSettingFuncs, CacheListValueObserver{

    private var addressSheet: QMUIBottomSheet? = null
    private val address = arrayListOf("添加")

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        when(key.name){
            AddressCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                address.add(index, (cache[index] as AddressBean).address)
                                initAddressSheet()
                            }
                            ChangeSet.TYPE.SET -> {

                            }
                            ChangeSet.TYPE.REMOVE -> {

                            }
                            ChangeSet.TYPE.CLEAR -> {
                                address.clear()
                                address.add("添加")
                                initAddressSheet()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_self_setting_activity)
        gaeaSelfSettingBack.setOnClickListener { finish() }
        gaeaSelfSettingUserNameItem.setOnClickListener {
            val builder = QMUIDialog.EditTextDialogBuilder(this)
            builder.setTitle("修改昵称")
                    .setPlaceholder("请输入新昵称")
                    .setInputType(InputType.TYPE_CLASS_TEXT)
                    .addAction("取消") { dialog, _ -> dialog.dismiss() }
                    .addAction("确定") { dialog, _ ->
                        val input = builder.editText.text.toString()
                        if (input.isNotEmpty()) {
                            modifyUserName(input){
                                when(it){
                                    STATE.SUCCESS -> {
                                        toast("昵称修改成功")
                                    }
                                    STATE.FAILED -> {
                                        toast("昵称修改失败")
                                    }
                                }
                            }
                        } else {
                            toast("昵称不能为空")
                        }
                        dialog.dismiss()
                    }.show()
        }
        gaeaSelfSettingPswItem.setOnClickListener {
            val builder = QMUIDialog.EditTextDialogBuilder(this)
            builder.setTitle("修改密码")
                    .setPlaceholder("请输入新密码")
                    .setInputType(InputType.TYPE_CLASS_TEXT)
                    .addAction("取消") { dialog, _ -> dialog.dismiss() }
                    .addAction("确定") { dialog, _ ->
                        val input = builder.editText.text.toString()
                        if (input.isNotEmpty()) {
                            modifyUserPsw(input){
                                when(it){
                                    STATE.SUCCESS -> {
                                        toast("密码修改成功")
                                    }
                                    STATE.FAILED -> {
                                        toast("密码修改失败")
                                    }
                                }
                            }
                        } else {
                            toast("密码不能为空")
                        }
                        dialog.dismiss()
                    }.show()
        }
        gaeaSelfSettingAddressItem.setOnClickListener {
            if(addressSheet != null && !addressSheet!!.isShowing){
                addressSheet!!.show()
            }
        }
        gaeaSelfSettingPeopleItem.setOnClickListener {

        }
        gaeaSelfSettingEmargeItem.setOnClickListener {

        }
        getAddress { }
    }

    private fun initAddressSheet(){
        if(addressSheet != null && addressSheet!!.isShowing){
            addressSheet!!.dismiss()
        }
        val addressSheetBuilder = QMUIBottomSheet.BottomListSheetBuilder(this)
        address.forEach {
            addressSheetBuilder.addItem(it)
        }
        addressSheet = addressSheetBuilder.setOnSheetItemClickListener { dialog, itemView, position, tag ->
            run{
                if(position == address.size - 1){
                    /* 添加常用地址 */
                    val builder = QMUIDialog.EditTextDialogBuilder(this)
                    builder.setTitle("添加常用地址")
                            .setPlaceholder("在此输入您的评论")
                            .setInputType(InputType.TYPE_CLASS_TEXT)
                            .addAction("取消") { dialog, _ -> dialog.dismiss() }
                            .addAction("确定") { dialog, _ ->
                                val input = builder.editText.text.toString()
                                if (input.isNotEmpty()) {
                                    addAddress(input){
                                        when(it){
                                            STATE.SUCCESS -> {
                                                toast("添加常用地址成功，稍后可以看到最新地址")
                                            }
                                            STATE.FAILED -> {
                                                toast("添加常用地址失败")
                                            }
                                        }
                                    }
                                } else {
                                    toast("地址内容不能为空")
                                }
                                dialog.dismiss()
                            }.show()
                }
                dialog.dismiss()
            }
        }.build()
    }
}