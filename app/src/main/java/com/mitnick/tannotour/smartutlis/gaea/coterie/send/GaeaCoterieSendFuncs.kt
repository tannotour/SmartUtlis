package com.mitnick.tannotour.smartutlis.gaea.coterie.send

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.error
import com.mitnick.tannotour.easylib.async.task
import com.mitnick.tannotour.smartutlis.gaea.coterie.bean.CoterieCacheBean

/**
 * Created by mitnick on 2018/2/4.
 * Description
 */
interface GaeaCoterieSendFuncs: Funcs {

    fun sendCoterie(
            once: Boolean = false,
            userId: String,
            message: String,
            address: String,
            files: List<String>,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaCoterieSendPresenter::class.java,
            once,
            doJob = {
                sendCoterie(userId, message, address, files)
            }
    ){
        call?.invoke(it)
    }
}