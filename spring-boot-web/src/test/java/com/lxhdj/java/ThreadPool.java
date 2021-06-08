package com.lxhdj.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * @description: 线程池
 * @author: wangguijun1
 * @create: 2020-01-10 17:43
 **/

public class ThreadPool {
    public static void main(String[] args) {
        test();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            list.add(Long.valueOf(i));
        }
        long sum = multiThread(list);
        System.out.println(sum);
    }

    private static void test() {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(Long.valueOf(i));
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            sum(list);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("串行计算平均时间-----" + (t2 - t1));
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            parallelSum(list);
        }
        t2 = System.currentTimeMillis();
        System.out.println("并行计算平均时间-----" + (t2 - t1));

        t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            sumA(list);
        }
        t2 = System.currentTimeMillis();
        System.out.println("普通计算平均时间-----" + (t2 - t1));
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            sum(list);
        }
        t2 = System.currentTimeMillis();
        System.out.println("串行计算平均时间-----" + (t2 - t1));
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            multiThread(list);
        }
        t2 = System.currentTimeMillis();
        System.out.println("多线程计算平均时间-----" + (t2 - t1));
    }

    public static long parallelSum(List<Long> list) {
        return list.parallelStream().mapToLong(t -> t).sum();
    }

    public static long sum(List<Long> list) {
        return list.stream().mapToLong(t -> t).sum();
    }

    public static long sumA(List<Long> list) {
        long sum = 0;
        for (Long item : list) {
            sum = sum + item;
        }
        return sum;
    }

    public static long multiThread(List<Long> list) {
        int size = list.size();
        int threadSize = 10;
        int tasks = size / threadSize;
        long[] count = new long[threadSize];
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            final int index = i;
            final int start = i * tasks;
            final int end;
            if (i == threadSize - 1) {
                end = size;
            } else {
                end = tasks * (i + 1);
            }
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    count[index] = count[index] + list.get(j);
                }
            });
        }
        for (int i = 0; i < threadSize; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadSize; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long sum = 0;
        for (long sub : count) {
            sum = sum + sub;
        }
//        System.out.println(Arrays.toString(count));
        return sum;
    }
}
