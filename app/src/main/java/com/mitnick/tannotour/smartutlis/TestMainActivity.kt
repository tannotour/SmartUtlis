package com.mitnick.tannotour.smartutlis

import android.os.Bundle
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mitnick.tannotour.smart_lib.T
import com.mitnick.tannotour.smart_lib.async.funcs.Funcs
import com.mitnick.tannotour.smart_lib.cache.Cache
import com.mitnick.tannotour.smart_lib.cache.bean.CacheListObj
import com.mitnick.tannotour.smart_lib.cache.disk.DiskCacheImpl
import com.mitnick.tannotour.smart_lib.cache.observer.annos.CacheReceiver
import com.mitnick.tannotour.smartutlis.test.TestPresenter
import com.mitnick.tannotour.smartutlis.test.TestPresenter2
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */
class TestMainActivity: AppCompatActivity(), Funcs{

    @CacheReceiver(cacheBean = T.Bean2::class)
    fun onValueUpdate(cacheBean: T.Bean2){
        Log.e("onNotifyValue1", "${Thread.currentThread() == Looper.getMainLooper().thread}")
    }

    @CacheReceiver(cacheBean = T.Bean::class)
    fun onListValueUpdate(cacheBean: CacheListObj<T.Bean>){
        Log.e("onNotifyList1", "${Thread.currentThread() == Looper.getMainLooper().thread}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Cache.init(application, DiskCacheImpl())
        mainActivityTextView.setOnClickListener {
//            register()
//            Thread{
//                use(T.Bean::class){
//                    add(T.Data())
//                    add(T.Data())
//                    add(T.Data())
//                    Log.e("use-List", "${Thread.currentThread() == Looper.getMainLooper().thread}")
//                }
//            }.start()
//            use(T.Bean2::class){
//                userName2 = "tannotour"
//                Log.e("use-Value", "${Thread.currentThread() == Looper.getMainLooper().thread}")
//            }
//            unRegister()
            taskAsync(
                    TestPresenter::class.java,
                    doJob = {
                        URLL = "http://www.baidu.com"
                        doGet()
                    }
            ){
                Log.e("callBack11", "${Thread.currentThread() == Looper.getMainLooper().thread}")
            }
            taskAsync(
                    TestPresenter::class.java,
                    doJob = {
                        URLL = "http://www.baidu.com"
                        doGet()
                    }
            ){
                Log.e("callBack12", "${Thread.currentThread() == Looper.getMainLooper().thread}")
            }
            taskAsync(
                    TestPresenter2::class.java,
                    doJob = {
                        URLL = "http://www.baidu.com"
                        doGet()
                    }
            ){
                Log.e("callBack21", "${Thread.currentThread() == Looper.getMainLooper().thread}")
            }
            taskAsync(
                    TestPresenter2::class.java,
                    doJob = {
                        URLL = "http://www.baidu.com"
                        doGet()
                    }
            ){
                Log.e("callBack22", "${Thread.currentThread() == Looper.getMainLooper().thread}")
            }
        }
    }
}