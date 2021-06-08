package com.lxhdj.designpattern.flyweight.two;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:25
 **/

public class Client {

    public static void main(String[] args) {

        Ticket ticket1 = TicketFactory.getTicket("广州", "北京");
        ticket1.showTicketInfo("软卧");

        Ticket ticket2 = TicketFactory.getTicket("广州", "北京");
        ticket2.showTicketInfo("上铺");

        Ticket ticket3 = TicketFactory.getTicket("广州", "深圳");
        ticket3.showTicketInfo("上铺");

    }
}
