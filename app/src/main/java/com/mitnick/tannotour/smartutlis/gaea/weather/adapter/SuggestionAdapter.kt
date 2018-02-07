package com.mitnick.tannotour.smartutlis.gaea.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.ForestBeans
import com.mitnick.tannotour.smartutlis.gaea.weather.model.FakeWeather
import kotlinx.android.synthetic.main.item_forest.view.*
import kotlinx.android.synthetic.main.item_suggestion.view.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by mitnick on 2018/2/7.
 * Description
 */
class SuggestionAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val datas: LinkedList<FakeWeather.FakeSuggestion> = LinkedList()

    fun addData(@FakeWeather.SuggestionType title: String, msg: String){
        val data = FakeWeather.FakeSuggestion()
        data.title = title
        data.msg = msg
        datas.add(data)
        notifyItemInserted(datas.size-1)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            civ_suggesstion.fillColor = data.iconBackgroudColor
            civ_suggesstion.setImageResource(data.icon)
            tvName.text = data.title
            tvMsg.text = data.msg
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_suggestion, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)
}