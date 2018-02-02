package com.mitnick.tannotour.smartutlis.gaea.login

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/2/1.
 * Description
 */
interface GaeaUserFuncs: Funcs {

    fun login(
            once: Boolean = false,
            phone: String,
            password: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaUserPresenter::class.java,
            once,
            doJob = {
                login(phone, password)
            }
    ){
        call?.invoke(it)
    }
}