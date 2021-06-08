package com.lxhdj.proxy.staticproxy;

/**
 * @description: 服务类
 * @author: wangguijun1
 * @create: 2019-11-26 16:43
 **/

public class RealService implements IService {
    @Override
    public void sayHello() {
        System.out.println("hello");
        sayHelloWorld();
    }

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }
}
