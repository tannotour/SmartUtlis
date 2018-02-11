package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.*
import java.util.*

/**
 * Created by mitnick on 2018/2/11.
 * Description
 */
class SelfSettingPresenter: INet {

    fun modifyUserName(userName: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<ModifyNetBean> {
            url = "${HttpHost.API_URL}v1/user/updateUserName"
            params.put("userName", userName)
        }.convert(ModifyNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
            Cache.use(UserBean::class.java){
                this.userName = userName
            }
        }
        return state
    }

    fun modifyUserPsw(userPsw: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<ModifyNetBean> {
            url = "${HttpHost.API_URL}v1/user/updatePassword"
            params.put("userName", userPsw)
        }.convert(ModifyNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
            Cache.use(UserBean::class.java){
                this.password = userPsw
            }
        }
        return state
    }

    fun addAddress(address: String): STATE{
        var state: STATE = STATE.FAILED
        val userId = Cache.get(UserBean::class.java).uuid
        val result = get<ModifyNetBean> {
            url = "${HttpHost.API_URL}v1/user/addAddress"
            params.put("address", address)
            params.put("id", userId)
        }.convert(ModifyNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
            Cache.use(AddressCacheBean::class.java){
                val addressBean = AddressBean()
                addressBean.address = address
                add(addressBean)
            }
        }
        return state
    }

    fun getAddress(): STATE{
        var state: STATE = STATE.FAILED
        val userId = Cache.get(UserBean::class.java).uuid
        val result = get<GetAddressNetBean> {
            url = "${HttpHost.API_URL}v1/user/getAddress"
            params.put("id", userId)
        }.convert(GetAddressNetBean::class.java){
            true
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(AddressCacheBean::class.java){
                clear()
                result.data.address.forEach {
                    add(AddressBean(it))
                }
            }
        }
        return state
    }

    fun addEmergencePeople(name: String, phone: String): STATE{
        var state: STATE = STATE.FAILED
        Cache.use(EmergencePeopleCacheBean::class.java){
            phone.split("-").filter {
                it.isNotEmpty()
            }.forEach {
                val people: EmergencePeopleBean = EmergencePeopleBean()
                people.name = name
                people.phone = it
                add(people)
            }
        }
        state = STATE.SUCCESS
        return state
    }

    fun setEmergenceData(
            birth: String,
            sex: String,
            height: String,
            bloodType: String,
            disease: String,
            allergy: String,
            operation: String
    ): STATE{
        var state: STATE = STATE.FAILED
        val userId = Cache.get(UserBean::class.java).uuid
        val result = get<EmergenceDataNetBean> {
            url = "${HttpHost.API_URL}v1/user/setEmergencyData/creat"
            params.put("userId", userId)
            params.put("birth", birth)
            params.put("sex", sex)
            params.put("height", height)
            params.put("bloodType", bloodType)
            params.put("disease", disease)
            params.put("allergy", allergy)
            params.put("operation", operation)
        }.convert(EmergenceDataNetBean::class.java){
            true
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(EmergenceDataBean::class.java){
                this.birth = birth
                this.sex = sex
                this.height = height
                this.bloodType = bloodType
                this.disease = disease
                this.allergy = allergy
                this.operation = operation
            }
        }
        return state
    }

    class ModifyNetBean{
        var code: String = ""
        var desc: String = ""
        var data: String = ""
        val ok: Boolean
            get() = "000000" == code
    }

    class GetAddressNetBean{
        var code: String = ""
        var desc: String = ""
        var data: DataBean = DataBean()
        val ok: Boolean
            get() = "000000" == code

        class DataBean{
            val address: LinkedList<String> = LinkedList()
        }
    }

    class EmergenceDataNetBean{
        var code: String = ""
        var desc: String = ""
        var data: EmergenceDataBean? = null
        var ok: Boolean = false
    }
}