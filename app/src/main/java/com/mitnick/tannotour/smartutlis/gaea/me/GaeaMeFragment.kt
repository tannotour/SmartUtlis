package com.mitnick.tannotour.smartutlis.gaea.me

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaLoginActivity
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.tools.GlideCircleTransform
import kotlinx.android.synthetic.main.gaea_me_fragment.*
import org.jetbrains.anko.image

/**
 * Created by mitnick on 2018/2/3.
 * Description
 */
@CacheKey(keys = arrayOf(UserBean::class))
class GaeaMeFragment: Fragment(), CacheValueObserver {

    var isLogined = false

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                val user: UserBean = newValue as UserBean
                isLogined = user.isLogined
                if(isLogined){
                    Glide.with(this).load("${HttpHost.IMG_BASE_URL}${user.headerImg}").placeholder(R.mipmap.ic_launcher).transform(GlideCircleTransform(activity)).into(meHeaderImg)
                    meUserName.text = user.userName
                    meRecent.text = "当前积分：${user.integral}"
                    meShare.text = "分享\n${user.livePostNum}"
                    meFocus.text = "关注\n${user.focusNum}"
                    meLover.text = "粉丝\n${user.loverNum}"
                    meFieldDynamicNum.text = user.liveEventNum
                    meCollectionNum.text = user.collectionNum
                    meSetting.setOnClickListener {

                    }
                }else{
                    meHeaderImg.image = resources.getDrawable(R.mipmap.ic_launcher)
                    meUserName.text = user.userName
                    meRecent.text = "当前积分：0"
                    meShare.text = "分享\n0"
                    meFocus.text = "关注\n0"
                    meLover.text = "粉丝\n0"
                    meFieldDynamicNum.text = "0"
                    meCollectionNum.text = "0"
                    meSetting.setOnClickListener {
                        gotoLogin(meSetting)
                    }
                    meSelfSettingItem.setOnClickListener {
                        gotoLogin(meSelfSettingItem)
                    }
                }
            }
        }
    }

    private fun gotoLogin(view: View){
        Snackbar.make(view, "还未登录，登录后可体验更多功能。", Snackbar.LENGTH_LONG)
                .setAction(
                        "去登录",
                        {
                            val intent = Intent(activity, GaeaLoginActivity::class.java)
                            intent.putExtra("isFinish", true)
                            startActivity(intent)
                        }
                ).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_me_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}