package com.lxhdj.design.pattern.visitor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:01
 **/

public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}