package com.mitnick.tannotour.easylib.cache

import android.content.Context
import android.util.ArraySet
import android.util.Log
import com.google.gson.Gson
import com.mitnick.tannotour.easylib.cache.disk.Disk
import com.mitnick.tannotour.easylib.cache.disk.DiskCache
import com.mitnick.tannotour.easylib.cache.value.CacheListValueObserver
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import org.jetbrains.anko.doAsync
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.jvmName

/**
 * Created by mitnick on 2017/11/9.
 * Description
 */
object Cache {
    private val TAG = "Cache"

    private val caches: ConcurrentHashMap<String, Any> = ConcurrentHashMap()
    private val needUpdateToDisk: LinkedList<String> = LinkedList()
    private val changed: LinkedList<String> = LinkedList()
    private val observers: ConcurrentHashMap<String, ArrayList<CacheObserver>> = ConcurrentHashMap()
    /* 单key缓存到双key缓存的key映射 */
    private val keysMap: ConcurrentHashMap<String, ArraySet<String>> = ConcurrentHashMap()
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
                if(secondKeys.isNotEmpty() && !(keysMap.containsKey(it.jvmName + "-"))){
                    val buffer = ArraySet<String>()
                    Class.forName(it.jvmName).getAnnotation(CacheBean::class.java)?.secondKeys?.forEach { secondKey ->
                        buffer.add(it.jvmName + "-" + secondKey)
                    }
                    keysMap.put(it.jvmName + "-", buffer)
//                    if(keysMap.containsKey(it.jvmName + "-")){
//                        keysMap[it.jvmName + "-"]!!.add(key)
//                    }else{
//                        val buffer = ArraySet<String>()
//                        buffer.add(key)
//                        keysMap.put(it.jvmName + "-", buffer)
//                    }
                }
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
        val secondKeys = observer.secondKey()
        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
            val key = it.jvmName + "-" + secondKeys
            observers[key]?.remove(observer)
            if(observers[key]?.isEmpty() as Boolean){
                if(secondKeys.isNotEmpty()){
                    if(keysMap.containsKey(it.jvmName + "-") && keysMap[it.jvmName + "-"]!!.contains(key)){
                        keysMap[it.jvmName + "-"]!!.remove(key)
                    }
                }
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
                    val memoryResident = cache.javaClass.getAnnotation(CacheBean::class.java).memoryResident
                    if(!memoryResident){
                        caches.remove(it.jvmName)
                    }
//                    caches.remove(it.jvmName)
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
        if(secondKey.isNotEmpty()){
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
        }else{
            if(!(keysMap.containsKey(clazz.name + "-"))){
                val buffer = ArraySet<String>()
                Class.forName(clazz.name).getAnnotation(CacheBean::class.java)?.secondKeys?.forEach { secondKey ->
                    buffer.add(clazz.name + "-" + secondKey)
                }
                if(buffer.size == 0){
                    buffer.add(clazz.name + "-")
                }
                keysMap.put(clazz.name + "-", buffer)
            }
            keysMap[clazz.name + "-"]?.forEach {
                val cache: T
                if(it.isEmpty()){
                    throw Exception(clazz.name + " CacheBean(key)不可为空")
                }
                if(!caches.containsKey(it)){
//                    val json = disk.readFromDisk(it)
//                    if(json == null || json.isEmpty()){
//                        cache = clazz.newInstance()
//                    }else{
//                        cache = Gson().fromJson(json, clazz)
//                    }
                    cache = clazz.newInstance()
                    caches.put(it, cache)
                }else{
                    cache = caches[it] as T
                }
                cache.call()
                if(!changed.contains(it)){
                    changed.add(it)
                }
                val annotation = clazz.getAnnotation(CacheBean::class.java)
                notifyObserver(it, annotation.isList, cache)
                if(immediateMode && annotation.autoSync){
                    sync(cache, secondKey)
                }else if(!immediateMode){
                    if(!needUpdateToDisk.contains(it)){
                        needUpdateToDisk.add(it)
                    }
                }
            }
        }
    }
}


