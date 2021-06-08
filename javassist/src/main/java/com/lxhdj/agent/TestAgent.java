package com.lxhdj.agent;

import java.lang.instrument.Instrumentation;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-12-27 20:13
 **/

public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
//            inst.retransformClasses(Base.class);
            inst.retransformClasses(Class.forName("com.lxhdj.agent.Base"));
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}