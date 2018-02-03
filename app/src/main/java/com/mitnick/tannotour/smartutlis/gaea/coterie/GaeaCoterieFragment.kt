package com.mitnick.tannotour.smartutlis.gaea.coterie

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter.GaeaDynamicFragmentPagerAdapter
import kotlinx.android.synthetic.main.gaea_coterie_fragment.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by mitnick on 2018/1/24.
 * Description
 */
class GaeaCoterieFragment: Fragment() {

    val title = arrayListOf("关注", "动态")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_coterie_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GaeaDynamicFragmentPagerAdapter(activity.supportFragmentManager)
        title.forEach {
            adapter.addFragment(GaeaCoterieContentFragment().setType(it), it)
        }
        gaeaCoterieContent.adapter = adapter
        gaeaCoterieTypeTab.setupWithViewPager(gaeaCoterieContent)
    }
}