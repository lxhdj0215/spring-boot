package com.lxhdj.designpattern.mediator.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:25
 **/

public abstract class User {

    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
