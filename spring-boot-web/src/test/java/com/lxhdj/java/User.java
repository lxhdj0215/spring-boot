package com.lxhdj.java;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: 测试
 * @author: wangguijun1
 * @create: 2020-01-10 17:21
 **/

public class User {

    private Integer id;

    private String name;

    private String age;

//    private String sex;
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof User) {
            User other = (User) obj;
            if (compareStr(this.getName(), other.getName()) && compareStr(this.getAge(), other.getAge())) {
                return true;
            }
        }
        return false;
    }

    public boolean compareStr(String str1, String str2) {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {
            return true;
        }
        if (StringUtils.isNotEmpty(str1) && str1.equals(str2)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
