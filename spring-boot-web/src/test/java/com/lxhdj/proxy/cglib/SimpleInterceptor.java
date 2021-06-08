package com.lxhdj.proxy.cglib;

import com.lxhdj.proxy.staticproxy.RealService;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: cglib
 * @author: wangguijun1
 * @create: 2019-11-28 18:44
 **/

public class SimpleInterceptor implements MethodInterceptor {

    private RealService realService;

    public SimpleInterceptor(RealService realService) {
        this.realService = realService;
    }

    @Override
    public Object intercept(Object proxy, Method method,
                            Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = methodProxy.invoke(realService, args);
        System.out.println("leaving " + method.getName());
        return result;
    }
}