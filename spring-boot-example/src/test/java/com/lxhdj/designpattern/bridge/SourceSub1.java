package com.lxhdj.designpattern.bridge;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 20:26
 **/

public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
