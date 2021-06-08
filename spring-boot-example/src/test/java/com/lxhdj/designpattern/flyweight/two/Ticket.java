package com.lxhdj.designpattern.flyweight.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:24
 **/

/**
 * 定义展示车票信息的函数
 */
public interface Ticket {

    /**
     * @param bunk 车票类型
     */
    void showTicketInfo(String bunk);
}
