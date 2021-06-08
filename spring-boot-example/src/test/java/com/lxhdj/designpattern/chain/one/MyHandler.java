package com.lxhdj.designpattern.chain.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 10:57
 **/

public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + " deal!");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
