package com.mitnick.tannotour.easylib.net.client

import com.google.gson.Gson
import com.mitnick.tannotour.easylib.net.Obj
import com.mitnick.tannotour.easylib.net.Response
import com.mitnick.tannotour.easylib.net.getData
import com.mitnick.tannotour.easylib.net.params.FileType
import com.mitnick.tannotour.easylib.net.toObj
import okhttp3.*
import java.io.File
import java.util.HashMap

/**
 * Created by mitnick on 2017/12/26.
 * Description
 */
object OkhttpClient: HttpClient {

    private var okHttpClient: OkHttpClient = OkHttpClient()

    override fun <T> get(url: String, headers: HashMap<String, String>): Response<T> {
        val builder = Request.Builder().url(url)
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val request = builder.build()
        val call = okHttpClient.newCall(request)
        return call.execute().getData()
    }

    override fun <T> post(url: String, headers: HashMap<String, String>, data: HashMap<String, String>, dataKey: String, dataObj: Any?, files: Map<FileType, String>): Response<T> {
        val builder = Request.Builder().url(url)
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
        data.forEach {
            body.addFormDataPart(it.key, it.value)
        }
        if(dataObj == null){
            body.addFormDataPart(dataKey, Gson().toJson(dataObj))
        }
        if(files.isNotEmpty()){
            files.forEach {
                val file = File(it.value)
                when(it.key){
                    FileType.TYPE_FILE -> {
                        body.addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"file.${file.extension}\""),
                                RequestBody.create(
                                        MediaType.parse("text/plain"),
                                        file
                                )
                        )
                    }
                    FileType.TYPE_IMAGE -> {
                        body.addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"file.${file.extension}\""),
                                RequestBody.create(
                                        MediaType.parse("image/png"),
                                        file
                                )
                        )
                    }
                }
            }
        }
        val request = builder.post(body.build()).build()
        val call = okHttpClient.newCall(request)
        return call.execute().getData()
    }
}