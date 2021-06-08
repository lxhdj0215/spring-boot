package com.lxhdj.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2019-12-20 19:45
 **/

@Service
public class ShareTaskServiceImpl {
    public String shareTaskServiceImplOne(String name) {
        System.out.println("=====shareTaskServiceImplOne=====");
        return "one " + shareTaskServiceImplTwo(name);
    }

    public String shareTaskServiceImplTwo(String name) {
        System.out.println("=====shareTaskServiceImplTwo=====");
        return "two " + name;
    }
}
