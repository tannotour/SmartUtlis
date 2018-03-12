package com.mitnick.tannotour.smart_lib.async.funcs

import com.mitnick.tannotour.smart_lib.async.Async
import com.mitnick.tannotour.smart_lib.async.Presenter
import com.mitnick.tannotour.smart_lib.async.STATE
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mitnick on 2018/2/15.
 * Description
 */
interface Funcs {

    fun <T: Any> taskAsync(once: Boolean = true, clazz: Class<T>, doJob: T.() -> STATE, callBack: ((state: STATE) -> Unit)? = null) {
        doAsync {
            val presenterf: Presenter
            if(Async.presenters.containsKey(clazz.name)){
                presenterf = Async.presenters[clazz.name]!!
                if(once){
                    Async.presenters.remove(clazz.name)
                }
            }else{
                presenterf = Presenter(clazz.newInstance())
                if(!once){
                    Async.presenters.put(clazz.name, presenterf)
                }
            }
            val presenter: T
            if(presenterf.useing){
                presenter = clazz.newInstance()
                val state = presenter.doJob()
                uiThread {
                    callBack?.invoke(state)
                }
            }else{
                presenterf.useing = true
                presenter = presenterf.presenter as T
                val state = presenter.doJob()
                presenterf.useing = false
                uiThread {
                    callBack?.invoke(state)
                }
            }
        }
    }
}