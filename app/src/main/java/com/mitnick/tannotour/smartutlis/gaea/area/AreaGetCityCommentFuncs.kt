package com.mitnick.tannotour.smartutlis.gaea.area

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/2/12.
 * Description
 */
interface AreaGetCityCommentFuncs: Funcs {

    fun getCityComment(
            once: Boolean = true,
            cityName: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            AreaGetCityCommentPresenter::class.java,
            once,
            doJob = {
                getCityComment(cityName)
            }
    ){
        call?.invoke(it)
    }

    fun addCityComment(
            once: Boolean = true,
            cityName: String, userName: String, content: String, score: String,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            AreaGetCityCommentPresenter::class.java,
            once,
            doJob = {
                addCityComment(cityName, userName, content, score)
            }
    ){
        call?.invoke(it)
    }
}