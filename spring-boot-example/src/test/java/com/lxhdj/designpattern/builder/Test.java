package com.lxhdj.designpattern.builder;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 21:19
 **/

public class Test {

    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        Director pcDirector = new Director(builder);
        pcDirector.construct("英特尔主板", "Retina显示器");

        Computer computer = builder.build();
        System.out.println(computer.toString());
    }

}
