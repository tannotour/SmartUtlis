package com.mitnick.tannotour.smart_lib.net.params

import com.mitnick.tannotour.smart_lib.net.HttpClient
import java.util.HashMap

/**
 * Created by mitnick on 2017/12/15.
 * Description
 */
class NetParamsPOST: NetParams() {
    /* 提交的文本数据 */
    val data: HashMap<String, String> = HashMap()
    /* 提交的文件路径列表 */
    val files: HashMap<String, HttpClient.FileType> = HashMap()
}