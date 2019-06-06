package com.axis.onion.filter.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ke Qingyuan on 2019-06-05.
 */
@NameBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IPFilterConfigure {
    // 白名单
    String whiteList() default "127.0.0.1,localhost,0:0:0:0:0:0:0:1";
}
