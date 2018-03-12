package com.mitnick.tannotour.smart_lib.convert

import android.util.Log
import com.google.gson.Gson

/**
 * Created by mitnick on 2018/2/15.
 * Description
 */
object Converter {

    private val TAG = "Converter"

    fun <T> convert(json: String, clazz: Class<T>): T?{
        var result: T? = null
        try {
            if(json.isNotEmpty()){
                result = Gson().fromJson(json, clazz)
            }else{
                Log.e(TAG, "json为空，转化失败")
            }
        }catch (e: Exception){
            e.printStackTrace()
        }finally {
            return result
        }
    }
}