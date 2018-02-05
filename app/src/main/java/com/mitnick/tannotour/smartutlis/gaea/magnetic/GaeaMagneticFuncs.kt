package com.mitnick.tannotour.smartutlis.gaea.magnetic

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
interface GaeaMagneticFuncs: Funcs {

    fun addScore(
            once: Boolean = true,
            user: UserBean,
            score: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaMagneticPresenter::class.java,
            once,
            doJob = {
                addScore(user, score)
            }
    ){
        call?.invoke(it)
    }
}