package com.lxhdj.designpattern.chain.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:03
 **/

/**
 * 第二个对象处理者
 */
public class Handler2 extends Handler {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("handler2Request")) {
            System.out.println("Handler2 handler request");
            return;
        } else {
            successor.handleRequest(condition);
        }
    }
}
