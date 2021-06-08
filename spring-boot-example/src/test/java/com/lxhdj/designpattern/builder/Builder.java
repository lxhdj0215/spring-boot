package com.lxhdj.designpattern.builder;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 21:18
 **/

public abstract class Builder {

    abstract void buildBoard(String board);

    abstract void buildDisplay(String display);

    abstract void buildOs();

    abstract Computer build();

}
