package com.mitnick.tannotour.smartutlis.gaea.dynamic

import com.mitnick.tannotour.easylib.async.Funcs
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.async.task

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */
interface FieldDynamicFuncs: Funcs {

    /**
     * 获取现场事件
     */
    fun refreshFieldDynamic(
            once: Boolean = false,
            clear: Boolean = false,
            type: String = "",
            setParams: (FieldDynamicPresenter.() -> Unit)? = null,
//            myFilter: (FieldDynamicBean.() -> Boolean)? = null,
            call:((state: STATE) -> Unit)? = null
    ) = task(
            FieldDynamicPresenter::class.java,
            once,
            doJob = {
                if(setParams != null){
                    setParams()
                }
                refreshFieldDynamic(clear, type)
            }
    ){
        call?.invoke(it)
    }
}