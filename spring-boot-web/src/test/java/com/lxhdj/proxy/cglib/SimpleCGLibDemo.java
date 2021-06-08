package com.lxhdj.proxy.cglib;

import com.lxhdj.proxy.staticproxy.RealService;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.util.Arrays;

/**
 * @description: cglib
 * @author: wangguijun1
 * @create: 2019-11-28 17:35
 **/

public class SimpleCGLibDemo {

    private static <T> T getProxy(Class<?> cls, RealService realService) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor(realService));
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/workspace/spring-boot/target/cglib/");
        RealService realService = getProxy(RealService.class, new RealService());
        System.out.println("realService-----" + realService.getClass().getName());
//        System.out.println("-----method-----");
//        Arrays.stream(realService.getClass().getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));
//        System.out.println("-----method-----");
//        System.out.println("-----field-----");
//        Arrays.stream(realService.getClass().getDeclaredFields()).forEach(field -> System.out.println(field.getType().getName()));
//        System.out.println("-----field-----");
        realService.sayHello();
    }


}
