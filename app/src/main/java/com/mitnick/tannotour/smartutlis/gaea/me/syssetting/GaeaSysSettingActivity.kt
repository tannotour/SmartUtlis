package com.mitnick.tannotour.smartutlis.gaea.me.syssetting

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaLoginActivity
import kotlinx.android.synthetic.main.gaea_sys_setting_activity.*

/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
class GaeaSysSettingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_sys_setting_activity)
        gaeaSysSettingBufferSize.text = Cache.getSize()
        gaeaSysSettingBack.setOnClickListener { finish() }
        gaeaSysSettingLogout.setOnClickListener {
            Cache.remove(applicationContext)
            startActivity(Intent(this, GaeaLoginActivity::class.java))
            finish()
        }
        gaeaSysSettingBufferSize.setOnClickListener {
            Cache.remove(applicationContext)
            gaeaSysSettingBufferSize.text = "0B"
        }
    }
}