package com.lxhdj.designpattern.flyweight.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-12 11:24
 **/

public class TicketFactory {

    static Map<String, Ticket> maps = new HashMap<>();

    public static Ticket getTicket(String from, String to) {
        String key = from + to;

        if (maps.containsKey(key)) {
            System.out.println("使用了缓存的对象");
            return maps.get(key);
        } else {
            System.out.println("创建了新的对象");
            Ticket ticket = new TrainTicket(from, to);
            maps.put(key, ticket);
            return ticket;
        }
    }
}
