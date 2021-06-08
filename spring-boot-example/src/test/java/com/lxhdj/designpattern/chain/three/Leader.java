package com.lxhdj.designpattern.chain.three;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:06
 **/

/**
 * 抽象领导
 */
public abstract class Leader {
    //上级领导
    Leader nextHandler;

    //报销金额
    abstract int limit();

    //具体处理请求方法
    abstract void handler(int money);

    //是否处理请求判断
    void handerRequest(int money) {
        if (money < limit()) {
            handler(money);
        } else {
            if (nextHandler != null) {
                nextHandler.handerRequest(money);
            }
        }
    }
}
