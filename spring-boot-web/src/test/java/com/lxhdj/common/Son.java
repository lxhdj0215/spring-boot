package com.lxhdj.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 测试
 * @author: wangguijun1
 * @create: 2020-04-28 11:27
 **/

public class Son extends Father {
    public void test() {
        System.out.println("this is son");
    }

    public static void main(String[] args) {
        Father father = new Son();
        if (father instanceof Son) {
            Son son = (Son) father;
            son.test();
        }
//        Father father = new Father();
//        Son son = (Son) father;
//        son.test();
//        Son son = new Son();
//        try {
//            Method test = Father.class.getMethod("test");
//            test.invoke(son);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        son.test();
    }
}
