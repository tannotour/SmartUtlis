package com.mitnick.tannotour.smart_lib.cache.observer.annos

import com.mitnick.tannotour.smart_lib.cache.bean.CacheBean
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

/**
 * Created by mitnick on 2018/3/12.
 * Description
 */

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(RetentionPolicy.RUNTIME)
annotation class CacheReceiver(val cacheBean: KClass<out CacheBean>)
