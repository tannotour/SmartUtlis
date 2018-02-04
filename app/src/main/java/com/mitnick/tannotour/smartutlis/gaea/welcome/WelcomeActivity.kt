package com.mitnick.tannotour.smartutlis.gaea.welcome

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mitnick.tannotour.smartutlis.gaea.GaeaMainActivity
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.app.Activity
import android.os.Build
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.main.GaeaMainActivity2


/**
 * Created by mitnick on 2018/1/29.
 * Description
 */
class WelcomeActivity: AppCompatActivity() {

    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")
    private val REQUEST_CODE_ACCESS_COARSE_LOCATION = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.gaea_welcome_activity)
        verifyStoragePermissions(this)
        startActivity(Intent(this, GaeaMainActivity2::class.java))
        finish()
    }

    fun verifyStoragePermissions(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//如果 API level 是大于等于 23(Android 6.0) 时
            //判断是否具有权限
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //判断是否需要向用户解释为什么需要申请该权限
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    Toast.makeText(this,"自Android 6.0开始需要打开位置权限",Toast.LENGTH_SHORT).show()
                }
                //请求权限
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                        REQUEST_CODE_ACCESS_COARSE_LOCATION)
            }
        }
        try {
            //检测是否有写的权限
            val permission = ActivityCompat.checkSelfPermission(
                    activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE"
            )
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}