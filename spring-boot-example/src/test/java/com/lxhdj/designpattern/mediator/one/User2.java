package com.lxhdj.designpattern.mediator.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:26
 **/

public class User2 extends User {

    public User2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}