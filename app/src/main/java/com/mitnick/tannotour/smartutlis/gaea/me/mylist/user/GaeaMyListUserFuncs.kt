package com.mitnick.tannotour.smartutlis.gaea.me.mylist.user

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.error
import com.mitnick.tannotour.easylib.async.task
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.bean.MyListUserCacheBean

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
interface GaeaMyListUserFuncs: Funcs {

    fun getMyListUser(
            once: Boolean = false,
            clear: Boolean,
            type: String,
            call:((state: STATE, errorMsg: String) -> Unit)? = null
    ) = task(
            GaeaMyListUserPresenter::class.java,
            once,
            doJob = {
                getMyListUser(clear, type)
            }
    ){
        call?.invoke(it, error(MyListUserCacheBean::class.java, true))
    }
}