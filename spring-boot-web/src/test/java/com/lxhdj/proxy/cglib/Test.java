package com.lxhdj.proxy.cglib;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-05 17:28
 **/

public class Test {
    public void f(){
        System.out.println("f method");
    }

    public void g(){
        System.out.println("g method");
    }

    public static void main(String[] args) {
        Test tt = new Test();
        FastClassDemo fc = new FastClassDemo();
        fc.invoke(fc.getIndex("f()V"), tt, null);
    }
}
