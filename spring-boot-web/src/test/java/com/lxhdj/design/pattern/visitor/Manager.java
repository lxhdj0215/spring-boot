package com.lxhdj.design.pattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:02
 **/
// 经理
public class Manager extends Staff {

    public Manager(String name) {
        super(name);
    }

    public Manager(String name, Visitor visitor) {
        super(name, visitor);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept() {
        visitor.visit(this);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
