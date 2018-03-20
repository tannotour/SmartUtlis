package com.mitnick.tannotour.smart_lib.async

import java.util.concurrent.locks.ReentrantLock

/**
 * Created by mitnick on 2018/2/15.
 * Description
 */
object Async {

    private val presenters: HashMap<String, Presenter> = HashMap()

    fun <T: Any> get(clazz: Class<T>, doJob: T.() -> STATE): STATE {
        if(!presenters.contains(clazz.name)){
            synchronized(Async::class.java){
                if(!presenters.contains(clazz.name)){
                    presenters.put(clazz.name, Presenter(clazz.newInstance(), ReentrantLock()))
                }
            }
        }
        return presenters[clazz.name]!!.use<T> { doJob() }
    }
}