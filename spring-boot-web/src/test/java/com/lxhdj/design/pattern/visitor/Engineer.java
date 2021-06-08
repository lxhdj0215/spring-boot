package com.lxhdj.design.pattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:01
 **/

// 工程师
public class Engineer extends Staff {

    public Engineer(String name) {
        super(name);
    }

    public Engineer(String name, Visitor visitor) {
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

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}