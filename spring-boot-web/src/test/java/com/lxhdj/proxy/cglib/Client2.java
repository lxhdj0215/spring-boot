package com.lxhdj.proxy.cglib;

import com.lxhdj.proxy.staticproxy.RealService;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-22 19:04
 **/

public class Client2 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "/workspace/spring-boot/target/cglib/");
        RealService realService = new RealService();
        RealService proxy = getProxy(RealService.class, realService);
        proxy.sayHello();
    }

    private static <T> T getProxy(Class<?> cls, RealService realService) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor(realService));
        return (T) enhancer.create();
    }
}
