package com.mitnick.tannotour.smart_lib.async

import java.util.concurrent.locks.ReentrantLock

/**
 * Created by mitnick on 2018/2/15.
 * Description
 */
class Presenter(private var presenter: Any, private var mLock: ReentrantLock){

    fun <T: Any> use(doJob: T.() -> STATE): STATE{
        val result: STATE
        try{
            mLock.lock()
            result = (presenter as T).doJob()
        }finally {
            mLock.unlock()
        }
        return result
    }
}