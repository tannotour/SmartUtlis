package com.mitnick.tannotour.smartutlis.gaea.dynamic

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter.GaeaDynamicFragmentPagerAdapter
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.sharesafe.GaeaShareSafeActivity
import kotlinx.android.synthetic.main.gaea_dynamic_fragment.*

/**
 * Created by mitnick on 2018/1/24.
 * Description
 */
@CacheKey(keys = arrayOf(UserBean::class))
class GaeaDynamicFragment: Fragment(), FieldDynamicFuncs, CacheValueObserver {

    lateinit var user: UserBean

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                user = (newValue as UserBean).clone() as UserBean
                gaeaDynamicScore.text = "我的积分：${user.integral}"
                gaeaDynamicCitySafeScore.text = "城市安全系数：${user.citySafeNumber}"
                gaeaDynamicAddress.text = user.address
            }
        }
    }

    val title = arrayListOf("实景", "热点", "市容环境", "出行", "危险区域", "儿童安全", "灾害")
    val titleMap = hashMapOf("实景" to "实景", "热点" to "热点现场", "市容环境" to "市容环境", "出行" to "出行安全", "危险区域" to "危险区域", "儿童安全" to "儿童安全隐患", "灾害" to "疑似灾害前兆")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_dynamic_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GaeaDynamicFragmentPagerAdapter(activity.supportFragmentManager)
        title.forEach {
            adapter.addFragment(GaeaDynamicContentFragment().setType(titleMap[it]!!), it)
        }
        gaeaDynamicContent.adapter = adapter
        gaeaDynamicTypeTab.setupWithViewPager(gaeaDynamicContent)
        Cache.addObserver(this)
        gaeaDynamicFuncs1.setOnClickListener {
            val intent = Intent(activity, GaeaShareSafeActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Cache.removeObserver(this)
    }
}