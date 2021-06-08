package com.lxhdj.designpattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:43
 **/

// 经理
public class Manager extends Staff {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
