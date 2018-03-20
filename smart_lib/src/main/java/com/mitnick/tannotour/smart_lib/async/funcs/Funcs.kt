package com.mitnick.tannotour.smart_lib.async.funcs

import com.mitnick.tannotour.smart_lib.async.Async
import com.mitnick.tannotour.smart_lib.async.STATE
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2018/2/15.
 * Description
 */
interface Funcs {

    fun <T: Any> taskAsync(clazz: Class<T>, doJob: T.() -> STATE, callBack: ((state: STATE) -> Unit)? = null){
        doAsync {
            val state = Async.get(clazz){ doJob() }
            uiThread {
                callBack?.invoke(state)
            }
        }
    }
}