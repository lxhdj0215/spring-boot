package com.lxhdj.designpattern.visitor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:43
 **/

public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}