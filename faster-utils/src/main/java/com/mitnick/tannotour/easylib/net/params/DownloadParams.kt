package com.mitnick.tannotour.easylib.net.params

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Environment
import com.mitnick.tannotour.easylib.LibInit

/**
 * Created by mitnick on 2018/1/4.
 * Description
 */
class DownloadParams: NetParams() {
    lateinit var downloadManager: DownloadManager
    var wifiOnly: Boolean = false
    var fileType: String = Environment.DIRECTORY_DOWNLOADS
    var fileName: String = "file_download"
    var notificationTitle: String = ""
    var notificationDescription: String = ""
    var registerProgressNotify: Boolean = true
    var downloadId: Long = -1
//    var context: Context? = null
    private val progressReceriver = object: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            val query = DownloadManager.Query()
            //通过下载的id查找
            query.setFilterById(downloadId)
            val cursor = downloadManager.query(query)
            cursor.use {
                if(it != null && it.moveToFirst()){
                    val status = it.getInt(it.getColumnIndex(DownloadManager.COLUMN_STATUS))
                    when(status){
                        DownloadManager.STATUS_PAUSED -> {
                            /* 下载暂停 */
                        }
                        DownloadManager.STATUS_PENDING -> {
                            /* 下载延迟 */
                        }
                        DownloadManager.STATUS_RUNNING -> {
                            /* 正在下载 */
                        }
                        DownloadManager.STATUS_SUCCESSFUL -> {
                            /* 下载完成 */
                            LibInit.applicaion?.get()?.unregisterReceiver(this)
                        }
                        DownloadManager.STATUS_FAILED -> {
                            /* 下载失败 */
                            LibInit.applicaion?.get()?.unregisterReceiver(this)
                        }
                    }
                    val bytesCurrentLen = it.getInt(it.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                    val bytestotalLen = it.getInt(it.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                }
            }
        }
    }

    fun registeReceiver(){
        LibInit.applicaion?.get()?.registerReceiver(
                progressReceriver,
                IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }

    fun unregisteReceiver(){
        LibInit.applicaion?.get()?.unregisterReceiver(progressReceriver)
    }
}