package com.mitnick.tannotour.easylib.net.client

import android.util.Log
import com.google.gson.Gson
import com.mitnick.tannotour.easylib.net.*
import com.mitnick.tannotour.easylib.net.Response
import com.mitnick.tannotour.easylib.net.params.FileType
import okhttp3.*
import java.io.File
import java.util.HashMap
import okhttp3.OkHttpClient



/**
 * Created by mitnick on 2017/12/26.
 * Description
 */
object OkhttpClient: HttpClient {

//    private var okHttpClient: OkHttpClient = OkHttpClient()

//    init {
//        val builder = OkHttpClient.Builder()
//        builder.addInterceptor(
//                Okhttp3LoggingInterceptor(
//                        Okhttp3LoggingInterceptor.Logger { message ->
//                            Log.e("OkhttpClient", message)
//                        }
//                ).setLevel(Okhttp3LoggingInterceptor.Level.BODY)
//        )
//        okHttpClient = builder.build()
//    }

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(
            Okhttp3LoggingInterceptor(
                    Okhttp3LoggingInterceptor.Logger { message ->
                        Log.e("OkhttpClient", message)
                    }
            ).setLevel(Okhttp3LoggingInterceptor.Level.BODY)
    ).build()

    override fun <T> get(url: String, headers: HashMap<String, String>): Response<T> {
        val builder = Request.Builder().url(url)
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val request = builder.build()
        val call = okHttpClient.newCall(request)
        return call.execute().getData()
    }

    override fun <T> post(url: String, headers: HashMap<String, String>, data: HashMap<String, String>, dataKey: String, dataObj: Any?, files: Map<String, FileType>): Response<T> {
        val builder = Request.Builder().url(url)
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
        data.forEach {
            body.addFormDataPart(it.key, it.value)
        }
        if(dataObj != null){
            body.addFormDataPart(dataKey, Gson().toJson(dataObj))
        }
        if(files.isNotEmpty()){
            files.forEach {
                val file = File(it.key)
                when(it.value){
                    FileType.TYPE_FILE -> {
                        body.addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"files\";filename=\"${file.name}\""),
                                RequestBody.create(
                                        MediaType.parse("text/plain"),
                                        file
                                )
                        )
//                        body.addFormDataPart(
//                                "files",
//                                it.value.split("/").last(),
//                                RequestBody.create(
//                                        MediaType.parse("text/plain"),
//                                        file
//                                )
//                        )
                    }
                    FileType.TYPE_IMAGE -> {
//                        body.addPart(
//                                Headers.of("Content-Disposition", "form-data; name=\"files\";filename=\"${file.name}\"", "Content-Transfer-Encoding", "binary"),
//                                RequestBody.create(
//                                        MediaType.parse("image/*"),
//                                        file
//                                )
//                        )
                        body.addFormDataPart(
                                "files",
                                file.name,
                                RequestBody.create(
                                        MediaType.parse("image/*"),
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