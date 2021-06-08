package com.lxhdj.designpattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:42
 **/

// 工程师
public class Engineer extends Staff {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}