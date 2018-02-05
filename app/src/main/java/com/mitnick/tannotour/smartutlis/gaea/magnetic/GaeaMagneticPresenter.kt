package com.mitnick.tannotour.smartutlis.gaea.magnetic

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaUserPresenter
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
class GaeaMagneticPresenter: INet {

    fun addScore(
            user: UserBean,
            score: String
    ): STATE{
        var state: STATE = STATE.FAILED
        val addScoreResult = get<AddScoreNetBean> {
            url = "${HttpHost.API_URL}v1/user/rate/update"
            params.put("userId", user.uuid)
            params.put("integral", score)
        }.convert(AddScoreNetBean::class.java){
            true
        }?.body
        if(addScoreResult != null && addScoreResult.ok){
            state = STATE.SUCCESS
        }
        return state
    }

    class AddScoreNetBean{
        var code: String? = null
        var desc: String? = null
        val ok: Boolean = false
    }
}