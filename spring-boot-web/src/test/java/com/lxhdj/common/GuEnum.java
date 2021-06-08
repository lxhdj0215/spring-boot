package com.lxhdj.common;

/**
 * @description: 测试
 * @author: wangguijun1
 * @create: 2019-12-17 20:37
 **/

public enum GuEnum {
    ONE(Integer.MIN_VALUE, 0, "不展示此字段"),
    TWO(0, 5, "相当于省了1只鸡腿"),
    THREE(5, 30, "相当于省了1杯奶茶"),
    FOUR(30, 25000, "相当于省了2杯奶茶"),
    THIRTEEN(25000, Integer.MAX_VALUE, "相当于省了1台卡洛德钢琴");

    private int start;
    private int end;
    private String name;


    public static GuEnum getGuEnumByScore(int score) {
        for (GuEnum gu : GuEnum.values()) {
            if (score > gu.getStart() && score <= gu.getEnd()) {
                return gu;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        int score = 250000;
        GuEnum guEnum = getGuEnumByScore(score);
        System.out.println(guEnum.getName());
    }

    GuEnum(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public int getEnd() {
        return end;
    }


    public int getStart() {
        return start;
    }


    public String getName() {
        return name;
    }

}
