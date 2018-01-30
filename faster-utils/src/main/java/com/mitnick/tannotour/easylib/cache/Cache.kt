package com.mitnick.tannotour.easylib.cache

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.mitnick.tannotour.easylib.cache.disk.Disk
import com.mitnick.tannotour.easylib.cache.disk.DiskCache
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import org.jetbrains.anko.doAsync
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2017/11/9.
 * Description
 */
object Cache {
    private val TAG = "Cache"

    private val caches: ConcurrentHashMap<String, Any> = ConcurrentHashMap()
//    private val caches: ConcurrentHashMap<String, ConcurrentHashMap<String, Any>> = ConcurrentHashMap()
    private val needUpdateToDisk: LinkedList<String> = LinkedList()
    private val changed: LinkedList<String> = LinkedList()
    private val observers: ConcurrentHashMap<String, ArrayList<CacheObserver>> = ConcurrentHashMap()
    private var disk: DiskCache = Disk()

    fun init(context: Context){
        disk.init(context)
    }

    fun setDisk(diskCache: DiskCache){
        disk = diskCache
    }

    fun flush(){
        disk.flush()
    }

    fun addObserver(observer: CacheObserver): Boolean{
        val cacheKey: CacheKey
        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
            Log.e(TAG, "数据源观察者${observer::javaClass.name}未使用CacheKey注解")
            return false
        }else {
            cacheKey = observer.javaClass.getAnnotation(CacheKey::class.java)
            cacheKey.keys.forEach {
                val cacheBean = Class.forName(it.jvmName).getAnnotation(CacheBean::class.java)
//                val cacheBean = it::class.java.getAnnotation(CacheBean::class.java)
                if(cacheBean != null){
                    if((cacheBean.isList) && (observer !is CacheListValueObserver)){
                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
                        return false
                    }
                    if((!cacheBean.isList) && (observer !is CacheValueObserver)){
                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
                        return false
                    }

                }else{
                    Log.e(TAG, "Cache初始化错误NULL")
                    return false
                }
            }
        }
        doAsync {
            val secondKeys = observer.secondKey()
            cacheKey.keys.forEach{
                val key = it.jvmName + "-" + secondKeys
//                val key = it.jvmName
                if(!observers.containsKey(key)){
                    observers.put(key, ArrayList<CacheObserver>())
                }
                if(!observers[key]?.contains(observer)!!){
                    observers[key]?.add(observer)
                }
                val cache: Any
                if(!caches.containsKey(key)){
                    val json = disk.readFromDisk(key)
                    if(json == null || json.isEmpty()){
                        cache = Class.forName(it.jvmName).newInstance()
                    }else{
                        cache = Gson().fromJson(json, Class.forName(it.jvmName))
                    }
                    caches.put(key, cache)
                }else{
                    cache = caches[key]!!
                }
                val anno = cache::class.java.getAnnotation(CacheBean::class.java)
                if(anno == null){
                    Log.e(TAG, "无法获取初始化Cache(${cache::class.java.name})数据，绑定时初始化失败，请添加CacheKey注解。")
                }else{
                    notifyObserver(key, anno.isList, cache, observer)
                }
            }
        }
        return true
    }

    fun removeObserver(observer: CacheObserver): Boolean{
        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
            return false
        }
        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
            val key = it.jvmName + "-" + observer.secondKey()
            observers[key]?.remove(observer)
            if(observers[key]?.isEmpty() as Boolean){
                observers.remove(key)
                val cache = caches[key]
                if(cache != null){
                    val autoSync = cache.javaClass.getAnnotation(CacheBean::class.java).autoSync
                    if(!autoSync){
                        /* 更新cache到disk */
                        sync(cache, observer.secondKey())
                    }else if(needUpdateToDisk.contains(key)){
                        needUpdateToDisk.remove(key)
                        sync(cache, observer.secondKey())
                    }
                    caches.remove(it.jvmName)
                }

            }
        }
        return true
    }

    fun notifyObserver(key: String, isList: Boolean, cache: Any){
        observers[key]?.forEach {
            notifyObserver(key, isList, cache, it)
        }
        if(isList){
            (cache as CacheList<*>).clearRecord()
        }
    }

    fun notifyObserver(key: String, isList: Boolean, cache: Any, observer: CacheObserver){
        if(isList){
            val cacheTrue = (cache as CacheList<*>)
            (observer as CacheListValueObserver).onUpdate(key, cacheTrue.clone() as CacheList<*>)
        }else{
            (observer as CacheValueObserver).onUpdate(key, cache)
        }
    }

    fun sync(cache: Any, secondKey: String = ""){
        if(!cache.javaClass.isAnnotationPresent(CacheBean::class.java)){
            throw Exception(cache.javaClass.name + " 同步缓存失败,缓存数据类必须使用CacheBean注解")
        }
        val key = cache.javaClass.name + "-" + secondKey
        if(changed.contains(key)){
            changed.remove(key)
            disk.writeToDisk(key, cache)
        }else{
            Log.e(TAG, "缓存 $key 没有被修改过，跳过同步。")
        }
    }

    fun sync(observer: CacheObserver){
        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
            val key = it.jvmName + "-" + observer.secondKey()
            val cache = caches[key]
            if(cache != null){
                sync(cache, observer.secondKey())
            }
        }
    }

    fun <T: Any> use(clazz: Class<out T>, secondKey: String = "", immediateMode: Boolean = true, call: T.() -> Unit): Unit{
        if(!clazz.isAnnotationPresent(CacheBean::class.java)){
            throw Exception(clazz.name + " 缓存数据类必须使用CacheBean注解")
        }
        val cache: T
        val key = clazz.name + "-" + secondKey
        if(key.isEmpty()){
            throw Exception(clazz.name + " CacheBean(key)不可为空")
        }
        if(!caches.containsKey(key)){
            val json = disk.readFromDisk(key)
            if(json == null || json.isEmpty()){
                cache = clazz.newInstance()
            }else{
                cache = Gson().fromJson(json, clazz)
            }
            caches.put(key, cache)
        }else{
            cache = caches[key] as T
        }
        cache.call()
        if(!changed.contains(key)){
            changed.add(key)
        }
        val annotation = clazz.getAnnotation(CacheBean::class.java)
        notifyObserver(key, annotation.isList, cache)
        if(immediateMode && annotation.autoSync){
            sync(cache, secondKey)
        }else if(!immediateMode){
            if(!needUpdateToDisk.contains(key)){
                needUpdateToDisk.add(key)
            }
        }
    }
}