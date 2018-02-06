package com.mitnick.tannotour.smartutlis.gaea.me.mylist

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.error
import com.mitnick.tannotour.easylib.async.task
import com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean.MyListCacheBean

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
interface GaeaMyListFuncs: Funcs {

    fun getMyList(
            once: Boolean = false,
            clear: Boolean,
            type: String,
            userId: String,
            call:((state: STATE, errorMsg: String) -> Unit)? = null
    ) = task(
            GaeaMyListPresenter::class.java,
            once,
            doJob = {
                getMyList(clear, type, userId)
            }
    ){
        call?.invoke(it, error(MyListCacheBean::class.java, true))
    }
}