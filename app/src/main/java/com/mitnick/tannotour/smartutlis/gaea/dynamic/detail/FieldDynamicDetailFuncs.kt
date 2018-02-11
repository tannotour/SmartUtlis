package com.mitnick.tannotour.smartutlis.gaea.dynamic.detail

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/1/31.
 * Description
 */
interface FieldDynamicDetailFuncs: Funcs {

    fun thumbUp(
            once: Boolean = false,
            type: String,
            eventId: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            FieldDynamicDetailPresenter::class.java,
            once,
            doJob = {
                thumbUp(type, eventId)
            }
    ){
        call?.invoke(it)
    }

    fun thumbDown(
            once: Boolean = false,
            type: String,
            eventId: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            FieldDynamicDetailPresenter::class.java,
            once,
            doJob = {
                thumbDown(type, eventId)
            }
    ){
        call?.invoke(it)
    }

    fun comment(
            once: Boolean = false,
            type: String,
            eventId: String,
            message: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            FieldDynamicDetailPresenter::class.java,
            once,
            doJob = {
                comment(type, eventId, message)
            }
    ){
        call?.invoke(it)
    }

    fun report(
            once: Boolean = true,
            type: String,
            eventId: String,
            content: String = "举报",
            call:((state: STATE) -> Unit)? = null
    ) = task(
            FieldDynamicDetailPresenter::class.java,
            once,
            doJob = {
                report(type, eventId, content)
            }
    ){
        call?.invoke(it)
    }
}