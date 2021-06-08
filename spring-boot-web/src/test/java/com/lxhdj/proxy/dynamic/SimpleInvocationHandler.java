package com.lxhdj.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理
 * @author: wangguijun1
 * @create: 2019-11-26 16:52
 **/

public class SimpleInvocationHandler implements InvocationHandler {

    private Object realObj;

    public SimpleInvocationHandler(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = method.invoke(realObj, args);
        System.out.println("leaving " + method.getName());
        return result;
    }
}
