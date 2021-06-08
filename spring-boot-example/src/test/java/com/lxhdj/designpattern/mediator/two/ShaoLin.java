package com.lxhdj.designpattern.mediator.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:49
 **/

public class ShaoLin extends United {

    public ShaoLin(WulinAlliance wulinAlliance) {
        super(wulinAlliance);
    }

    public void sendAlliance(String message) {
        wulinAlliance.notice(message, this);
    }

    public void getNotice(String message) {
        System.out.println("少林收到消息：" + message);
    }
}
