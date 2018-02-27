package com.mitnick.tannotour.smartutlis.gaea.login

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost

/**
 * Created by mitnick on 2018/2/1.
 * Description
 */
class GaeaUserPresenter: INet {

    fun login(phone: String, password: String): STATE{
        var state: STATE = STATE.FAILED
        val result = post<LoginNetBean> {
            url = "${HttpHost.API_URL}v1/user/login"
            data.put("phone", phone)
            data.put("password", password)
        }.convert(LoginNetBean::class.java){
            true
        }?.body
        if(result != null && result.isOk){
            state = STATE.SUCCESS
            Cache.use(UserBean::class.java){
                deviceId = result.data.deviceId
                headerImg = result.data.headerImg
                entryDatetime = result.data.entryDatetime
                id = result.data.id
                integral = result.data.integral
                this.phone = phone
                this.password = password
                userName = result.data.userName
                uuid = result.data.uuid
                isLogined = true
                livePostNum = result.data.livePostNum
                focusNum = result.data.focusNum
                loverNum = result.data.loverNum
                liveEventNum = result.data.liveEventNum
                collectionNum = result.data.collectionNum
                citySafeNumber = result.data.citySafeNumber
            }
        }
        return state
    }

    fun register(phone: String, password: String, captcha: String): STATE{
        var state: STATE = STATE.FAILED
        val result = post<LoginNetBean> {
            url = "${HttpHost.API_URL}v1/user/register"
            data.put("phone", phone)
            data.put("password", password)
            data.put("captcha", captcha)
        }.convert(LoginNetBean::class.java){
            true
        }?.body
        if(result != null && result.isOk){
            state = STATE.SUCCESS
        }
        return state
    }

    fun getCaptcha(phone: String): STATE{
        var state: STATE = STATE.FAILED
        val result = post<LoginNetBean> {
            url = "${HttpHost.API_URL}v1/user/getCaptcha"
            data.put("phone", phone)
        }.convert(LoginNetBean::class.java){
            true
        }?.body
        if(result != null && result.isOk){
            state = STATE.SUCCESS
        }
        return state
    }

    class LoginNetBean{
        var code: String? = null
        var desc: String? = null
        lateinit var data: UserBean
        val isOk: Boolean
            get() = code != null && "000000" == code
    }
}