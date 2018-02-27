package com.mitnick.tannotour.smartutlis.gaea

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.dynamic.GaeaDynamicFragment
import kotlinx.android.synthetic.main.gaea_main_activity.*
import com.mitnick.tannotour.smartutlis.gaea.util.magnetic.SensorService
import android.content.Intent
import com.mitnick.tannotour.smartutlis.test.MyApp


/**
 * Created by mitnick on 2018/1/24.
 * Description
 */
class GaeaMainActivity: AppCompatActivity() {

    val fragments: ArrayList<Fragment> = ArrayList()
    var oldIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_main_activity)
        fragments.add(GaeaDynamicFragment())
        fragments.add(GaeaDynamicFragment())
        fragments.add(GaeaDynamicFragment())
        fragments.add(GaeaDynamicFragment())
        fragments.add(GaeaDynamicFragment())
        switchFragment(2)
        gaeaMainRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.gaeaMainRadioMessage -> {
                    switchFragment(0)
                }
                R.id.gaeaMainRadioWeather -> {
                    switchFragment(1)
                }
                R.id.gaeaMainRadioMain -> {
                    switchFragment(2)
                }
                R.id.gaeaMainRadioShare -> {
                    switchFragment(3)
                }
                R.id.gaeaMainRadioMe -> {
                    switchFragment(4)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        /* 开始采集磁场数据 */
        MyApp.visible = true
        val intent = Intent()
        intent.setClass(this, SensorService::class.java)
        startService(intent)
    }

    private fun switchFragment(to: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        if(oldIndex == -1){
            transaction.add(R.id.gaeaMainContent, fragments[to]).commit()
        }else if (!fragments[to].isAdded) {
            // 隐藏当前的fragment，add下一个到Activity中
            transaction.hide(fragments[oldIndex]).add(R.id.gaeaMainContent, fragments[to]).commit()
        } else {
            // 隐藏当前的fragment，显示下一个
            transaction.hide(fragments[oldIndex]).show(fragments[to]).commit()
        }
        oldIndex = to
    }
}