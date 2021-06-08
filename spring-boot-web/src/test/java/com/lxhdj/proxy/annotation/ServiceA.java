package com.lxhdj.proxy.annotation;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2019-11-29 10:30
 **/

public class ServiceA {

    @SimpleInject
    ServiceB b;

    public void callB() {
        callA();
    }

    public void callA() {
        b.action();
    }
}
