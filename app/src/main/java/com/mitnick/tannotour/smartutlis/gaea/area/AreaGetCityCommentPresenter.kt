package com.mitnick.tannotour.smartutlis.gaea.area

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.area.bean.AreaCityCommentBean
import com.mitnick.tannotour.smartutlis.gaea.area.bean.AreaCityCommentCacheBean
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by mitnick on 2018/2/12.
 * Description
 */
class AreaGetCityCommentPresenter: INet {

    fun getCityComment(cityName: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<CityCommentNetBean> {
            url = "${HttpHost.API_URL}v1/client/city/comments"
            params.put("cityName", cityName)
        }.convert(CityCommentNetBean::class.java){
            true
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(AreaCityCommentCacheBean::class.java){
                clear()
                result.data.forEach {
                    add(it)
                }
            }
        }
        return state
    }

    fun addCityComment(cityName: String, userName: String, content: String, score: String): STATE{
        var state: STATE = STATE.FAILED
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        val result = get<CityCommentNetBean> {
            url = "${HttpHost.API_URL}v1/client/city/info"
            params.put("cityName", cityName)
            params.put("userName", userName)
            params.put("content", content)
            params.put("score", score)
            params.put("takeTime", time)
        }.convert(CityCommentNetBean::class.java){
            true
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(AreaCityCommentCacheBean::class.java){
                val buffer = AreaCityCommentBean()
                buffer.cityContent = content
                buffer.userId = userName
                buffer.takeTime = time
                add(buffer)
            }
        }
        return state
    }

    class CityCommentNetBean{
        var code: String? = null
        var desc: String? = null
        var data: LinkedList<AreaCityCommentBean> = LinkedList()
        val ok: Boolean = false
    }
}