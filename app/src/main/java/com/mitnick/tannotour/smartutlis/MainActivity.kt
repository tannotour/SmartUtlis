package com.mitnick.tannotour.smartutlis

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.test.YY
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.smartutlis.test.TestFuncs
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

@CacheKey(keys = arrayOf(YY::class))
class MainActivity : AppCompatActivity(), CacheListValueObserver, TestFuncs {

    override fun onNotify(key: Class<*>, cache: CacheList<*>?) {
        when(key){
            YY::javaClass -> {
                toast("收到了缓存通知${cache?.size}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityTextView.setOnClickListener {
            toast("开始执行耗时任务")
            if(testFunc{
                URLL = "http://www.baidu.com/"
            } == STATE.SUCCESS){
                toast("网络请求成功")
            }else{
                toast("网络请求失败")
            }
        }
    }
}
