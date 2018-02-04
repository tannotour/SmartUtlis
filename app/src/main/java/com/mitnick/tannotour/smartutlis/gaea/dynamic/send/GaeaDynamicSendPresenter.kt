package com.mitnick.tannotour.smartutlis.gaea.dynamic.send

import android.content.Context
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.cache.value.ChangeSet
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.easylib.net.params.FileType
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean

/**
 * Created by mitnick on 2018/2/3.
 * Description
 */
class GaeaDynamicSendPresenter: INet{

    private val levelMap: HashMap<String, Int> = HashMap()

    init {
        levelMap["注意"] = 10
        levelMap["紧急"] = 20
        levelMap["较紧急"] = 30
        levelMap["非常紧急"] = 40
    }

    fun sendFieldDynamic(
            userId: String,
            message: String,
            address: String,
            eventType: String,
            durationHours: String,
            level: String,
            latitude: String,
            longitude: String,
            files: List<String>
    ): STATE{
        var state: STATE = STATE.FAILED
        val result = post<FieldDynamicSendNetBean> {
            url = "${HttpHost.API_URL}liveevent/v1/create"
            params.put("userId", userId)
            params.put("message", message)
            params.put("address", address)
            params.put("eventType", eventType)
            params.put("durationHours", convertHours(durationHours).toString())
            params.put("level", levelMap[level].toString())
            params.put("latitude", latitude)
            params.put("longitude", longitude)
            files.filter {
                it != "-"
            }.forEach {
                this.files.put(it, FileType.TYPE_IMAGE)
            }
        }.convert(FieldDynamicSendNetBean::class.java){
            (it.body != null) && (it.body!!.data != null)
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(FieldDynamicCacheBean::class.java, eventType.split("-").first(), false){
                add(0, result.data!!)
            }
        }
        return state
    }

    private fun convertHours(hourStr: String): Int{
        if(hourStr.contains("小时")){
            return hourStr.replace("小时", "").toInt()
        }else if(hourStr.contains("天")){
            return hourStr.replace("天", "").toInt() * 24
        }else{
            return 0
        }
    }

    class FieldDynamicSendNetBean{
        var code: String? = null
        var desc: String? = null
        var data: FieldDynamicBean? = null
        val ok: Boolean = false
    }
}