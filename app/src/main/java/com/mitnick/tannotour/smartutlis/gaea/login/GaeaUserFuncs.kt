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
            once: Boolean = true,
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

    fun register(
            once: Boolean = true,
            phone: String,
            password: String,
            captcha: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaUserPresenter::class.java,
            once,
            doJob = {
                register(phone, password, captcha)
            }
    ){
        call?.invoke(it)
    }

    fun getCaptcha(
            once: Boolean = true,
            phone: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaUserPresenter::class.java,
            once,
            doJob = {
                getCaptcha(phone)
            }
    ){
        call?.invoke(it)
    }
}