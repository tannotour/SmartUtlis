package com.mitnick.tannotour.smartutlis

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.net.DownlaodProgress
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean
import com.mitnick.tannotour.smartutlis.test.TestFuncs
import com.mitnick.tannotour.smartutlis.test.YY
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.delay
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

//@CacheKey(keys = arrayOf(YY::class)) , CacheListValueObserver, TestFuncs
class MainActivity : AppCompatActivity() {

//    override fun onNotify(key: Class<*>, cache: CacheList<*>) {
//        when(key){
//            YY::javaClass -> {
//                toast("收到了缓存通知${cache.size}")
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mainActivityTextView.setOnClickListener {
//            toast("开始执行耗时任务")
//            if(testFunc{
//                URLL = "http://www.baidu.com/"
//            } == STATE.SUCCESS){
//                toast("网络请求成功")
//            }else{
//                toast("网络请求失败")
//            }
//        }

//        val result = doAsyncResult {
//            var text = URL("http://www.baidu.com/").readText()
//            uiThread {
//                toast("耗时任务完成")
//            }
//            return@doAsyncResult "我是result"
//        }.get()
//        toast("0")
//        toast(result)
//        toast("1")

//        val c = FieldDynamicCacheBean::class
//        Log.e("adapter收到通知", "$c")
    }
}
