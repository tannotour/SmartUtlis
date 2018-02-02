package com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.dynamic.FieldDynamicFuncs
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.detail.GaeaDynamicDetailActivity
import kotlinx.android.synthetic.main.gaea_dynamic_item_layout.view.*
import org.jetbrains.anko.below
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

@CacheKey(keys = arrayOf(FieldDynamicCacheBean::class))
class GaeaDynamicListAdapter(val type: String = "", val recyclerView: RecyclerView): RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener, CacheListValueObserver, FieldDynamicFuncs {

    private val datas: LinkedList<FieldDynamicBean> = LinkedList()

    init {
        recyclerView.adapter = this
        Cache.addObserver(this)
    }

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        Log.e("GaeaDynamicListAdapter", "收到了消息通知->${key.name}-$type->$cache")
        when(key.name){
            FieldDynamicCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                datas.add(index, cache[index] as FieldDynamicBean)
                                notifyItemInserted(index)
                            }
                            ChangeSet.TYPE.SET -> {
                                datas[index] = cache[index] as FieldDynamicBean
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gaea_dynamic_item_layout, parent, false)
        view.findViewById<RelativeLayout>(R.id.parent).setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            level.text = data.level
            duration.text = "持续${data.durationHours}小时"
            time.text = data.ctime
            content.text = data.message
            location.text = data.address
            thumbupNum.text = data.thumbs.filter {
                it.type == "0"
            }.count().toString()
            thumbdownNum.text = data.thumbs.filter {
                it.type == "1"
            }.count().toString()
            commentNum.text = data.comments.size.toString()
            val size = data.pictures.split(",").filter {
                it.isNotEmpty()
            }.count()
            val params: RelativeLayout.LayoutParams
            if(size == 0){
                params = RelativeLayout.LayoutParams(0, 0)
            }
            else{
                params = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        450
                )
            }
            params.below(content)
            imgs.layoutParams = params
            val childCount = imgs.childCount
            data.pictures.split(",").filter {
                it.isNotEmpty()
            }.forEachIndexed { index, str ->
                run {
                    if(index < childCount){
                        val imageView = (imgs.getChildAt(index) as ImageView)
                        imageView.visibility = View.VISIBLE
                        Glide.with(context).load("${HttpHost.API_URL}$str").placeholder(R.drawable.ic_svg_placeholder).into(imgs.getChildAt(index) as ImageView)
                    }
                }
            }
            if(size < childCount){
                for( index in size..childCount-1){
                    val imageView = (imgs.getChildAt(index) as ImageView)
                    imageView.setImageResource(0)
                    imageView.visibility = View.GONE
                }
            }
//            if (position == datas.size-1){
//                /* 加载更多 */
//                refreshFieldDynamic(
//                        type = type
//                ){
//                    when(it){
//                        STATE.SUCCESS -> {
//                            holder.itemView.context.toast("加载更多现场事件成功")
//                        }
//                        STATE.FAILED -> {
//                            holder.itemView.context.toast("加载更多现场事件失败")
//                        }
//                    }
//                }
//            }
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onClick(view: View) {
        val position = recyclerView.getChildAdapterPosition(view)
        val data = datas[position]
        val intent = Intent(view.context, GaeaDynamicDetailActivity::class.java)
        intent.putExtra("data", data)
        intent.putExtra("type", type)
        when(view.id){
            R.id.parent -> {
                view.context.startActivity(intent)
            }
        }
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)

    override fun secondKey(): String {
        return type
    }

    fun sync(){
        Cache.sync(this)
    }

    fun destory(){
        Cache.removeObserver(this)
    }
}