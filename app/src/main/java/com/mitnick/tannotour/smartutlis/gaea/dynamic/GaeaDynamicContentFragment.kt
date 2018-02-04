package com.mitnick.tannotour.smartutlis.gaea.dynamic

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter.GaeaDynamicListAdapter
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean
import kotlinx.android.synthetic.main.gaea_dynamic_content_fragment.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

class GaeaDynamicContentFragment: Fragment(), FieldDynamicFuncs {

    var type: String = ""
    lateinit var adapter: GaeaDynamicListAdapter

    fun setType(type: String): GaeaDynamicContentFragment{
        this.type = type
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_dynamic_content_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.isAutoMeasureEnabled = true
        gaeaDynamicContentRecyclerView.layoutManager = layoutManager
        gaeaDynamicContentRecyclerView.isNestedScrollingEnabled = true
        adapter = GaeaDynamicListAdapter(type = type, recyclerView = gaeaDynamicContentRecyclerView)
        gaeaDynamicContentSwipeRefreshLayout.isNestedScrollingEnabled = true
        gaeaDynamicContentSwipeRefreshLayout.setOnRefreshListener {
            refreshFieldDynamic(
                    clear = true,
                    type = type,
                    setParams = {
                        pages = 1
                    }
            ){
                gaeaDynamicContentSwipeRefreshLayout.isRefreshing = false
                when(it){
                    STATE.SUCCESS -> {
                        toast("获取现场事件成功")
                    }
                    STATE.FAILED -> {
                        toast("获取现场事件失败")
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        adapter.sync()
    }

    override fun onDestroy() {
        adapter.destory()
        super.onDestroy()
    }
}