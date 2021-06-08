package com.lxhdj.designpattern.bridge;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 20:27
 **/

public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}
