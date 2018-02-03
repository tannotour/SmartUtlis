package com.mitnick.tannotour.smartutlis.gaea.coterie

import com.mitnick.tannotour.easylib.async.STATE
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
        val state: STATE = STATE.SUCCESS
        if(clear){
            Cache.use(CoterieCacheBean::class.java, type, false){
                clear()
            }
            pages = 1
        }
        val result = get<CoterieNetBean> {
            url = when(type){
                "关注" -> "${HttpHost.API_URL}livepost/v1/all"
                else -> "${HttpHost.API_URL}livepost/v1/all"
            }
            params.put("page", pages.toString())
            params.put("size", size.toString())
        }.convert(CoterieNetBean::class.java){
            it.body?.ok == true
        }?.body?.data
        Cache.use(CoterieCacheBean::class.java, type, false){
            result?.forEach {
                add(it)
            }
        }

//        get<CoterieNetBean> {
//            url = when(type){
//                "关注" -> "${HttpHost.API_URL}livepost/v1/all"
//                else -> "${HttpHost.API_URL}livepost/v1/all"
//            }
//            params.put("page", pages.toString())
//            params.put("size", size.toString())
//        }.convert(CoterieNetBean::class.java){
//            it.body?.ok == true
//        }?.body?.data?.forEach {
//            Cache.use(CoterieCacheBean::class.java, type, false){
//                add(it)
//            }
//        }
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