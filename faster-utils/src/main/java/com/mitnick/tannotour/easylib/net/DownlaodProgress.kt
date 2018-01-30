package com.mitnick.tannotour.easylib.net

import com.mitnick.tannotour.easylib.cache.CacheBean

/**
 * Created by mitnick on 2018/1/4.
 * Description 下载进度监听cache
 */
@CacheBean(isList = false, autoSync = false)
class DownlaodProgress {
    var totalLen: Long = -1
    var currentLen: Long = -1
    var totalSize: String = ""
    var currentSize: String = ""
    var progress: Double = 0.0
}