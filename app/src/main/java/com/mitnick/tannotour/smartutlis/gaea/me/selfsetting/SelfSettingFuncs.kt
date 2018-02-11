package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task
import com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean.EmergenceDataBean

/**
 * Created by mitnick on 2018/2/11.
 * Description
 */
interface SelfSettingFuncs: Funcs {

    fun modifyUserName(
            userName: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                modifyUserName(userName)
            }
    ){
        call?.invoke(it)
    }

    fun modifyUserPsw(
            userPsw: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                modifyUserPsw(userPsw)
            }
    ){
        call?.invoke(it)
    }

    fun addAddress(
            address: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                addAddress(address)
            }
    ){
        call?.invoke(it)
    }

    fun getAddress(
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                getAddress()
            }
    ){
        call?.invoke(it)
    }

    fun addEmergencePeople(
            name: String,
            phone: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                addEmergencePeople(name, phone)
            }
    ){
        call?.invoke(it)
    }

    fun setEmergenceData(
            birth: String = "",
            sex: String = "",
            height: String = "",
            bloodType: String = "",
            disease: String = "",
            allergy: String = "",
            operation: String = "",
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                setEmergenceData(birth, sex, height, bloodType, disease, allergy, operation)
            }
    ){
        call?.invoke(it)
    }

    fun setEmergenceData(
            data: EmergenceDataBean,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            SelfSettingPresenter::class.java,
            true,
            doJob = {
                setEmergenceData(data.birth, data.sex, data.height, data.bloodType, data.disease, data.allergy, data.operation)
            }
    ){
        call?.invoke(it)
    }
}