package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.mitnick.tannotour.smartutlis.R
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.gaea_self_setting_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
class GaeaSelfSettingActivity: AppCompatActivity() {

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
                            toast("昵称修改成功")
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
                            toast("密码修改成功")
                        } else {
                            toast("密码不能为空")
                        }
                        dialog.dismiss()
                    }.show()
        }
        gaeaSelfSettingAddressItem.setOnClickListener {

        }
        gaeaSelfSettingPeopleItem.setOnClickListener {

        }
        gaeaSelfSettingEmargeItem.setOnClickListener {

        }
    }
}