package com.mitnick.tannotour.smart_lib.cache.observer.annos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mitnick on 2018/3/12.
 * Description
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheReceiver {
    Class cacheBean();
}
