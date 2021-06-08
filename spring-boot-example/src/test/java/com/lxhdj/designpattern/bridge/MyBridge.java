package com.lxhdj.designpattern.bridge;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 20:28
 **/

public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
