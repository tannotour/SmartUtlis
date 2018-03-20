package com.mitnick.tannotour.smart_lib.http

import com.mitnick.tannotour.smart_lib.convert.Converter
import java.io.File
import java.util.HashMap

/**
 * Created by mitnick on 2018/2/17.
 * Description
 */
interface HttpClient {

    /**
     * GET 请求
     */
    fun <T> get(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>
    ): Response<T>

    /**
     * POST请求
     */
    fun <T> post(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>,
            data: HashMap<String, String>,
            files: Map<String, FileType>
    ): Response<T>

    /**
     * 下载
     */
    fun download(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>,
            file: File,
            listener: OnDownloadListener
    ): Any

    class Response<T>(
            var code: Int = 0,
            var bodyJson: String? = null
    ){

        var body: T? = null

        fun convert(clazz: Class<T>): Response<T>{
            val result = Converter.convert(bodyJson?:"", clazz)
            if(result == null){
                body = clazz.newInstance()
            }else{
                body = result
            }
            return this
        }
    }

    interface OnDownloadListener {
        /**
         * 下载成功
         */
        fun onDownloadSuccess(file: File)

        /**
         * @param progress
         * 下载进度
         */
        fun onDownloading(progress: Int)

        /**
         * 下载失败
         */
        fun onDownloadFailed()
    }

    enum class FileType {
        TYPE_FILE,
        TYPE_IMAGE
    }
}