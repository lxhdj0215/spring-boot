package com.lxhdj.designpattern.builder;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 21:17
 **/

public class MacBook extends Computer {


    protected MacBook() {
    }

    @Override
    public void setOs() {
        mOs = "Mac OS X 12";
    }
}
