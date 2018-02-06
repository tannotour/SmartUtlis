package com.mitnick.tannotour.smartutlis.gaea.me.setting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mitnick.tannotour.smartutlis.R
import kotlinx.android.synthetic.main.gaea_sys_setting_activity.*

/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
class GaeaSysSettingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_sys_setting_activity)
        gaeaSysSettingBack.setOnClickListener { finish() }
    }
}