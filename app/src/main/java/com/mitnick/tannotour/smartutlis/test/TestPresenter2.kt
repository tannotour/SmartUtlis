package com.mitnick.tannotour.smartutlis.test

import android.os.Looper
import android.util.Log
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.CODE
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.easylib.net.toObj

/**
 * Created by mitnick on 2017/11/27.
 * Description
 */
class TestPresenter2: INet {
    var URLL: String = ""
    fun doPost(): STATE {
        /* 请求网络 */
        val response = get<YY> {
            url = URLL
        }.convert(YY::class.java)
        println("网络请求完成：\n${response?.body?.toString()}")
        /* 写缓存 */
        Cache.use(YY::class.java){
            for (i in arrayOf(1, 2, 3, 4, 5)){
                add(TestCacheBean())
                println("添加了一个数据：$i")
            }
        }
        /* 返回执行结果 */
        if(response?.code == CODE.CODE_SUCCESSFUL){
            return STATE.SUCCESS
        }else{
            return STATE.FAILED
        }
    }

    fun doGet(): com.mitnick.tannotour.smart_lib.async.STATE {
        Log.e("doGet2", "$this->${Thread.currentThread() == Looper.getMainLooper().thread}")
        /* 请求网络 */
        val response = get<YY> {
            url = URLL
        }//.convert(YY::class.java)
//        println("网络请求完成：\n${response?.body?.toString()}")
//        /* 写缓存 */
//        Cache.use(YY::class.java){
//            for (i in arrayOf(1, 2, 3, 4, 5)){
//                add(TestCacheBean())
//                println("添加了一个数据：$i")
//            }
//        }
//        /* 返回执行结果 */
//        if(response?.code == CODE.CODE_SUCCESSFUL){
//            return com.mitnick.tannotour.smart_lib.async.STATE()
//        }else{
//            return com.mitnick.tannotour.smart_lib.async.STATE()
//        }
        val state = com.mitnick.tannotour.smart_lib.async.STATE()
        state.msg = response.toString()
        return state
    }
}