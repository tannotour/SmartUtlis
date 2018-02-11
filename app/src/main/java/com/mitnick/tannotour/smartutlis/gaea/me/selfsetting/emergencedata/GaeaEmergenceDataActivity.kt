package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.emergencedata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.EmergenceDataBean
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.gaea_self_setting_emergence_data_activity.*

/**
 * Created by mitnick on 2018/2/11.
 * Description
 */

@CacheKey(keys = arrayOf(EmergenceDataBean::class))
class GaeaEmergenceDataActivity: AppCompatActivity(), CacheValueObserver {

    var emergenceData: EmergenceDataBean? = null
    var isModified = false

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            EmergenceDataBean::class.java.name -> {
                emergenceData = ((newValue as EmergenceDataBean).clone()) as EmergenceDataBean
                gaeaSelfEmergenceSettingSexContent.text = emergenceData!!.sex
                gaeaSelfEmergenceSettingHeightContent.text = emergenceData!!.height
                gaeaSelfEmergenceSettingBirthContent.text = emergenceData!!.birth
                gaeaSelfEmergenceSettingBloodContent.text = emergenceData!!.bloodType
                gaeaSelfEmergenceSettingDiseaseContent.text = emergenceData!!.disease
                gaeaSelfEmergenceSettingAllergyContent.text = emergenceData!!.allergy
                gaeaSelfEmergenceSettingOperationContent.text = emergenceData!!.operation
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_self_setting_emergence_data_activity)
        gaeaSelfEmergenceSettingBack.setOnClickListener {
            val intent = Intent()
            if(emergenceData == null){
                emergenceData = EmergenceDataBean()
            }
            intent.putExtra("data", emergenceData)
            intent.putExtra("isModified", isModified)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        gaeaSelfEmergenceSettingSexItem.setOnClickListener {
            showDialog(
                    hint = "请输入性别"
            ){
                gaeaSelfEmergenceSettingSexContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.sex = it
            }
        }
        gaeaSelfEmergenceSettingHeightItem.setOnClickListener {
            showDialog(
                    hint = "请输入身高"
            ){
                gaeaSelfEmergenceSettingHeightContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.height = it
            }
        }
        gaeaSelfEmergenceSettingBirthItem.setOnClickListener {
            showDialog(
                    hint = "请输入出生日期"
            ){
                gaeaSelfEmergenceSettingBirthContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.birth = it
            }
        }
        gaeaSelfEmergenceSettingBloodItem.setOnClickListener {
            showDialog(
                    hint = "请输入血型"
            ){
                gaeaSelfEmergenceSettingBloodContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.bloodType = it
            }
        }
        gaeaSelfEmergenceSettingDiseaseItem.setOnClickListener {
            showDialog(
                    hint = "请输入患过的慢性病"
            ){
                gaeaSelfEmergenceSettingDiseaseContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.disease = it
            }
        }
        gaeaSelfEmergenceSettingAllergyItem.setOnClickListener {
            showDialog(
                    hint = "请输入过敏源"
            ){
                gaeaSelfEmergenceSettingAllergyContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.allergy = it
            }
        }
        gaeaSelfEmergenceSettingOperationItem.setOnClickListener {
            showDialog(
                    hint = "请输入手术史"
            ){
                gaeaSelfEmergenceSettingOperationContent.text = it
                if(emergenceData == null){
                    emergenceData = EmergenceDataBean()
                }
                emergenceData!!.operation = it
            }
        }
    }

    private fun showDialog(
            title: String = "设置紧急救援资料",
            hint: String = "",
            inputType: Int = InputType.TYPE_CLASS_TEXT,
            call: ((input: String) -> Unit)? = null
    ){
        val builder = QMUIDialog.EditTextDialogBuilder(this)
        builder.setTitle(title)
                .setPlaceholder(hint)
                .setInputType(inputType)
                .addAction("取消") { dialog, _ -> dialog.dismiss() }
                .addAction("确定") { dialog, _ ->
                    val input = builder.editText.text.toString()
                    call?.invoke(input)
                    isModified = true
                    dialog.dismiss()
                }.show()
    }

}