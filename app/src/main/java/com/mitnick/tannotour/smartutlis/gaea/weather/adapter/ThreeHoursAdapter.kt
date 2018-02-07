package com.mitnick.tannotour.smartutlis.gaea.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherBean
import kotlinx.android.synthetic.main.item_hour_list.view.*
import java.util.*


/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
class ThreeHoursAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val datas: LinkedList<WeatherBean.ShowapiResBodyBean.F1Bean.`_$3hourForcastBeanXX`> = LinkedList()

    fun addData(data: WeatherBean.ShowapiResBodyBean.F1Bean.`_$3hourForcastBeanXX`){
        datas.add(data)
        notifyItemInserted(datas.size-1)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            hour_item_tv_time.text = data.hour
            hour_item_tv_temp.text = "${data.temperature_min}℃-${data.temperature_max}℃"
            hour_item_tv_weather.text = data.weather
            Glide.with(context).load(data.weather_pic).into(hour_item_img_weather)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hour_list, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)
}