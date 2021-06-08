package com.lxhdj.proxy.staticproxy;

/**
 * @description: 代理类
 * @author: wangguijun1
 * @create: 2019-11-26 16:44
 **/

public class StaticProxy implements IService {

    private IService iService;

    public StaticProxy(IService iService) {
        this.iService = iService;
    }

    @Override
    public void sayHello() {
        System.out.println("entering sayHello");
        iService.sayHello();
        System.out.println("leaving sayHello");
    }

    @Override
    public void sayHelloWorld() {
        System.out.println("entering sayHelloWorld");
        iService.sayHelloWorld();
        System.out.println("leaving sayHelloWorld");
    }
}
