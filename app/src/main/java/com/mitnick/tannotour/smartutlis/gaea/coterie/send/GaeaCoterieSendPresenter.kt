package com.mitnick.tannotour.smartutlis.gaea.coterie.send

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.easylib.net.params.FileType
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieBean
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieCacheBean

/**
 * Created by mitnick on 2018/2/4.
 * Description
 */
class GaeaCoterieSendPresenter: INet {

    fun sendCoterie(
            userId: String,
            message: String,
            address: String,
            files: List<String>
    ): STATE{
        var state: STATE = STATE.FAILED
        val result = post<CoterieSendNetBean> {
            url = "${HttpHost.API_URL}livepost/v1/create"
            data.put("userId", userId)
            data.put("message", message)
            data.put("address", address)
            files.filter {
                it != "-"
            }.forEach {
                this.files.put(it, FileType.TYPE_IMAGE)
            }
        }.convert(CoterieSendNetBean::class.java){
            (it.body != null) && (it.body!!.data != null)
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(CoterieCacheBean::class.java, "动态", false){
                add(0, result.data!!)
            }
        }
        return state
    }

    class CoterieSendNetBean{
        var code: String? = null
        var desc: String? = null
        var data: CoterieBean? = null
        val ok: Boolean = false
    }
}