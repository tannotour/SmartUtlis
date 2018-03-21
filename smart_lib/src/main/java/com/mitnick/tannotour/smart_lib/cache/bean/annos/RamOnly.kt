package com.mitnick.tannotour.smart_lib.cache.bean.annos

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by mitnick on 2018/2/14.
 * Description
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(RetentionPolicy.RUNTIME)
annotation class RamOnly
