package com.lxhdj.design.pattern.visitor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:03
 **/

public class CTOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师: " + engineer.name + ", 代码行数: " + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理: " + manager.name + ", 产品数量: " + manager.getProducts());
    }
}
