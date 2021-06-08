package com.lxhdj;

/**
 * @description: 单例
 * @author: wangguijun1
 * @create: 2020-10-10 16:11
 **/

public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
