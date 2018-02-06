package com.mitnick.tannotour.smartutlis.gaea.me.mylist

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.writeError
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean.MyListBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean.MyListCacheBean
import java.util.*

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
class GaeaMyListPresenter: INet {

    var pages = 1
    var size = 10

    fun getMyList(clear: Boolean, type: String, userId: String): STATE{
        var state: STATE = STATE.FAILED
        if(clear){
            Cache.use(MyListCacheBean::class.java, type, false){
                clear()
            }
            pages = 1
        }
        val result = get<MyListNetBean> {
            url = when(type){
                "现场" -> "${HttpHost.API_URL}liveevent/v1/user"
                else -> "${HttpHost.API_URL}livepost/v1/user"
            }
            params.put("page", pages.toString())
            params.put("size", size.toString())
            params.put("userId", userId)
        }.convert(MyListNetBean::class.java){
            it.body?.ok == true
        }?.body?.data
        if(result != null && result.count() > 0){
            if(result.count() < size){
                /* 下次没有更多了 */
                writeError(MyListCacheBean::class.java, "NO_MORE")
            }
            Cache.use(MyListCacheBean::class.java, type, false){
                state = STATE.SUCCESS
                result.forEach {
                    add(it)
                }
            }
        }else if(result != null){
            writeError(MyListCacheBean::class.java, "NO_MORE")
        }
        pages += 1
        return state
    }

    class MyListNetBean{
        var code: String? = null
        var desc: String? = null
        var data: LinkedList<MyListBean>? = null
        val ok: Boolean = false
    }
}