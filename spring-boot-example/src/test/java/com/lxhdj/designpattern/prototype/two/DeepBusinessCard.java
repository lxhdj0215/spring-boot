package com.lxhdj.designpattern.prototype.two;

import lombok.Data;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:26
 **/

@Data
public class DeepBusinessCard implements Cloneable {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private Company company = new Company();

    /**
     *
     */
    public DeepBusinessCard() {
        System.out.println("执行了构造方法BusinessCard构造方法");
    }


    @Override
    protected DeepBusinessCard clone() {

        DeepBusinessCard card = null;
        try {
            card = (DeepBusinessCard) super.clone();
            return card;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param name
     * @param address
     */
    public void setCompany(String name, String address) {
//        company = new Company();
        this.company.setName(name);
        this.company.setAddress(address);
    }

    /**
     *
     */
    public void show() {
        System.out.println("BusinessCard{" +
                "name='" + name + '\'' +
                ", address='" + company.getAddress() + '\'' + "name" + company.getName() +
                '}');
    }

}
