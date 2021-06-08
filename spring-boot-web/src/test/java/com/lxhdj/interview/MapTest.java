package com.lxhdj.interview;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2019-12-31 10:27
 **/

public class MapTest {

    private static AtomicInteger TOTAL_COUNT = new AtomicInteger(0);

    //    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private volatile int i = 1;

    private volatile boolean flag = true;

    public void test2() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.size();
        TOTAL_COUNT.getAndIncrement();
    }


    @Test
    public void test1() {
        Thread t1 = new Thread(() -> {
            while (i <= 100) {
                if (i % 2 == 0 && !flag) {
                    System.out.println("偶数" + i++);
                    flag = true;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (i <= 100) {
                if (i % 2 == 1 && flag == true) {
                    System.out.println("奇数" + i++);
                    flag = false;
                }
            }
        });

        t1.start();
        t2.start();
        while (true) {

        }


    }


    @Test
    public void testThread() {

        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println("偶数" + i++);
                    } else {
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (i % 2 == 1) {
                        System.out.println("奇数" + i++);
                    } else {
                        try {
                            lock.notifyAll();
                            lock.wait();
                            System.out.println("========================");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        while (true) {

        }


    }


    @Test
    public void one() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        map.hashCode();
        Collections.synchronizedMap(map);
        new Thread(() -> {
            while (true) {
                map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }

            }
        }).start();

        while (true) {

        }


    }


    @Test
    public void all() {
        int size = 0;
        int temp = size;
        int j = size++;
        int i = ++temp;
        System.out.println(i);
        System.out.println(j);
        Map<String, String> treeMap = new TreeMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "a");
        for (Map.Entry entry : hashMap.entrySet()) {
        }
        Map<String, String> _hashMap = Collections.synchronizedMap(hashMap);

    }
}
