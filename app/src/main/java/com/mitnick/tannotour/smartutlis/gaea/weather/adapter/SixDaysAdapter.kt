package com.mitnick.tannotour.smartutlis.gaea.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.ForestBeans
import kotlinx.android.synthetic.main.item_forest.view.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
class SixDaysAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val datas: LinkedList<ForestBeans> = LinkedList()

    fun addData(data: ForestBeans){
        datas.add(data)
        notifyItemInserted(datas.size-1)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            six_day_item_tv_time.text = data.time
            six_day_item_tv_temp.text = data.temp
            six_day_item_tv_weather.text = data.weather
            Glide.with(context).load(data.img_url).into(six_day_item_img_weather)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forest, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)
}