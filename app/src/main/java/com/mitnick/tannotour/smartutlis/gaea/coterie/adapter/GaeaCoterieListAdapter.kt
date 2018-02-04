package com.mitnick.tannotour.smartutlis.gaea.coterie.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
import com.mitnick.tannotour.smartutlis.gaea.coterie.GaeaCoterieFuncs
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieBean
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieCacheBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.gaea_coterie_item_layout.view.*
import org.jetbrains.anko.below
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

@CacheKey(keys = arrayOf(CoterieCacheBean::class))
class GaeaCoterieListAdapter(val type: String = "", val recyclerView: RecyclerView): RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener, CacheListValueObserver, GaeaCoterieFuncs {

    private val datas: LinkedList<CoterieBean> = LinkedList()
    private var noMore = false

    init {
        recyclerView.adapter = this
        Cache.addObserver(this)
    }

    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
        Log.e("GaeaCoterieListAdapter", "收到了消息通知->${key.name}-$type->$cache")
        when(key.name){
            CoterieCacheBean::class.java.name -> {
                cache.changes.forEach {
                    for (index in it.positionStart .. it.positionEnd){
                        when(it.type){
                            ChangeSet.TYPE.ADD -> {
                                datas.add(index, cache[index] as CoterieBean)
                                notifyItemInserted(index)
                            }
                            ChangeSet.TYPE.SET -> {
                                datas[index] = cache[index] as CoterieBean
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gaea_coterie_item_layout, parent, false)
        view.findViewById<RelativeLayout>(R.id.gaeaCoterieItemParent).setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = datas[position]
        with(holder.itemView){
            if(data.userName == null){
                gaeaCoterieItemUserName.text = "未知用户"
            }else{
                gaeaCoterieItemUserName.text = data.userName
            }
            gaeaCoterieItemTime.text = data.ctime
            gaeaCoterieItemContent.text = data.message
            gaeaCoterieItemAddress.text = data.address
            gaeaCoterieItemThumbUp.text = data.likes.toString()
            gaeaCoterieItemComment.text = data.comments.toString()
            Glide.with(context).load("${HttpHost.IMG_BASE_URL}${data.headerImg}").placeholder(R.mipmap.ic_launcher).into(gaeaCoterieItemHeadImg)
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
            params.below(gaeaCoterieItemContent)
            params.marginStart = 24
            params.marginEnd = 24
            gaeaCoterieItemImgs.layoutParams = params
            val childCount = gaeaCoterieItemImgs.childCount
            data.pictures.split(",").filter {
                it.isNotEmpty()
            }.forEachIndexed { index, str ->
                run {
                    if(index < childCount){
                        val imageView = (gaeaCoterieItemImgs.getChildAt(index) as ImageView)
                        imageView.visibility = View.VISIBLE
                        Glide.with(context).load("${HttpHost.API_URL}$str").placeholder(R.drawable.ic_svg_placeholder).into(gaeaCoterieItemImgs.getChildAt(index) as ImageView)
                    }
                }
            }
            if(size < childCount){
                for( index in size..childCount-1){
                    val imageView = (gaeaCoterieItemImgs.getChildAt(index) as ImageView)
                    imageView.setImageResource(0)
                    imageView.visibility = View.GONE
                }
            }
            if (position == datas.size-1 && !noMore){
                /* 加载更多 */
                refreshCoterie(
                        clear = false,
                        type = type,
                        setParams = {}
                ){ state, error ->
                    when(state){
                        STATE.SUCCESS -> {
//                            toast("获取动态成功")
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

    fun sync(){
        Cache.sync(this)
    }

    fun destory(){
        Cache.removeObserver(this)
    }
}