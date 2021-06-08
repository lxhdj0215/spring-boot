package com.lxhdj.designpattern.interpreter.one;


/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:36
 **/

public class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}
