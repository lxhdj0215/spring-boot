package com.lxhdj.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理
 * @author: wangguijun1
 * @create: 2019-11-26 19:14
 **/

public class GeneralProxyDemo {
    static interface IServiceA {
        public void sayHello();

        public void sayHello2();
    }

    static class ServiceAImpl implements IServiceA {

        @Override
        public void sayHello() {
            sayHello2();
            System.out.println("hello");
        }

        @Override
        public void sayHello2() {
            System.out.println("hello2");
        }
    }

    static interface IServiceB {
        public void fly();
    }

    static class ServiceBImpl implements IServiceB {

        @Override
        public void fly() {
            System.out.println("flying");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + realObj.getClass().getSimpleName() + "::" + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + realObj.getClass().getSimpleName() + "::" + method.getName());
            return result;
        }
    }

    private static <T> T getProxy(Class<T> intf, T realObj) {
        return (T) Proxy.newProxyInstance(intf.getClassLoader(), new Class<?>[]{intf}, new SimpleInvocationHandler(realObj));
    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IServiceA iServiceA = new ServiceAImpl();
        IServiceA proxyServiceA = getProxy(IServiceA.class, iServiceA);
        proxyServiceA.sayHello();

//        IServiceB iServiceB = new ServiceBImpl();
//        IServiceB proxyServiceB = getProxy(IServiceB.class, iServiceB);
//        proxyServiceB.fly();
    }
}
