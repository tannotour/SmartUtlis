package com.mitnick.tannotour.smartutlis.gaea.coterie

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/2/2.
 * Description
 */
interface GaeaCoterieFuncs: Funcs {

    /**
     * 获取动态
     */
    fun refreshCoterie(
            once: Boolean = false,
            clear: Boolean = false,
            type: String,
            setParams: (GaeaCoteriePresenter.() -> Unit)? = null,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            GaeaCoteriePresenter::class.java,
            once,
            doJob = {
                if(setParams != null){
                    setParams()
                }
                refreshCoterie(clear, type)
            }
    ){
        call?.invoke(it)
    }
}