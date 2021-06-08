package com.lxhdj.designpattern.mediator.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:26
 **/

public class User1 extends User {

    public User1(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}
