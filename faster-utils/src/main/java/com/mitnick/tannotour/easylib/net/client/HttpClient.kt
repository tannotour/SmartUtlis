package com.mitnick.tannotour.easylib.net.client

import com.mitnick.tannotour.easylib.net.Obj
import com.mitnick.tannotour.easylib.net.Response
import com.mitnick.tannotour.easylib.net.params.FileType
import java.util.HashMap

/**
 * Created by mitnick on 2017/12/26.
 * Description
 */
interface HttpClient {

    /**
     * GET 请求
     */
    fun <T> get(
            url: String,
            headers: HashMap<String, String>
    ): Response<T>

    /**
     * POST请求
     */
    fun <T> post(
            url: String,
            headers: HashMap<String, String>,
            data: HashMap<String, String> = HashMap(),
            dataKey: String = "data",
            dataObj: Any? = null,
            files: Map<String, FileType> = HashMap()
    ): Response<T>
}