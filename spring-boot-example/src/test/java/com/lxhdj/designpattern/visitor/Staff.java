package com.lxhdj.designpattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:42
 **/

// 员工基类
public abstract class Staff {

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
