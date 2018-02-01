package com.mitnick.tannotour.easylib.async

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


/**
 * Created by mitnick on 2017/11/14.
 * Description
 */

object Async{
    val presenters: HashMap<String, Presenter> = HashMap()
    val errors: HashMap<String, String> = HashMap()
}

class Presenter(var presenter: Any){
    var useing: Boolean = false
}

enum class STATE{
    SUCCESS, FAILED
}

fun <T: Any> Funcs.task(clazz: Class<T>, once: Boolean = false, doJob: T.() -> STATE, callBack: ((state: STATE) -> Unit)? = null) {
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

fun <T: Any> Funcs.writeError(clazz: Class<T>, errorMsg: String){
    Async.errors.put(clazz.name, errorMsg)
}

fun <T: Any> Any.error(clazz: Class<T>, autoClear: Boolean = true): String{
    if(Async.errors.containsKey(clazz.name)){
        val error = Async.errors[clazz.name]!!
        if(autoClear){
            Async.errors.remove(clazz.name)
        }
        return error
    }else{
        return ""
    }
}
