package com.lxhdj.designpattern.prototype.one;

import lombok.Data;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:19
 **/

@Data
public class BusinessCard implements Cloneable {

    private String name;
    private String company;

    public BusinessCard() {
        System.out.println("执行了构造方法BusinessCard构造方法");
    }


    public static void main(String[] args) {

        BusinessCard card = new BusinessCard();
        card.setName("张三");
        card.setCompany("阿里");

        BusinessCard clone = card.clone();
        clone.setName("李四");
        clone.setCompany("百度");

        BusinessCard clone2 = card.clone();
        clone2.setName("王五");
        clone2.setCompany("腾讯");

        card.show();
        clone.show();
        clone2.show();

    }


    @Override
    protected BusinessCard clone() {

        BusinessCard card = null;
        try {
            card = (BusinessCard) super.clone();
            return card;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void show() {
        System.out.println("BusinessCard{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}');
    }
}