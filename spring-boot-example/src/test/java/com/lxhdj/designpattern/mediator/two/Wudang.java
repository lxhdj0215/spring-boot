package com.lxhdj.designpattern.mediator.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:49
 **/

public class Wudang extends United {

    public Wudang(WulinAlliance wulinAlliance) {
        super(wulinAlliance);
    }

    public void sendAlliance(String message) {
        wulinAlliance.notice(message, this);
    }

    public void getNotice(String message) {
        System.out.println("武当收到消息：" + message);
    }
}
