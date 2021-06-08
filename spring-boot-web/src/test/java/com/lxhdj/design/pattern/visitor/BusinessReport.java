package com.lxhdj.design.pattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 21:03
 **/

// 员工业务报表类
public class BusinessReport {

    private List<Staff> mStaffs = new LinkedList<>();

    public BusinessReport() {
        mStaffs.add(new Manager("经理-A"));
        mStaffs.add(new Engineer("工程师-A"));
        mStaffs.add(new Engineer("工程师-B"));
        mStaffs.add(new Engineer("工程师-C"));
        mStaffs.add(new Manager("经理-B"));
        mStaffs.add(new Engineer("工程师-D"));
    }

    public BusinessReport(Visitor visitor) {
        mStaffs.add(new Manager("经理-A", visitor));
        mStaffs.add(new Engineer("工程师-A", visitor));
        mStaffs.add(new Engineer("工程师-B", visitor));
        mStaffs.add(new Engineer("工程师-C", visitor));
        mStaffs.add(new Manager("经理-B", visitor));
        mStaffs.add(new Engineer("工程师-D", visitor));
    }

    /**
     * 为访问者展示报表
     *
     * @param visitor 公司高层，如CEO、CTO
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffs) {
            staff.accept(visitor);
//            visitor.visit(staff);
        }
    }

    public void showReport() {
        for (Staff staff : mStaffs) {
            staff.accept();
        }
    }
    public void ceoShowReport() {
        for (Staff staff : mStaffs) {
            ReportUtil.ceoVisit(staff);
        }
    }

    public void ctoShowReport() {
        for (Staff staff : mStaffs) {
            ReportUtil.ctoVisit(staff);
        }
    }


}
