package com.lxhdj.designpattern.mediator.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 15:49
 **/

public class Champions extends WulinAlliance {
    private Wudang wudang;
    private ShaoLin shaolin;
    private Emei emei;

    public void setWudang(Wudang wudang) {
        this.wudang = wudang;
    }

    public void setEmei(Emei emei) {
        this.emei = emei;
    }

    public void setShaolin(ShaoLin shaolin) {
        this.shaolin = shaolin;
    }

    @Override
    public void notice(String message, United united) {
        if (united == wudang) {
            shaolin.getNotice(message);
        } else if (united == emei) {
            shaolin.getNotice(message);
        } else if (united == shaolin) {
            wudang.getNotice(message);
            emei.getNotice(message);
        }
    }
}
