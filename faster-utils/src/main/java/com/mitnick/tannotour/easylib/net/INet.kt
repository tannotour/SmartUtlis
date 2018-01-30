package com.mitnick.tannotour.easylib.net

import android.app.DownloadManager
import android.net.Uri
import com.mitnick.tannotour.easylib.net.client.Http
import com.mitnick.tannotour.easylib.net.client.HttpClient
import com.mitnick.tannotour.easylib.net.client.OkhttpClient
import com.mitnick.tannotour.easylib.net.params.DownloadParams
import com.mitnick.tannotour.easylib.net.params.NetParams
import com.mitnick.tannotour.easylib.net.params.NetParamsPOST


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

    /**
     * 下载文件
     * @param call 参数
     */
    fun download(
            call: DownloadParams.() -> Unit
    ): Long{
        val netParams = DownloadParams()
        netParams.call()
        val request = DownloadManager.Request(Uri.parse(netParams.url))
        netParams.headers.forEach {
            request.addRequestHeader(it.key, it.value)
        }
        if(netParams.wifiOnly){
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
        }
        request.setDestinationInExternalPublicDir(netParams.fileType, netParams.fileName)
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        request.setTitle(netParams.notificationTitle)
        request.setDescription(netParams.notificationDescription)
        request.setVisibleInDownloadsUi(true)
        if(netParams.registerProgressNotify){
            netParams.registeReceiver()
        }
        val downloadId = netParams.downloadManager.enqueue(request)
        netParams.downloadId = downloadId
        return downloadId
//        return Environment.getExternalStoragePublicDirectory(netParams.fileType).absolutePath + netParams.fileName
    }
}