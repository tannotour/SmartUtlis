package com.mitnick.tannotour.smartutlis.gaea.dynamic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter.GaeaDynamicFragmentPagerAdapter
import kotlinx.android.synthetic.main.gaea_dynamic_fragment.*

/**
 * Created by mitnick on 2018/1/24.
 * Description
 */
class GaeaDynamicFragment: Fragment(), FieldDynamicFuncs {

    val title = arrayListOf("实景", "热点", "市容环境", "出行", "危险区域", "灾害", "儿童安全")
    val titleMap = hashMapOf("实景" to "实景", "热点" to "热点现场", "市容环境" to "市容环境", "出行" to "出行安全", "危险区域" to "危险区域", "灾害" to "疑似灾害前兆", "儿童安全" to "儿童安全隐患")

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
//        Handler().postDelayed(
//                {
//                    refreshFieldDynamic(
//                            clear = true,
//                            setParams = {
//                                pages = 1
//                            }
//                    ){
//                        when(it){
//                            STATE.SUCCESS -> {
//                                toast("获取现场事件成功")
//                            }
//                            STATE.FAILED -> {
//                                toast("获取现场事件失败")
//                            }
//                        }
//                    }
//                },
//                2000
//        )
    }
}