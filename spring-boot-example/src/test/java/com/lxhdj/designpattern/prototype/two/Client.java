package com.lxhdj.designpattern.prototype.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:27
 **/

public class Client {
    public static void main(String[] args) {

        DeepBusinessCard card = new DeepBusinessCard();
        card.setName("张三");
        card.setCompany("阿里", "望京");

        DeepBusinessCard clone = card.clone();
        clone.setName("李四");
        clone.setCompany("百度", "中关村");

        DeepBusinessCard clone2 = card.clone();
        clone2.setName("王五");
        clone2.setCompany("腾讯", "西二旗");

        clone.show();
        card.show();
        clone2.show();

    }
}