//object Cache {
//    private val TAG = "Cache"
//
//    private val caches: ConcurrentHashMap<String, Any> = ConcurrentHashMap()
//    private val needUpdateToDisk: LinkedList<String> = LinkedList()
//    private val changed: LinkedList<String> = LinkedList()
//    private val observers: ConcurrentHashMap<String, ArrayList<CacheObserver>> = ConcurrentHashMap()
//    /* 单key缓存到双key缓存的key映射 */
//    private val keys22KeysMap: ConcurrentHashMap<String, String> = ConcurrentHashMap()
//    private var disk: DiskCache = Disk()
//
//    fun init(context: Context){
//        disk.init(context)
//    }
//
//    fun setDisk(diskCache: DiskCache){
//        disk = diskCache
//    }
//
//    fun flush(){
//        disk.flush()
//    }
//
//    fun addObserver(observer: CacheObserver): Boolean{
//        val cacheKey: CacheKey
//        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
//            Log.e(TAG, "数据源观察者${observer::javaClass.name}未使用CacheKey注解")
//            return false
//        }else {
//            cacheKey = observer.javaClass.getAnnotation(CacheKey::class.java)
//            cacheKey.keys.forEach {
//                val cacheBean = Class.forName(it.jvmName).getAnnotation(CacheBean::class.java)
////                val cacheBean = it::class.java.getAnnotation(CacheBean::class.java)
//                if(cacheBean != null){
//                    if((cacheBean.isList) && (observer !is CacheListValueObserver)){
//                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
//                        return false
//                    }
//                    if((!cacheBean.isList) && (observer !is CacheValueObserver)){
//                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
//                        return false
//                    }
//
//                }else{
//                    Log.e(TAG, "Cache初始化错误NULL")
//                    return false
//                }
//            }
//        }
//        doAsync {
//            val secondKeys = observer.secondKey()
//            cacheKey.keys.forEach{
//                val key = it.jvmName + "-" + secondKeys
////                val key = it.jvmName
//                if(!observers.containsKey(key)){
//                    observers.put(key, ArrayList<CacheObserver>())
//                }
//                if(!observers[key]?.contains(observer)!!){
//                    observers[key]?.add(observer)
//                }
//                val cache: Any
//                if(!caches.containsKey(key)){
//                    val json = disk.readFromDisk(key)
//                    if(json == null || json.isEmpty()){
//                        cache = Class.forName(it.jvmName).newInstance()
//                    }else{
//                        cache = Gson().fromJson(json, Class.forName(it.jvmName))
//                    }
//                    caches.put(key, cache)
//                }else{
//                    cache = caches[key]!!
//                }
//                val anno = cache::class.java.getAnnotation(CacheBean::class.java)
//                if(anno == null){
//                    Log.e(TAG, "无法获取初始化Cache(${cache::class.java.name})数据，绑定时初始化失败，请添加CacheKey注解。")
//                }else{
//                    notifyObserver(key, anno.isList, cache, observer)
//                }
//            }
//        }
//        return true
//    }
//
//    fun removeObserver(observer: CacheObserver): Boolean{
//        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
//            return false
//        }
//        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
//            val key = it.jvmName + "-" + observer.secondKey()
//            observers[key]?.remove(observer)
//            if(observers[key]?.isEmpty() as Boolean){
//                observers.remove(key)
//                val cache = caches[key]
//                if(cache != null){
//                    val autoSync = cache.javaClass.getAnnotation(CacheBean::class.java).autoSync
//                    if(!autoSync){
//                        /* 更新cache到disk */
//                        sync(cache, observer.secondKey())
//                    }else if(needUpdateToDisk.contains(key)){
//                        needUpdateToDisk.remove(key)
//                        sync(cache, observer.secondKey())
//                    }
//                    caches.remove(it.jvmName)
//                }
//
//            }
//        }
//        return true
//    }
//
//    fun notifyObserver(key: String, isList: Boolean, cache: Any){
//        observers[key]?.forEach {
//            notifyObserver(key, isList, cache, it)
//        }
//        if(isList){
//            (cache as CacheList<*>).clearRecord()
//        }
//    }
//
//    fun notifyObserver(key: String, isList: Boolean, cache: Any, observer: CacheObserver){
//        if(isList){
//            val cacheTrue = (cache as CacheList<*>)
//            (observer as CacheListValueObserver).onUpdate(key, cacheTrue.clone() as CacheList<*>)
//        }else{
//            (observer as CacheValueObserver).onUpdate(key, cache)
//        }
//    }
//
//    fun sync(cache: Any, secondKey: String = ""){
//        if(!cache.javaClass.isAnnotationPresent(CacheBean::class.java)){
//            throw Exception(cache.javaClass.name + " 同步缓存失败,缓存数据类必须使用CacheBean注解")
//        }
//        val key = cache.javaClass.name + "-" + secondKey
//        if(changed.contains(key)){
//            changed.remove(key)
//            disk.writeToDisk(key, cache)
//        }else{
//            Log.e(TAG, "缓存 $key 没有被修改过，跳过同步。")
//        }
//    }
//
//    fun sync(observer: CacheObserver){
//        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
//            val key = it.jvmName + "-" + observer.secondKey()
//            val cache = caches[key]
//            if(cache != null){
//                sync(cache, observer.secondKey())
//            }
//        }
//    }
//
//    fun <T: Any> use(clazz: Class<out T>, secondKey: String = "", immediateMode: Boolean = true, call: T.() -> Unit): Unit{
//        if(!clazz.isAnnotationPresent(CacheBean::class.java)){
//            throw Exception(clazz.name + " 缓存数据类必须使用CacheBean注解")
//        }
//        val cache: T
//        val key = clazz.name + "-" + secondKey
//        if(key.isEmpty()){
//            throw Exception(clazz.name + " CacheBean(key)不可为空")
//        }
//        if(!caches.containsKey(key)){
//            val json = disk.readFromDisk(key)
//            if(json == null || json.isEmpty()){
//                cache = clazz.newInstance()
//            }else{
//                cache = Gson().fromJson(json, clazz)
//            }
//            caches.put(key, cache)
//        }else{
//            cache = caches[key] as T
//        }
//        cache.call()
//        if(!changed.contains(key)){
//            changed.add(key)
//        }
//        val annotation = clazz.getAnnotation(CacheBean::class.java)
//        notifyObserver(key, annotation.isList, cache)
//        if(immediateMode && annotation.autoSync){
//            sync(cache, secondKey)
//        }else if(!immediateMode){
//            if(!needUpdateToDisk.contains(key)){
//                needUpdateToDisk.add(key)
//            }
//        }
//    }
//}


