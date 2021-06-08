package com.lxhdj.designpattern.visitor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-02-20 20:45
 **/

public class Client {

    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
