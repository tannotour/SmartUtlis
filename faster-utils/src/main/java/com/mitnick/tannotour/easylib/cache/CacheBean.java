package com.mitnick.tannotour.easylib.cache;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mitnick on 2017/11/9.
 * Description
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheBean {
//    String key() default  "";
    boolean isList() default false;
    String[] secondKeys() default {};
    boolean autoSync() default true;
    boolean memoryResident() default false;//常驻内存
}
