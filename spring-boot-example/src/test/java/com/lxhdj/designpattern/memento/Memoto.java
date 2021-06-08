package com.lxhdj.designpattern.memento;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 20:58
 **/

/**
 * 备忘录类
 */
public class Memoto {

    /**
     * 用户ID
     */
    public String userId;
    /**
     * 游戏进度
     */
    public int progress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
