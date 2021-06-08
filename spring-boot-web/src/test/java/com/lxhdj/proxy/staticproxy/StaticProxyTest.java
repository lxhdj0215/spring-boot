package com.lxhdj.proxy.staticproxy;

/**
 * @description: 简单代理测试
 * @author: wangguijun1
 * @create: 2019-11-26 16:46
 **/

public class StaticProxyTest {

    public static void main(String[] args) {
        IService iService = new RealService();

        StaticProxy traceProxy = new StaticProxy(iService);
        traceProxy.sayHello();
    }
}
