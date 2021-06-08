package com.lxhdj.designpattern.chain.three;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:07
 **/

/**
 * 组长
 */
public class GroupHandler extends Leader {
    @Override
    int limit() {
        return 1000;
    }

    @Override
    void handler(int money) {
        System.out.println("组长报销了：" + money);
    }
}
