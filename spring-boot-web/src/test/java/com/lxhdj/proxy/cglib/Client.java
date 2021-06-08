package com.lxhdj.proxy.cglib;

import com.lxhdj.proxy.staticproxy.RealService;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-17 16:22
 **/

public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "/workspace/spring-boot/target/cglib/");
        RealService realService = getProxy(RealService.class);
        realService.sayHello();
    }

    private static <T> T getProxy(Class<?> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new TestInterceptor());
        return (T) enhancer.create();
    }
}
