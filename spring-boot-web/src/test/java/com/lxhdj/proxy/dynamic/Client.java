package com.lxhdj.proxy.dynamic;

import com.lxhdj.proxy.staticproxy.IService;
import com.lxhdj.proxy.staticproxy.RealService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-16 20:06
 **/

public class Client {
    public static void main(String[] args) throws Exception {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IService realService = new RealService();
//        IService proxyService = (IService) Proxy.newProxyInstance(
//                IService.class.getClassLoader(),
//                new Class<?>[]{IService.class},
//                new SimpleInvocationHandler(realService));
        Class<?> proxyCls = Proxy.getProxyClass(IService.class.getClassLoader(),
                new Class<?>[]{IService.class});
        Constructor<?> ctor = proxyCls.getConstructor(new Class<?>[]{InvocationHandler.class});
        InvocationHandler handler = new SimpleInvocationHandler(realService);
        IService proxyService = (IService) ctor.newInstance(handler);
        proxyService.sayHello();
//        proxyService.sayHello();
//        proxyService.sayHelloWorld();
    }
}
