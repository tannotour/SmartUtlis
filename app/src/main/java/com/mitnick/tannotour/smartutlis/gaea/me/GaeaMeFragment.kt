package com.mitnick.tannotour.smartutlis.gaea.me

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaLoginActivity
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.GaeaMyListActivity
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.GaeaMyListUserActivity
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.GaeaSelfSettingActivity
import com.mitnick.tannotour.smartutlis.gaea.me.syssetting.GaeaSysSettingActivity
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
                    meShare.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListActivity::class.java)
                        intent.putExtra("type", "分享")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meFieldDynamicItem.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListActivity::class.java)
                        intent.putExtra("type", "现场")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meCollectionItem.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListActivity::class.java)
                        intent.putExtra("type", "收藏")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meFocus.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListUserActivity::class.java)
                        intent.putExtra("type", "关注")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meLover.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListUserActivity::class.java)
                        intent.putExtra("type", "粉丝")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meHeroicItem.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListUserActivity::class.java)
                        intent.putExtra("type", "个人排名")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meCityRankItem.setOnClickListener {
                        val intent = Intent(activity, GaeaMyListUserActivity::class.java)
                        intent.putExtra("type", "城市安全系数排名")
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                    meSetting.setOnClickListener {
                        startActivity(Intent(activity, GaeaSysSettingActivity::class.java))
                    }
                    meSelfSettingItem.setOnClickListener {
                        startActivity(Intent(activity, GaeaSelfSettingActivity::class.java))
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
                    meShare.setOnClickListener {
                        gotoLogin(meShare)
                    }
                    meFieldDynamicItem.setOnClickListener {
                        gotoLogin(meFieldDynamicItem)
                    }
                    meCollectionItem.setOnClickListener {
                        gotoLogin(meCollectionItem)
                    }
                    meFocus.setOnClickListener {
                        gotoLogin(meFocus)
                    }
                    meLover.setOnClickListener {
                        gotoLogin(meLover)
                    }
                    meHeroicItem.setOnClickListener {
                        gotoLogin(meHeroicItem)
                    }
                    meCityRankItem.setOnClickListener {
                        gotoLogin(meCityRankItem)
                    }
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
        Cache.addObserver(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Cache.removeObserver(this)
    }
}