package com.lxhdj.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-17 16:21
 **/

public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object proxy, Method method,
                            Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("leaving " + method.getName());
        return result;
    }
}
