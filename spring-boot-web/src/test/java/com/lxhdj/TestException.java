package com.lxhdj;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-04-10 11:52
 **/

public class TestException extends Exception {
    /**
     * 包含message和cause, 会记录栈异常
     *
     * @param msg
     */
    public TestException(String msg) {
        super(msg, new Exception(), false, false);
    }
}
