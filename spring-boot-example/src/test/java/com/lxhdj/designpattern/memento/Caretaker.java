package com.lxhdj.designpattern.memento;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 20:59
 **/

/**
 * 负责Memoto类的存储
 */
public class Caretaker {
    private Memoto mMemoto;

    /**
     * 保存状态
     *
     * @param memoto 备忘录对象
     */
    public void saveMemoto(Memoto memoto) {
        this.mMemoto = memoto;
    }

    /**
     * 获取状态对象
     *
     * @return
     */
    public Memoto getMemoto() {
        return mMemoto;
    }

}
