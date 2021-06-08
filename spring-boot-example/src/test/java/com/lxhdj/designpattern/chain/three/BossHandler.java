package com.lxhdj.designpattern.chain.three;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:07
 **/

/**
 * 老板
 */
public class BossHandler extends Leader {
    @Override
    int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    void handler(int money) {
        System.out.println("老板报销了：" + money);
    }
}
