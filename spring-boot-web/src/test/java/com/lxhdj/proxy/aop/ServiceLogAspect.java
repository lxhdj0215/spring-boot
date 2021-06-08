package com.lxhdj.proxy.aop;

import com.lxhdj.proxy.annotation.ServiceA;
import com.lxhdj.proxy.annotation.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: 日志切面
 * @author: wangguijun1
 * @create: 2019-11-29 09:57
 **/


@Aspect({ServiceA.class, ServiceB.class})
public class ServiceLogAspect {

    public static void before(Object object, Method method, Object[] args) {
        System.out.println("entering " + method.getDeclaringClass().getSimpleName() + "::" + method.getName() + ", args: " + Arrays.toString(args));
    }

    public static void after(Object object, Method method, Object[] args, Object result) {
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName() + "::" + method.getName() + ", result: " + result);
    }

}
