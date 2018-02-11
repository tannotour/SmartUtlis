package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.*
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.emergencedata.GaeaEmergenceDataActivity
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.gaea_self_setting_activity.*
import org.jetbrains.anko.toast


/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
@CacheKey(keys = arrayOf(AddressCacheBean::class, EmergencePeopleCacheBean::class))
class GaeaSelfSettingActivity: AppCompatActivity(), SelfSettingFuncs, CacheListValueObserver{

    private var addressSheet: QMUIBottomSheet? = null
    private val address = arrayListOf("添加")
    private var emergencePeopleSheet: QMUIBottomSheet? = null
    private val emergencePeople = arrayListOf("添加")
    private val REQUEST_SELECT_PEOPLE = 1000
    private val REQUEST_SET_EMERGENCE_DATA = 1001

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        when(key.name){
            AddressCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                address.add(0, (cache[index] as AddressBean).address)
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
            EmergencePeopleCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                val buffer = (cache[index] as EmergencePeopleBean)
                                emergencePeople.add(0, "${buffer.name}(${buffer.phone})")
                                initEmergencePeopleSheet()
                            }
                            ChangeSet.TYPE.SET -> {

                            }
                            ChangeSet.TYPE.REMOVE -> {

                            }
                            ChangeSet.TYPE.CLEAR -> {
                                emergencePeople.clear()
                                emergencePeople.add("添加")
                                initEmergencePeopleSheet()
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
        initAddressSheet()
        initEmergencePeopleSheet()
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
            if(emergencePeopleSheet != null && !emergencePeopleSheet!!.isShowing){
                emergencePeopleSheet!!.show()
            }
        }
        gaeaSelfSettingEmargeItem.setOnClickListener {
            val intent = Intent(this, GaeaEmergenceDataActivity::class.java)
            startActivityForResult(intent, REQUEST_SET_EMERGENCE_DATA)
        }
        getAddress { }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when(requestCode){
                REQUEST_SELECT_PEOPLE -> {
                    val reContentResolverol = contentResolver
                    val contactData = data.data
                    val cursor = managedQuery(contactData, null, null, null, null)
                    cursor.moveToFirst()
                    val userName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    val contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                    val phone = reContentResolverol.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                            null,
                            null
                    )
                    var userPhone = ""
                    while (phone!!.moveToNext()) {
                        userPhone += phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        userPhone += "-"
                    }
                    phone.close()
                    addEmergencePeople(userName, userPhone)
                }
                REQUEST_SET_EMERGENCE_DATA -> {
                    val isModified = data.getBooleanExtra("isModified", false)
                    if(isModified){
                        val buffer = data.getParcelableExtra<EmergenceDataBean>("data")
                        setEmergenceData(buffer){
                            when(it){
                                STATE.SUCCESS -> {
                                    toast("设置紧急救援资料成功")
                                }
                                STATE.FAILED -> {
                                    toast("设置紧急救援资料失败")
                                }
                            }
                        }
                    }
                }
            }
        }
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
                            .setPlaceholder("在此输入常用地址")
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

    private fun initEmergencePeopleSheet(){
        if(emergencePeopleSheet != null && emergencePeopleSheet!!.isShowing){
            emergencePeopleSheet!!.dismiss()
        }
        val emergencePeopleSheetBuilder = QMUIBottomSheet.BottomListSheetBuilder(this)
        emergencePeople.forEach {
            emergencePeopleSheetBuilder.addItem(it)
        }
        emergencePeopleSheet = emergencePeopleSheetBuilder.setOnSheetItemClickListener { dialog, itemView, position, tag ->
            run{
                if(position == emergencePeople.size - 1){
                    /* 添加紧急联系人 */
                    startActivityForResult(
                            Intent(
                                    Intent.ACTION_PICK,
                                    ContactsContract.Contacts.CONTENT_URI
                            ),
                            REQUEST_SELECT_PEOPLE
                    )
                }
                dialog.dismiss()
            }
        }.build()
    }
}