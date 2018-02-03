package com.mitnick.tannotour.smartutlis.gaea.dynamic

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */
class FieldDynamicPresenter: INet {

    var pages = 1
    var size = 10

    fun refreshFieldDynamic(clear: Boolean = false, type: String = ""): STATE{
        val state: STATE = STATE.SUCCESS
        if(clear){
            Cache.use(FieldDynamicCacheBean::class.java, type, false){
                clear()
            }
            pages = 1
        }
        get<FieldDynamicNetBean> {
            url = "${HttpHost.API_URL}liveevent/v1/list"
            params.put("page", pages.toString())
            params.put("size", size.toString())
            params.put("type", type)
        }.convert(FieldDynamicNetBean::class.java){
            it.body?.isOk == true
        }?.body?.data?.filter {
            if(type.isNotEmpty()){
                it.eventType.split("-").first() == type
            }else{
                true
            }
        }?.forEach {
            Cache.use(FieldDynamicCacheBean::class.java, it.eventType.split("-").first(), false){
                add(it)
            }
        }
        pages += 1
        return state
    }

    class FieldDynamicNetBean{
        var code: String? = null
        var desc: String? = null
        var data: LinkedList<FieldDynamicBean>? = null
        val isOk: Boolean
            get() = code != null && "000000" == code
    }
}