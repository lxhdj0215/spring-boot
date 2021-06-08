package com.lxhdj.design.pattern.visitor;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:04
 **/

public class Client {

    public static void main(String[] args) {
        case3();
    }

    private static void case3() {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.ceoShowReport();
        System.out.println("=========== CTO看报表 ===========");
        report.ctoShowReport();
    }

    private static void case2() {
        // 构建报表
        BusinessReport report = new BusinessReport(new CEOVisitor());
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        report = new BusinessReport(new CTOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }

    private static void case1() {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
