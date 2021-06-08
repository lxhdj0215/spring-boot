package com.lxhdj.designpattern.builder;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 21:18
 **/

public class Director {
    Builder mBuilser = null;


    public Director(Builder builer) {
        this.mBuilser = builer;
    }


    public void construct(String board, String display) {
        mBuilser.buildDisplay(display);
        mBuilser.buildBoard(board);
        mBuilser.buildOs();
    }
}
