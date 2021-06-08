package com.lxhdj.design.pattern.visitor;

import java.util.Random;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:00
 **/

// 员工基类
public abstract class Staff {
    protected Visitor visitor;

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    public Staff(String name, Visitor visitor) {
        this.visitor = visitor;
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);

    public abstract void accept();
}