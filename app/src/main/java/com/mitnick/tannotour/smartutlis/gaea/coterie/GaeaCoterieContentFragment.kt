package com.mitnick.tannotour.smartutlis.gaea.coterie

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.coterie.adapter.GaeaCoterieListAdapter
import kotlinx.android.synthetic.main.gaea_coterie_content_fragment.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */
class GaeaCoterieContentFragment: Fragment(), GaeaCoterieFuncs {

    var type: String = ""
    lateinit var adapter: GaeaCoterieListAdapter

    fun setType(type: String): GaeaCoterieContentFragment{
        this.type = type
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_coterie_content_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.isAutoMeasureEnabled = true
        gaeaCoterieContentRecyclerView.layoutManager = layoutManager
        gaeaCoterieContentRecyclerView.isNestedScrollingEnabled = true
        adapter = GaeaCoterieListAdapter(type = type, recyclerView = gaeaCoterieContentRecyclerView)
        gaeaCoterieContentSwipeRefreshLayout.isNestedScrollingEnabled = true
        gaeaCoterieContentSwipeRefreshLayout.setOnRefreshListener {
            gaeaCoterieContentSwipeRefreshLayout.isRefreshing = false
            refreshCoterie(
                    clear = true,
                    type = type,
                    setParams = {
                        pages = 1
                    }
            ){ state, _ ->
                gaeaCoterieContentSwipeRefreshLayout.isRefreshing = false
                when(state){
                    STATE.SUCCESS -> {
                        toast("获取动态成功")
                    }
                    STATE.FAILED -> {
                        toast("获取动态失败")
                    }
                }
            }
        }
//        Handler().postDelayed(
//                {
//                    refreshCoterie(
//                            clear = true,
//                            type = type,
//                            setParams = {
//                                pages = 1
//                            }
//                    ){
//                        when(it){
//                            STATE.SUCCESS -> {
//                                toast("获取动态成功")
//                            }
//                            STATE.FAILED -> {
//                                toast("获取动态失败")
//                            }
//                        }
//                    }
//                },
//                2000
//        )
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