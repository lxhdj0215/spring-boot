package com.lxhdj;

import org.assertj.core.util.Lists;

import java.util.HashMap;

/**
 * @description: zgc测试
 * @author: wangguijun1
 * @create: 2020-09-21 10:11
 **/

public class ZGCTest {
    static String lock = "111";
    public static void main(String[] args) {
        System.out.println("0.1 * 0.1 = " + 0.1 * 0.1);
        System.out.println("0.1 * 0.5 = " + 0.1 * 0.5);
        System.out.println("0.5 * 0.5 = " + 0.5 * 0.5);
        System.out.println("0.25 * 0.25 = " + 0.25 * 0.25);
        int a = 10;
        int b = 2;
        a = a + b; // 3
        b = a - b; // 1
        a = a - b; // 2



        System.out.println(a);
        System.out.println(b);


        synchronized (lock) {
            System.out.println("aaaaa");
            synchronized (lock) {
                System.out.println("bbbbbbb");
            }
        }
    }
}
