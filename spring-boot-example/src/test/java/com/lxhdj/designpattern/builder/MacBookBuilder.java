package com.lxhdj.designpattern.builder;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 21:18
 **/

public class MacBookBuilder extends Builder {

    private Computer mComputer = new MacBook();

    @Override
    void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    void buildOs() {
        mComputer.setOs();
    }

    @Override
    Computer build() {
        return mComputer;
    }
}
