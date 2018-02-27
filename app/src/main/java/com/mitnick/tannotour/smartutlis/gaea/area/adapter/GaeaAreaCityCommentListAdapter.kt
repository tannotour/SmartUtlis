package com.mitnick.tannotour.smartutlis.gaea.area.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.area.bean.AreaCityCommentBean
import com.mitnick.tannotour.smartutlis.gaea.area.bean.AreaCityCommentCacheBean
import kotlinx.android.synthetic.main.gaea_area_city_comment_item_layout.view.*
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

@CacheKey(keys = arrayOf(AreaCityCommentCacheBean::class))
class GaeaAreaCityCommentListAdapter(val recyclerView: RecyclerView): RecyclerView.Adapter<RecyclerView.ViewHolder>(), CacheListValueObserver {

    val datas: LinkedList<AreaCityCommentBean> = LinkedList()

    init {
        recyclerView.adapter = this
        Cache.addObserver(this)
    }

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        when(key.name){
            AreaCityCommentCacheBean::class.java.name -> {
                datas.clear()
                cache.forEach {
                    datas.add(it as AreaCityCommentBean)
                }
                notifyDataSetChanged()
//                cache.changes.forEach {
//                    for (index in it.positionStart .. it.positionEnd){
//                        when(it.type){
//                            ChangeSet.TYPE.ADD -> {
//                                datas.add(index, cache[index] as AreaCityCommentBean)
//                                notifyItemInserted(index)
//                            }
//                            ChangeSet.TYPE.SET -> {
//                                datas[index] = cache[index] as AreaCityCommentBean
//                                notifyItemChanged(index)
//                            }
//                            ChangeSet.TYPE.REMOVE -> {
//                                datas.removeAt(index)
//                                notifyItemRemoved(index)
//                            }
//                            ChangeSet.TYPE.CLEAR -> {
//                                datas.clear()
//                                notifyDataSetChanged()
//                            }
//                        }
//                    }
//                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gaea_area_city_comment_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            areaCityCommentUserName.text = data.userId
            areaCityCommentTime.text = data.takeTime
            areaCityCommentContent.text = data.cityContent
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)

    fun sync(){
        Cache.sync(this)
    }

    fun destory(){
        Cache.removeObserver(this)
    }
}