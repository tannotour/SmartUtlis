package com.mitnick.tannotour.smart_lib.http

import android.util.Log
import com.mitnick.tannotour.smart_lib.http.log.Okhttp3LoggingInterceptor
import okhttp3.*
import java.io.File
import java.util.HashMap
import okhttp3.OkHttpClient
import okhttp3.Cookie
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

/**
 * Created by mitnick on 2017/12/26.
 * Description
 */
object OkhttpClient: HttpClient {

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(
            Okhttp3LoggingInterceptor(
                    Okhttp3LoggingInterceptor.Logger { message ->
                        Log.e("OkhttpClient", message)
                    }
            ).setLevel(Okhttp3LoggingInterceptor.Level.BODY)
    ).cookieJar(
            object : CookieJar{
                private val cookieStore = HashMap<String, MutableList<Cookie>>()
                override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
                    cookieStore.put(url.host(), cookies)
                }

                override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
                    val cookies = cookieStore[url.host()]
                    return cookies ?: ArrayList<Cookie>()
                }

            }
    ).build()

    override fun <T> get(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>
    ): HttpClient.Response<T> {
        val builder = Request.Builder().url(generateURL(url, params))
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val request = builder.build()
        val call = okHttpClient.newCall(request)
        val response = call.execute()
        val result = HttpClient.Response<T>(response.code(), response.body()?.string())
        return result
    }

    override fun <T> post(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>,
            data: HashMap<String, String>,
            files: Map<String, HttpClient.FileType>
    ): HttpClient.Response<T> {
        val builder = Request.Builder().url(generateURL(url, params))
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
        data.forEach {
            body.addFormDataPart(it.key, it.value)
        }
        if(files.isNotEmpty()){
            files.forEach {
                val file = File(it.key)
                when(it.value){
                    HttpClient.FileType.TYPE_FILE -> {
                        body.addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"files\";filename=\"${file.name}\""),
                                RequestBody.create(
                                        MediaType.parse("text/plain"),
                                        file
                                )
                        )
                    }
                    HttpClient.FileType.TYPE_IMAGE -> {
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
        val response = call.execute()
        val result = HttpClient.Response<T>(response.code(), response.body()?.string())
        return result
    }

    override fun download(
            url: String,
            headers: HashMap<String, String>,
            params: HashMap<String, String>,
            file: File,
            listener: HttpClient.OnDownloadListener
    ): Any {
        val builder = Request.Builder().url(generateURL(url, params))
        headers.forEach {
            builder.addHeader(it.key, it.value)
        }
        val request = builder.build()
        val call = okHttpClient.newCall(request)
        call.enqueue(
                object : Callback{
                    override fun onFailure(callP: Call, e: IOException) {
                        listener.onDownloadFailed()
                    }

                    override fun onResponse(callP: Call, response: Response) {
                        var ins: InputStream? = null
                        val buf = ByteArray(2048)
                        var len = 0
                        var fos: FileOutputStream? = null
                        try {
                            ins = response.body()!!.byteStream()
                            val total = response.body()!!.contentLength()
                            fos = FileOutputStream(file)
                            var sum: Long = 0
                            while (len != -1) {
                                len = ins!!.read(buf)
                                fos.write(buf, 0, len)
                                sum += len.toLong()
                                val progress = (sum * 1.0f / total * 100).toInt()
                                // 下载中
                                listener.onDownloading(progress)
                            }
                            fos.flush()
                            // 下载完成
                            listener.onDownloadSuccess(file)
                        } catch (e: Exception) {
                            listener.onDownloadFailed()
                        } finally {
                            try {
                                if (ins != null)
                                    ins.close()
                            } catch (e: IOException) {
                            }

                            try {
                                if (fos != null)
                                    fos.close()
                            } catch (e: IOException) {
                            }
                        }
                    }
                }
        )
        return call
    }

    private fun generateURL(url: String, params: HashMap<String, String>): String{
        var result = url
        if(params.isNotEmpty()){
            params.entries.forEachIndexed { index, entry ->
                if(index == 0){
                    result += "?"
                }else{
                    result += "&"
                }
                result = result + entry.key + "=" + entry.value
            }
        }
        return result
    }
}