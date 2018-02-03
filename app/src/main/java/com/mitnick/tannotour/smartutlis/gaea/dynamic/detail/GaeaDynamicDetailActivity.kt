package com.mitnick.tannotour.smartutlis.gaea.dynamic.detail

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import kotlinx.android.synthetic.main.gaea_dynamic_detail_activity.*
import org.jetbrains.anko.below
import org.jetbrains.anko.toast


/**
 * Created by mitnick on 2018/1/31.
 * Description
 */
class GaeaDynamicDetailActivity: AppCompatActivity(), FieldDynamicDetailFuncs {

    lateinit var data: FieldDynamicBean
    lateinit var type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_dynamic_detail_activity)
        data = intent.getParcelableExtra<FieldDynamicBean>("data")
        type = intent.getStringExtra("type")
        Glide.with(this).load("${HttpHost.IMG_BASE_URL}${data.user.headerImg}").placeholder(R.mipmap.ic_launcher).into(gaeaDynamicDetailHeadImg)
        gaeaDynamicDetailUserName.text = data.user.userName
        gaeaDynamicDetailLevel.text = data.level
        gaeaDynamicDetailTime.text = data.ctime
        gaeaDynamicDetailDuration.text = "持续${data.durationHours}小时"
        gaeaDynamicDetailContent.text = data.message
        gaeaDynamicDetailAddress.text = data.address
        gaeaDynamicDetailTitle.text = data.eventType.split("-").last()
        var thumbs = ""
        gaeaDynamicDetailFuncThumbUp.text = data.thumbs.filter {
            it.type == "0"
        }.map {
            if(thumbs.isNotEmpty()){
                thumbs += ","
            }
            thumbs += it.user.userName
        }.count().toString()
        gaeaDynamicDetailThumbs.text = thumbs
        gaeaDynamicDetailFuncThumbDown.text = data.thumbs.filter {
            it.type == "1"
        }.count().toString()
        gaeaDynamicDetailFuncComment.text = data.comments.map {
            addCommentView( "${it.user.userName}:", it.message)
        }.count().toString()
        val size = data.pictures.split(",").filter {
            it.isNotEmpty()
        }.count()
        val params: RelativeLayout.LayoutParams
        if(size == 0){
            params = RelativeLayout.LayoutParams(0, 0)
        }
        else{
            params = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    450
            )
        }
        params.below(gaeaDynamicDetailContent)
        params.marginStart = 24
        params.marginEnd = 24
        gaeaDynamicDetailImgs.layoutParams = params
        val childCount = gaeaDynamicDetailImgs.childCount
        data.pictures.split(",").filter {
            it.isNotEmpty()
        }.forEachIndexed { index, str ->
            run {
                if(index < childCount){
                    val imageView = (gaeaDynamicDetailImgs.getChildAt(index) as ImageView)
                    imageView.visibility = View.VISIBLE
                    Glide.with(this).load("${HttpHost.API_URL}$str").placeholder(R.drawable.ic_svg_placeholder).into(gaeaDynamicDetailImgs.getChildAt(index) as ImageView)
                }
            }
        }
        if(size < childCount){
            for( index in size..childCount-1){
                val imageView = (gaeaDynamicDetailImgs.getChildAt(index) as ImageView)
                imageView.setImageResource(0)
                imageView.visibility = View.GONE
            }
        }
        gaeaDynamicDetailBack.setOnClickListener { finish() }
        gaeaDynamicDetailFuncThumbUp.setOnClickListener {
            thumbUp(type = type, eventId = data.id){
                when(it){
                    STATE.SUCCESS -> {
                        toast("点赞成功")
                        val drawable = resources.getDrawable(R.drawable.ic_thumb_up_red)
                        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
                        gaeaDynamicDetailFuncThumbUp.setCompoundDrawables(null, drawable, null, null)
                        gaeaDynamicDetailFuncThumbUp.text = (gaeaDynamicDetailFuncThumbUp.text.toString().toInt() + 1).toString()
                    }
                    STATE.FAILED -> {
                        toast("点赞失败")
                    }
                }
            }
        }
        gaeaDynamicDetailFuncThumbDown.setOnClickListener {
            thumbDown(type = type, eventId = data.id){
                when(it){
                    STATE.SUCCESS -> {
                        toast("踩成功")
                        val drawable = resources.getDrawable(R.drawable.ic_thumb_down_blue)
                        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
                        gaeaDynamicDetailFuncThumbDown.setCompoundDrawables(null, drawable, null, null)
                        gaeaDynamicDetailFuncThumbDown.text = (gaeaDynamicDetailFuncThumbDown.text.toString().toInt() + 1).toString()
                    }
                    STATE.FAILED -> {
                        toast("踩失败")
                    }
                }
            }
        }
        gaeaDynamicDetailFuncComment.setOnClickListener {
            val et = EditText(this)
            et.setPadding(48, 24, 48, 24)
            et.setBackgroundColor(Color.argb(0, 0, 0, 0))
            et.textSize = 12f
            AlertDialog.Builder(this).setTitle("评论@${data.user.userName}")
//                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(et)
                    .setPositiveButton("确定") { dialog, which ->
                        val input = et.text.toString()
                        if (input.isNotEmpty()) {
                            comment(type = type, eventId = data.id, message = input){
                                when(it){
                                    STATE.SUCCESS -> {
                                        toast("评论成功")
                                        gaeaDynamicDetailFuncComment.text = (gaeaDynamicDetailFuncComment.text.toString().toInt() + 1).toString()
                                        addCommentView( "tannotour:", input)
                                    }
                                    STATE.FAILED -> {
                                        toast("评论失败")
                                    }
                                }
                            }
                        } else {
                            toast("评论内容不能为空")
                        }
                    }
                    .setNegativeButton("取消", null)
                    .show()
        }
    }

    fun addCommentView(userName: String, comment: String){
        val commentText: TextView = TextView(this)
        val lp0 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val spannableString = SpannableString(userName + comment)
        val colorSpan = ForegroundColorSpan(Color.parseColor("#0099EE"))
        spannableString.setSpan(colorSpan, 0, userName.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        commentText.text = spannableString
        gaeaDynamicDetailComments.addView(commentText, lp0)
    }
}