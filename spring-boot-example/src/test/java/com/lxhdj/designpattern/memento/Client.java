package com.lxhdj.designpattern.memento;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 21:00
 **/

/**
 * 玩家玩游戏
 */
public class Client {
    public static void main(String[] args) {
        LolGame player = new LolGame();
        player.setUserId("onex");
        player.play();

        Caretaker caretaker = new Caretaker();
        caretaker.saveMemoto(player.createMemoto());

        player.quit();

        player = new LolGame();

        player.restoreMemoto(caretaker.getMemoto());
        player.play();

    }
}