//object Cache {
//    private val TAG = "Cache"
//
//    private val needUpdateToDisk: ConcurrentHashMap<String, ArrayList<String>> = ConcurrentHashMap()
//    private val changed: ConcurrentHashMap<String, ArrayList<String>> = ConcurrentHashMap()
//    private val observers: ConcurrentHashMap<String, ConcurrentHashMap<String, ArrayList<CacheObserver>>> = ConcurrentHashMap()
//    private val caches: ConcurrentHashMap<String, ConcurrentHashMap<String, Any>> = ConcurrentHashMap()
//    private var disk: DiskCache = Disk()
//
//    fun init(context: Context){
//        disk.init(context)
//    }
//
//    fun setDisk(diskCache: DiskCache){
//        disk = diskCache
//    }
//
//    fun flush(){
//        disk.flush()
//    }
//
//    fun addObserver(observer: CacheObserver): Boolean{
//        val cacheKey: CacheKey
//        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
//            Log.e(TAG, "数据源观察者${observer::javaClass.name}未使用CacheKey注解")
//            return false
//        }else {
//            cacheKey = observer.javaClass.getAnnotation(CacheKey::class.java)
//            cacheKey.keys.forEach {
//                val cacheBean = Class.forName(it.jvmName).getAnnotation(CacheBean::class.java)
//                if(cacheBean != null){
//                    if((cacheBean.isList) && (observer !is CacheListValueObserver)){
//                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
//                        return false
//                    }
//                    if((!cacheBean.isList) && (observer !is CacheValueObserver)){
//                        Log.e(TAG, "数据源观察者${observer::javaClass.name}未实现正确的Cache回调接口")
//                        return false
//                    }
//                }else{
//                    Log.e(TAG, "Cache初始化错误NULL")
//                    return false
//                }
//            }
//        }
//        doAsync {
//            val secondKey = observer.secondKey()
//            cacheKey.keys.forEach{
//                val key = it.jvmName
//                if(!observers.containsKey(key)){
//                    val buffer = ConcurrentHashMap<String, ArrayList<CacheObserver>>()
//                    buffer.put(secondKey, ArrayList<CacheObserver>())
//                    observers.put(key, buffer)
//                }else if(!(observers[key]!!.containsKey(secondKey))){
//                    observers[key]!!.put(secondKey, ArrayList<CacheObserver>())
//                }else if(!(observers[key]!![secondKey]!!.contains(observer))){
//                    observers[key]!![secondKey]!!.add(observer)
//                }
//                val cache: Any
//                if(!(caches.containsKey(key))){
//                    val json = disk.readFromDisk(key + "-" + secondKey)
//                    if(json == null || json.isEmpty()){
//                        cache = Class.forName(it.jvmName).newInstance()
//                    }else{
//                        cache = Gson().fromJson(json, Class.forName(it.jvmName))
//                    }
//                    val buffer = ConcurrentHashMap<String, Any>()
//                    buffer.put(secondKey, cache)
//                    caches.put(key, buffer)
//                }else if(!(caches[key]!!.containsKey(secondKey))){
//                    val json = disk.readFromDisk(key + "-" + secondKey)
//                    if(json == null || json.isEmpty()){
//                        cache = Class.forName(it.jvmName).newInstance()
//                    }else{
//                        cache = Gson().fromJson(json, Class.forName(it.jvmName))
//                    }
//                    caches[key]!!.put(secondKey, cache)
//                }else{
//                    cache = caches[key]!![secondKey]!!
//                }
//                val anno = cache::class.java.getAnnotation(CacheBean::class.java)
//                if(anno == null){
//                    Log.e(TAG, "无法获取初始化Cache(${cache::class.java.name})数据，绑定时初始化失败，请添加CacheKey注解。")
//                }else{
//                    notifyObserver(key, anno.isList, cache, observer)
//                }
//            }
//        }
//        return true
//    }
//
//    fun removeObserver(observer: CacheObserver): Boolean{
//        if(!observer.javaClass.isAnnotationPresent(CacheKey::class.java)){
//            return false
//        }
//        val secondKey = observer.secondKey()
//        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
//            val key = it.jvmName
//            observers[key]?.get(secondKey)?.remove(observer)
//            if(observers[key]?.get(secondKey)?.isEmpty() as Boolean){
//                observers[key]?.remove(secondKey)
//                val cache = caches[key]?.get(secondKey)
//                if(cache != null){
//                    val autoSync = cache.javaClass.getAnnotation(CacheBean::class.java).autoSync
//                    if(!autoSync){
//                        /* 更新cache到disk */
//                        sync(cache, secondKey)
//                    }else if(needUpdateToDisk.containsKey(key) && needUpdateToDisk[key]!!.contains(secondKey)){
//                        needUpdateToDisk[key]!!.remove(secondKey)
//                        sync(cache, secondKey)
//                    }
//                    caches[key]?.remove(secondKey)
//                }
//            }
//            if(observers[key]?.isEmpty() as Boolean){
//                observers.remove(key)
//                caches.remove(key)
//            }
//        }
//        return true
//    }
//
//    fun notifyObserver(key: String, secondKey: String, isList: Boolean, cache: Any){
//        observers[key]?.get(secondKey)?.forEach {
//            notifyObserver(key, isList, cache, it)
//        }
//        if(isList){
//            (cache as CacheList<*>).clearRecord()
//        }
//    }
//
//    fun notifyObserver(key: String, isList: Boolean, cache: Any, observer: CacheObserver){
//        if(isList){
//            val cacheTrue = (cache as CacheList<*>)
//            (observer as CacheListValueObserver).onUpdate(key, cacheTrue.clone() as CacheList<*>)
//        }else{
//            (observer as CacheValueObserver).onUpdate(key, cache)
//        }
//    }
//
//    fun sync(cache: Any, secondKey: String = ""){
//        if(!cache.javaClass.isAnnotationPresent(CacheBean::class.java)){
//            throw Exception(cache.javaClass.name + " 同步缓存失败,缓存数据类必须使用CacheBean注解")
//        }
//        val key = cache.javaClass.name
//        if(changed.containsKey(key) && changed[key]!!.contains(secondKey)){
//            changed[key]!!.remove(secondKey)
//            changed.remove(key)
//            disk.writeToDisk(key + "-" + secondKey, cache)
//        }else if (changed.containsKey(key)){
//            changed.remove(key)
//            disk.writeToDisk(key + "-" + secondKey, cache)
//        }else{
//            Log.e(TAG, "缓存 $key-$secondKey 没有被修改过，跳过同步。")
//        }
//    }
//
//    fun sync(observer: CacheObserver){
//        val senondKey = observer.secondKey()
//        observer.javaClass.getAnnotation(CacheKey::class.java).keys.forEach {
//            val key = it.jvmName
//            val cache = caches[key]?.get(senondKey)
//            if(cache != null){
//                sync(cache, senondKey)
//            }
//        }
//    }
//
//    fun <T: Any> use(clazz: Class<out T>, secondKey: String = "", immediateMode: Boolean = true, call: T.() -> Unit): Unit{
//        if(!clazz.isAnnotationPresent(CacheBean::class.java)){
//            throw Exception(clazz.name + " 缓存数据类必须使用CacheBean注解")
//        }
//        val key = clazz.name
//        if(key.isEmpty()){
//            throw Exception(clazz.name + " CacheBean(key)不可为空")
//        }
//        if(secondKey.isNotEmpty()){
//            val cache: T
//            if(!(caches.containsKey(key))){
//                val json = disk.readFromDisk(key + "-" + secondKey)
//                if(json == null || json.isEmpty()){
//                    cache = clazz.newInstance()
//                }else{
//                    cache = Gson().fromJson(json, clazz)
//                }
//                val buffer = ConcurrentHashMap<String, Any>()
//                buffer.put(secondKey, cache)
//                caches.put(key, buffer)
//            }else if(!(caches[key]!!.contains(secondKey))){
//                val json = disk.readFromDisk(key + "-" + secondKey)
//                if(json == null || json.isEmpty()){
//                    cache = clazz.newInstance()
//                }else{
//                    cache = Gson().fromJson(json, clazz)
//                }
//                caches[key]!!.put(secondKey, cache)
//            }else{
//                cache = caches[key]!![secondKey] as T
//            }
//            cache.call()
//            if(!(changed.containsKey(key))){
//                val buffer = ArrayList<String>()
//                buffer.add(secondKey)
//                changed.put(key, buffer)
//            }else if(!(changed[key]!!.contains(secondKey))){
//                changed[key]!!.add(secondKey)
//            }
//            val annotation = clazz.getAnnotation(CacheBean::class.java)
//            notifyObserver(key, secondKey, annotation.isList, cache)
//            if(immediateMode && annotation.autoSync){
//                sync(cache, secondKey)
//            }else if(!immediateMode){
//                if(!(needUpdateToDisk.containsKey(key))){
//                    val buffer = ArrayList<String>()
//                    buffer.add(secondKey)
//                    needUpdateToDisk.put(key, buffer)
//                }else if(!(needUpdateToDisk[key]!!.contains(secondKey))){
//                    needUpdateToDisk[key]!!.add(key)
//                }
//            }
//        }else{
//            caches[key]?.forEach {
//                val cache = it.value as T
//                cache.call()
//                if(!(changed.containsKey(key))){
//                    val buffer = ArrayList<String>()
//                    buffer.add(secondKey)
//                    changed.put(key, buffer)
//                }else if(!(changed[key]!!.contains(secondKey))){
//                    changed[key]!!.add(secondKey)
//                }
//                val annotation = clazz.getAnnotation(CacheBean::class.java)
//                notifyObserver(key, secondKey, annotation.isList, cache)
//                if(immediateMode && annotation.autoSync){
//                    sync(cache, secondKey)
//                }else if(!immediateMode){
//                    if(!(needUpdateToDisk.containsKey(key))){
//                        val buffer = ArrayList<String>()
//                        buffer.add(secondKey)
//                        needUpdateToDisk.put(key, buffer)
//                    }else if(!(needUpdateToDisk[key]!!.contains(secondKey))){
//                        needUpdateToDisk[key]!!.add(key)
//                    }
//                }
//            }
//        }
//    }
//}