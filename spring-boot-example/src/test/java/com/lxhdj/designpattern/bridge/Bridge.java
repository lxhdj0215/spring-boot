package com.lxhdj.designpattern.bridge;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-11 20:27
 **/

public abstract class Bridge {
    private Sourceable source;

    public void method() {
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
