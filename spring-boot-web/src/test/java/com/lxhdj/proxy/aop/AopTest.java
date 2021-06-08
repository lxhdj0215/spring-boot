package com.lxhdj.proxy.aop;

import com.lxhdj.proxy.annotation.ServiceA;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @description: aop
 * @author: wangguijun1
 * @create: 2019-11-29 20:53
 **/

public class AopTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/workspace/spring-boot/target/cglib/");
        ServiceA serviceA = CGLibContainer.getInstance(ServiceA.class);
        System.out.println("serviceA-----" + serviceA.getClass().getName());
        serviceA.callB();
    }
}
