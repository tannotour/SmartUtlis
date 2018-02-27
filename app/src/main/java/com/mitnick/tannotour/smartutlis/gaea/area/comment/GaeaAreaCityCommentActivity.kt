package com.mitnick.tannotour.smartutlis.gaea.area.comment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import kotlinx.android.synthetic.main.gaea_area_city_comment_activity.*

/**
 * Created by mitnick on 2018/2/12.
 * Description
 */
class GaeaAreaCityCommentActivity: AppCompatActivity() {

    private var cityName = ""
    private var userName = ""
    private var content = ""
    private var score = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_area_city_comment_activity)
        gaeaCityCommentBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra("cityName", cityName)
            intent.putExtra("userName", userName)
            intent.putExtra("content", content)
            intent.putExtra("score", score)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        gaeaCityCommentSend.setOnClickListener {
            val intent = Intent()
            intent.putExtra("cityName", cityName)
            intent.putExtra("userName", userName)
            intent.putExtra("content", content)
            intent.putExtra("score", score)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        userName = Cache.get(UserBean::class.java).userName
        cityName = intent.getStringExtra("cityName")
        gaeaCityCommentUserNameContent.text = userName
        gaeaCityCommentCityNameContent.text = cityName
        gaeaCityCommentScoreItem.setOnClickListener {
            showDialog(
                    hint = "请输入对城市的评分",
                    inputType = InputType.TYPE_CLASS_NUMBER
            ) {
                score = it
            }
        }
        gaeaCityCommentCommentItem.setOnClickListener {
            showDialog(
                    hint = "请输入对城市的留言"
            ) {
                content = it
            }
        }
    }

    private fun showDialog(
            title: String = "城市留言",
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
                    dialog.dismiss()
                }.show()
    }
}