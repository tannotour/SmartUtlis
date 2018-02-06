package com.mitnick.tannotour.smartutlis.gaea.me.mylist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.gaea_my_list_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
class GaeaMyListActivity: AppCompatActivity(), GaeaMyListFuncs {

    lateinit var user: UserBean
    lateinit var type: String
    lateinit var adapter: GaeaMyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_my_list_activity)
        type = intent.getStringExtra("type")
        user = intent.getParcelableExtra<UserBean>("user")
        myListTitle.text = "我的$type"
        myListBack.setOnClickListener { finish() }
        val layoutManager = LinearLayoutManager(this)
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.isAutoMeasureEnabled = true
        myListRecyclerView.layoutManager = layoutManager
        myListRecyclerView.isNestedScrollingEnabled = true
        adapter = GaeaMyListAdapter(user.uuid, type, myListRecyclerView)
//        val tip = TipDialog.showTip(myListTitle, QMUITipDialog.Builder.ICON_TYPE_LOADING,"正在加载", autoDismiss = false)
        getMyList(
                clear = true,
                type = type,
                userId = user.uuid
        ){ state, _ ->
//            tip.dismiss()
            when(state){
                STATE.SUCCESS -> {
//                    toast("获取 我的$type 成功")
                }
                STATE.FAILED -> {
                    toast("获取 我的$type 失败，请稍后再试")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.destory()
    }
}