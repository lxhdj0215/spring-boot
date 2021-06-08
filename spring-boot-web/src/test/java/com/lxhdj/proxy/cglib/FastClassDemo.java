package com.lxhdj.proxy.cglib;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-06-05 17:28
 **/

public class FastClassDemo {
    public Object invoke(int index, Object o, Object[] ol) {
        Test t = (Test) o;
        switch (index) {
            case 1:
                t.f();
                return null;
            case 2:
                t.g();
                return null;
        }
        return null;
    }

    public int getIndex(String signature) {
        switch (signature.hashCode()) {
            case 3078479:
                return 1;
            case 3108270:
                return 2;
        }
        return -1;
    }
}
