package com.mitnick.tannotour.easylib.cache.disk

import android.content.Context
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.DecimalFormat

/**
 * Created by mitnick on 2017/11/10.
 * Description
 */
interface DiskCache {

    fun init(context: Context)

//    , call:((ok: Boolean, key: String, json: String) -> Unit)? = null
    fun readFromDisk(key: String): String?

//    , call: ((ok: Boolean, key: String, obj: Any?) -> Unit)? = null
    fun writeToDisk(key: String, obj: Any?): Boolean

    fun remove(context: Context, key: String? = null): String

    fun totalSize(): String

    fun flush()

    fun encode(password: String): String {
        try {
            val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
            val digest:ByteArray = instance.digest(password.toByteArray())//对字符串加密，返回字节数组
            val sb : StringBuffer = StringBuffer()
            for (b in digest) {
                val i :Int = b.toInt() and 0xff//获取低八位有效值
                var hexString = Integer.toHexString(i)//将整数转化为16进制
                if (hexString.length < 2) {
                    hexString = "0" + hexString//如果是一位的话，补0
                }
                sb.append(hexString)
            }
            return sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    fun formetFileSize(fileS: Long?): String {
        if(fileS == null){
            return "0B"
        }
        val df = DecimalFormat("#.00")
        var fileSizeString: String
        if (fileS < 1024) {
            fileSizeString = df.format(fileS.toDouble()) + "B"
        } else if (fileS < 1048576) {
            fileSizeString = df.format(fileS.toDouble() / 1024) + "K"
        } else if (fileS < 1073741824) {
            fileSizeString = df.format(fileS.toDouble() / 1048576) + "M"
        } else {
            fileSizeString = df.format(fileS.toDouble() / 1073741824) + "G"
        }
        return fileSizeString
    }
}