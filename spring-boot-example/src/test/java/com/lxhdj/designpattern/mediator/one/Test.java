package com.lxhdj.designpattern.mediator.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:26
 **/

public class Test {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}