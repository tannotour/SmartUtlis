package com.mitnick.tannotour.easylib.net

import com.mitnick.tannotour.easylib.net.client.Http
import com.mitnick.tannotour.easylib.net.client.HttpClient
import com.mitnick.tannotour.easylib.net.client.OkhttpClient
import com.mitnick.tannotour.easylib.net.params.NetParams
import com.mitnick.tannotour.easylib.net.params.NetParamsPOST
import okhttp3.Response
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2017/12/9.
 * Description
 */
interface INet {

    /**
     * GET方式请求服务器
     * @param call 参数
     */
    fun <T> get(
            client: HttpClient = OkhttpClient,
            call: NetParams.() -> Unit
    ): com.mitnick.tannotour.easylib.net.Response<T> {
        val netParams = NetParams()
        netParams.call()
        return Http.build {
            httpClient = client
            if(netParams.url.isNotEmpty()){
                url = netParams.url
            }
            if(netParams.headers.isNotEmpty()){
                netParams.headers.forEach {
                    headers.put(it.key, it.value)
                }
            }
            if(netParams.params.isNotEmpty()){
                url += "?"
                netParams.params.forEach {
                    url = url + it.key + "=" + it.value + "&"
                }
            }
        }.get()
    }

    /**
     * POST方式请求服务器
     * @param call 参数
     */
    fun <T> post(
            client: HttpClient = OkhttpClient,
            call: NetParamsPOST.() -> Unit
    ): com.mitnick.tannotour.easylib.net.Response<T> {
        val netParams = NetParamsPOST()
        netParams.call()
        return Http.build {
            httpClient = client
            if(netParams.url.isNotEmpty()){
                url = netParams.url
            }
            if(netParams.headers.isNotEmpty()){
                netParams.headers.forEach {
                    headers.put(it.key, it.value)
                }
            }
            if(netParams.params.isNotEmpty()){
                url += "?"
                netParams.params.forEach {
                    url = url + it.key + "=" + it.value + "&"
                }
            }
        }.post(
                netParams.data,
                netParams.dataKey,
                netParams.dataObj,
                netParams.files
        )
    }

//    /**
//     * GET方式请求服务器
//     * @param call 参数
//     */
//    fun get(
//            call: NetParams.() -> Unit
//    ): Response {
//        val netParams = NetParams()
//        netParams.call()
//        return Http.build {
//            if(netParams.url.isNotEmpty()){
//                url = netParams.url
//            }
//            if(netParams.headers.isNotEmpty()){
//                netParams.headers.forEach {
//                    headers.put(it.key, it.value)
//                }
//            }
//            if(netParams.params.isNotEmpty()){
//                url += "?"
//                netParams.params.forEach {
//                    url = url + it.key + "=" + it.value + "&"
//                }
//            }
//        }.get()
//    }
//
//    /**
//     * POST方式请求服务器
//     * @param call 参数
//     */
//    fun post(
//            call: NetParamsPOST.() -> Unit
//    ): Response {
//        val netParams = NetParamsPOST()
//        netParams.call()
//        return Http.build {
//            if(netParams.url.isNotEmpty()){
//                url = netParams.url
//            }
//            if(netParams.headers.isNotEmpty()){
//                netParams.headers.forEach {
//                    headers.put(it.key, it.value)
//                }
//            }
//            if(netParams.params.isNotEmpty()){
//                url += "?"
//                netParams.params.forEach {
//                    url = url + it.key + "=" + it.value + "&"
//                }
//            }
//        }.post(
//                netParams.data,
//                netParams.dataKey,
//                netParams.dataObj,
//                netParams.files
//        )
//    }
}