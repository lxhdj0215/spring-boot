package com.lxhdj.designpattern.chain.one;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 10:56
 **/

public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
