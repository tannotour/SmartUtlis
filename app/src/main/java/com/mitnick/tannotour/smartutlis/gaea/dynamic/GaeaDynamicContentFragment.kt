package com.mitnick.tannotour.smartutlis.gaea.dynamic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter.GaeaDynamicListAdapter
import kotlinx.android.synthetic.main.gaea_dynamic_content_fragment.*
import org.jetbrains.anko.support.v4.toast


/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

class GaeaDynamicContentFragment: Fragment(), FieldDynamicFuncs {

    var type: String = ""
    var adapter: GaeaDynamicListAdapter? = null

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
        val firstItemPosition = savedInstanceState?.getInt("firstItemPosition", 0)
        val top = savedInstanceState?.getInt("top", 0)
        if(firstItemPosition != null && firstItemPosition != -1){
            adapter = GaeaDynamicListAdapter(type = type, recyclerView = gaeaDynamicContentRecyclerView, visiablePosition = firstItemPosition, top = top?:0)
        }else{
            adapter = GaeaDynamicListAdapter(type = type, recyclerView = gaeaDynamicContentRecyclerView)
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val layoutManager = gaeaDynamicContentRecyclerView.layoutManager
        //判断是当前layoutManager是否为LinearLayoutManager
        // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
        if (layoutManager is LinearLayoutManager) {
            val linearManager = layoutManager as LinearLayoutManager
            //获取最后一个可见view的位置
//            val lastItemPosition = linearManager.findLastVisibleItemPosition()
            //获取第一个可见view的位置
            val firstItemPosition = linearManager.findFirstVisibleItemPosition()
            val top = gaeaDynamicContentRecyclerView.getChildAt(0)?.top
            outState.putInt("firstItemPosition", firstItemPosition)
            outState.putInt("top", top?:0)
        }
    }

    override fun onPause() {
        super.onPause()
        adapter?.sync()
    }

    override fun onDestroy() {
        adapter?.destory()
        super.onDestroy()
    }
}