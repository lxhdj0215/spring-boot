package com.lxhdj.proxy.aop;

import com.lxhdj.proxy.annotation.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: 异常切面
 * @author: wangguijun1
 * @create: 2019-11-29 10:07
 **/

@Aspect(ServiceB.class)
public class ExceptionAspect {

    public static void exception(Object object, Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling:" + method.getName() + "," + Arrays.toString(args));
    }
}
