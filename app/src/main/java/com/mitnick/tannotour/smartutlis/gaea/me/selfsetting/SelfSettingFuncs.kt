package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

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
}