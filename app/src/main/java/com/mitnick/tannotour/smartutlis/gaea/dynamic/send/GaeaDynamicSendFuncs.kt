package com.mitnick.tannotour.smartutlis.gaea.dynamic.send

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/2/3.
 * Description
 */
interface GaeaDynamicSendFuncs: Funcs {

    fun sendFieldDynamic(
            once: Boolean = false,
            userId: String,
            message: String,
            address: String,
            eventType: String,
            durationHours: String,
            level: String,
            latitude: String,
            longitude: String,
            files: List<String>,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaDynamicSendPresenter::class.java,
            once,
            doJob = {
                sendFieldDynamic(userId, message, address, eventType, durationHours, level, latitude, longitude, files)
            }
    ){
        call?.invoke(it)
    }
}