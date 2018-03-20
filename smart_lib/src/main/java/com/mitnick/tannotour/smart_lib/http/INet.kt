package com.mitnick.tannotour.smart_lib.http

import com.mitnick.tannotour.smart_lib.http.params.NetParams
import com.mitnick.tannotour.smart_lib.http.params.NetParamsPOST
import java.io.File


/**
 * Created by mitnick on 2017/12/9.
 * Description
 */
interface INet {

    /**
     * GET请求
     */
    fun <T> get(
            client: HttpClient = OkhttpClient,
            clazz: Class<T>,
            setParams: NetParams.() -> Unit
    ): HttpClient.Response<T> {
        val netParams = NetParams()
        netParams.setParams()
        val netResult = client.get<T>(netParams.url, netParams.headers, netParams.params)
        return netResult.convert(clazz)
    }

    /**
     * POST请求
     */
    fun <T> post(
            client: HttpClient = OkhttpClient,
            clazz: Class<T>,
            setParams: NetParamsPOST.() -> Unit
    ): HttpClient.Response<T> {
        val netParams = NetParamsPOST()
        netParams.setParams()
        val netResult = client.post<T>(netParams.url, netParams.headers, netParams.params, netParams.data, netParams.files)
        return netResult.convert(clazz)
    }

    /**
     * 下载
     */
    fun download(
            client: HttpClient = OkhttpClient,
            setParams: NetParams.() -> Unit,
            file: File,
            listener: HttpClient.OnDownloadListener
    ): Any{
        val netParams = NetParams()
        netParams.setParams()
        return client.download(netParams.url, netParams.headers, netParams.params, file, listener)
    }
}