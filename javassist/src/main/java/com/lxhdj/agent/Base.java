package com.lxhdj.agent;

import java.lang.management.ManagementFactory;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-12-27 19:43
 **/

public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        // 打印当前Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process("wgj-" + Thread.currentThread().getName());
        }
    }

    private static String process(String name) {
        String response = "Hello World " + name;
        System.out.println(response);
        return response;
    }
}
