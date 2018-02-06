package com.mitnick.tannotour.smartutlis.gaea.me.mylist.user

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.writeError
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.bean.MyListUserBean
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.bean.MyListUserCacheBean
import java.util.*

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
class GaeaMyListUserPresenter: INet {

//    var pages = 1
    var size = 10

    fun getMyListUser(clear: Boolean, type: String): STATE{
        var state: STATE = STATE.FAILED
        if(clear){
            Cache.use(MyListUserCacheBean::class.java, type){
                clear()
            }
//            pages = 1
        }
        val result = get<MyListUserNetBean> {
            url = when(type){
                "关注" -> "${HttpHost.API_URL}/v1/user/myFollowed"
                "粉丝" -> "${HttpHost.API_URL}/v1/user/myFollower"
                "城市安全系数排名" -> "${HttpHost.API_URL}/v1/client/city/rateTop10"
                else -> "${HttpHost.API_URL}v1/user/rate/top10"
            }
        }.convert(MyListUserNetBean::class.java){
            it.body?.ok == true
        }?.body?.data
        if(result != null && result.count() > 0){
            if(result.count() < size){
                /* 下次没有更多了 */
                writeError(MyListUserCacheBean::class.java, "NO_MORE")
            }
            Cache.use(MyListUserCacheBean::class.java, type){
                state = STATE.SUCCESS
                if(type == "城市安全系数排名"){
                    result.reversed().forEach {
                        add(it)
                    }
                }else{
                    result.forEach {
                        add(it)
                    }
                }
            }
        }else if(result != null){
            writeError(MyListUserCacheBean::class.java, "NO_MORE")
        }
//        pages += 1
        return state
    }

    class MyListUserNetBean{
        var code: String? = null
        var desc: String? = null
        var data: LinkedList<MyListUserBean>? = null
        val ok: Boolean = false
    }
}