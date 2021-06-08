package com.lxhdj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2021-01-31 16:57
 **/

public class Test {
    public static void main(String[] args) {
        unsafeConcurrentUpdate();
    }

    public static void unsafeConcurrentUpdate() {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread() {
                Random rnd = new Random();

                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        map.put(rnd.nextInt(), 1);
                    }
                }
            };
            t.start();
        }
    }
}
