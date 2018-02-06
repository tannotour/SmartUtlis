package com.mitnick.tannotour.smartutlis.gaea.coterie

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.writeError
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieBean
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieCacheBean
import java.util.*

/**
 * Created by mitnick on 2018/2/2.
 * Description
 */
class GaeaCoteriePresenter: INet {

    var pages = 1
    var size = 10

    fun refreshCoterie(clear: Boolean = false, type: String): STATE{
        var state: STATE = STATE.FAILED
        if(clear){
            Cache.use(CoterieCacheBean::class.java, type, false){
                clear()
            }
            pages = 1
        }
        val result = get<CoterieNetBean> {
            url = when(type){
                "关注" -> "${HttpHost.API_URL}livepost/v1/list"
                else -> "${HttpHost.API_URL}livepost/v1/list"
            }
            params.put("page", pages.toString())
            params.put("size", size.toString())
        }.convert(CoterieNetBean::class.java){
            it.body?.ok == true
        }?.body?.data
        if(result != null && result.count() > 0){
            if(result.count() < size){
                /* 下次没有更多了 */
                writeError(CoterieCacheBean::class.java, "NO_MORE")
            }
            Cache.use(CoterieCacheBean::class.java, type, false){
                state = STATE.SUCCESS
                result.forEach {
                    add(it)
                }
            }
        }
        pages += 1
        return state
    }


    class CoterieNetBean{
        var code: String = ""
        var desc: String = ""
        var data: LinkedList<CoterieBean>? = null
        val ok: Boolean = false
    }
}