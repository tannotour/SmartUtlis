package com.mitnick.tannotour.smartutlis.gaea.me.mylist

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieCacheBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean.MyListBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean.MyListCacheBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.gaea_my_list_item_layout.view.*
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

@CacheKey(keys = arrayOf(MyListCacheBean::class))
class GaeaMyListAdapter(val userId: String, val type: String, val recyclerView: RecyclerView): RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener, CacheListValueObserver, GaeaMyListFuncs {

    private val datas: LinkedList<MyListBean> = LinkedList()
    private var noMore = false

    init {
        recyclerView.adapter = this
        Cache.addObserver(this)
    }

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        Log.e("GaeaMyListAdapter", "收到了消息通知->${key.name}-$type->$cache")
        when(key.name){
            MyListCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                datas.add(index, cache[index] as MyListBean)
                                notifyItemInserted(index)
                            }
                            ChangeSet.TYPE.SET -> {
                                datas[index] = cache[index] as MyListBean
                                notifyItemChanged(index)
                            }
                            ChangeSet.TYPE.REMOVE -> {
                                datas.removeAt(index)
                                notifyItemRemoved(index)
                            }
                            ChangeSet.TYPE.CLEAR -> {
                                datas.clear()
                                notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gaea_my_list_item_layout, parent, false)
        view.findViewById<RelativeLayout>(R.id.myListItemParent).setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            if(data.firstPicture.isNotEmpty()){
                Glide.with(context).load("${HttpHost.API_URL}${data.firstPicture}").placeholder(R.drawable.ic_svg_placeholder).into(myListItemImg)
            }else{
                Glide.with(context).load(R.drawable.ic_svg_placeholder).into(myListItemImg)
            }
            myListItemTime.text = data.ctime
            myListItemAddress.text = data.address
            myListItemContent.text = data.message
            if (position == datas.size-1 && !noMore){
                /* 加载更多 */
                getMyList(
                        clear = false,
                        type = type,
                        userId = userId
                ){ state, error ->
                    when(state){
                        STATE.SUCCESS -> {
                        }
                        STATE.FAILED -> {
                            if(error == "NO_MORE"){
                                noMore = true
                                TipDialog.showTip(this, QMUITipDialog.Builder.ICON_TYPE_INFO, "没有更多内容了")
                            }else{
                                TipDialog.showTip(this, QMUITipDialog.Builder.ICON_TYPE_INFO, "获取动态失败，请稍后刷新再试")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onClick(view: View) {
//        val position = recyclerView.getChildAdapterPosition(view)
//        val data = datas[position]
//        val intent = Intent(view.context, GaeaDynamicDetailActivity::class.java)
//        intent.putExtra("data", data)
//        intent.putExtra("type", type)
//        when(view.id){
//            R.id.parent -> {
//                view.context.startActivity(intent)
//            }
//        }
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)

    override fun secondKey(): String {
        return type
    }

    fun destory(){
        Cache.removeObserver(this)
    }
}