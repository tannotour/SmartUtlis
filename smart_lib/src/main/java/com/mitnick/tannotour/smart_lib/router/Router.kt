package com.mitnick.tannotour.smart_lib.router

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.Build
import android.util.Log
import com.mitnick.tannotour.smart_lib.router.annos.ForegroundService
import com.mitnick.tannotour.smart_lib.router.annos.PathDynamic
import com.tannotour.smart_lib_annotation.IRouteTable
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2018/4/10.
 * Description
 */
object Router {

    private val TAG = "Router"
    /* 路由表 */
    private val routerTable = HashMap<String, String>()

    /**
     * 初始化编译期生成的路由表
     */
    fun initRouteTable(){
        try {
            val clazz = Class.forName("com.tannotour.router.RouteTable").newInstance() as IRouteTable
            clazz.routes().forEach {
                if(routerTable.containsKey(it.key)){
                    Log.e(TAG, "initRouteTable-已存在相同的路由------>path:${it.key}，新className:${it.value}，旧className:${routerTable[it.key]}")
                }else{
                    routerTable.put(it.key, it.value)
                }
            }
        }catch (exception: ClassNotFoundException){
            exception.printStackTrace()
            Log.e(TAG, "未找到编译期生成的路由表，跳过自动初始化，需要手动添加路由")
        }
    }

    /**
     * 运行时动态添加到路由表中
     * @param forced 强制添加，若已存在对应路径的路由则覆盖已存在的路由
     */
    fun Any.add2Router(forced: Boolean = false){
        if(this.javaClass.isAnnotationPresent(PathDynamic::class.java)){
            val anno = this.javaClass.getAnnotation(PathDynamic::class.java)
            val path = anno.path
            val clazzName = this::class.jvmName
            if(routerTable.containsKey(path)){
                Log.e(TAG, "add2Router-已存在相同的路由------>path:$path，新className:$clazzName，旧className:${routerTable[path]}")
                if(forced){
                    routerTable.remove(path)
                    routerTable.put(path, clazzName)
                }
            }else{
                routerTable.put(path, clazzName)
            }
        }else{
            Log.e(TAG, "$this 必须使用PathDynamic注解修饰")
        }
    }

    /**
     * 跳转到activity或者service
     * @param path 路径
     * @param intent 意图，默认为空，此时为不带任何数据的跳转
     */
    fun Activity.go(
            path: String,
            intent: Intent? = null
    ){
        if(!routerTable.containsKey(path)){
            Log.e(TAG, "未发现路径$path 对应的activity，取消跳转。")
            return
        }
        val clazzName = routerTable[path]
        val mIntent = intent ?: Intent()
        mIntent.setClassName(this, clazzName)
        val clazz = Class.forName(clazzName)
        if(clazz is Activity){
            startActivity(mIntent)
        }else if(clazz is Service){
            if(clazz.isAnnotationPresent(ForegroundService::class.java)){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(mIntent)
                }else{
                    Log.e(TAG, "路径$path 对应的service为ForegroundService，必须在API26及以上才可用，取消跳转。")
                }
            }else{
                startService(mIntent)
            }
        }
    }

    /**
     * 跳转到activity，要求有结果返回
     * @param path 路径
     * @param requestCode 返回Code
     * @param intent 意图，默认为空，此时为不带任何数据的跳转
     */
    fun Activity.goActivityForResult(
            path: String,
            requestCode: Int,
            intent: Intent? = null
    ){
        if(!routerTable.containsKey(path)){
            Log.e(TAG, "未发现路径$path 对应的activity，取消跳转。")
            return
        }
        val clazzName = routerTable[path]
        val clazz = Class.forName(clazzName)
        if(clazz !is Activity){
            Log.e(TAG, "路径$path 对应的activity为$clazzName，不是一个activity，取消跳转。")
            return
        }
        val mIntent = intent ?: Intent()
        mIntent.setClassName(this, clazzName)
        startActivityForResult(mIntent, requestCode)
    }
}