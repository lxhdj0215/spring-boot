package com.lxhdj.designpattern.chain.three;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:07
 **/

/**
 * 经理
 */
public class ManagerHandler extends Leader {
    @Override
    int limit() {
        return 3000;
    }

    @Override
    void handler(int money) {
        System.out.println("项目经理报销了：" + money);
    }
}
