package com.mitnick.tannotour.easylib.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Response
import java.lang.reflect.Type

/**
 * Created by mitnick on 2017/12/13.
 * Description
 */

fun <T> Response.toObj(clazz: Class<T>): Obj<T>{
    val body = body()
    if (body == null) {
        return Obj(
                code(),
                isSuccessful,
                isRedirect,
                ""
        )
    }else{
        return Obj(
                code(),
                isSuccessful,
                isRedirect,
                body.string()
        )
    }
}

fun <T> Response.toObjString(): Obj<T>{
    var body = ""
    if(body() != null){
        body = body()!!.string()
    }
    return Obj(
            code(),
            isSuccessful,
            isRedirect,
            body,
            null
    )
}

class Obj<T>(
        var code: Int,
        var isSuccessful: Boolean,
        var isRedirect: Boolean,
        var bodyJson: String,
        var body: T? = null
){
    fun convert(clazz: Class<T>): Obj<T>{
        body = Gson().fromJson(bodyJson, clazz)
        return this
    }
}

fun <T> Response.getData(): com.mitnick.tannotour.easylib.net.Response<T>{
    var body = ""
    if(body() != null){
        body = body()!!.string()
    }
    return com.mitnick.tannotour.easylib.net.Response<T>(
            code(),
            isSuccessful,
            isRedirect,
            body
    )
}
class Response<T>(
        var code: Int,
        var isSuccessful: Boolean,
        var isRedirect: Boolean,
        var bodyJson: String,
        var body: T? = null
){
    fun convert(clazz: Class<T>): com.mitnick.tannotour.easylib.net.Response<T>{
        body = Gson().fromJson(bodyJson, clazz)
        return this
    }
}

class CODE{
    companion object {
        val CODE_SUCCESSFUL = 200
    }
}