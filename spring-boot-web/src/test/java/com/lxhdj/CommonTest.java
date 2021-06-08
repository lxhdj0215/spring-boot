package com.lxhdj;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxhdj.java.User;
import com.lxhdj.proxy.aop.ExceptionAspect;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

@Slf4j
public class CommonTest {

    @Test
    public void copy() {
        File f = new File(".");
        String str = "";
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println(str);
                return false;
            }
        };
        File[] files = f.listFiles(fileFilter);
    }

    private void threadTest(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }


    @Test
    public void test6() {
        try {
            test7();
        } catch (Exception e) {
            log.info("error = ", e);
        }
    }

    private void test7() throws Exception {
        throw new TestException("测试");
    }


    @Test
    public void test5() {
        try {
            List<Integer> listAwardStatus = new ArrayList<>();
            listAwardStatus.add(0);
            List<String> shareAwardDOList = new ArrayList<>();
            shareAwardDOList.add("A");
            Iterator<String> iterator = shareAwardDOList.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Integer awardStatus = listAwardStatus.get(index);
                if (awardStatus == null || 0 != awardStatus) {
                    iterator.remove();
                }
                index++;
            }
            System.out.println(JSON.toJSONString("==============="));
        } catch (Exception e) {
            throw e;
        }

    }

    @Test
    public void test4() {
        String str = "alien0226";
        System.out.println(str.hashCode() % 32);
    }

    @Test
    public void test3() {
        List<String> list = Collections.emptyList();
        try {
            System.out.println(list.get(10));
        } catch (Exception e) {
            throw e;
        }
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {
        float f1 = 0.1f * 0.1f;
        float f2 = 0.5f * 0.5f;
        System.out.println(f1);
        System.out.println(f2);
    }


    @Test
    public void test1() {
        Long l1 = 128L;
        Long l2 = 128L;
        Long l3 = new Long(127L);
        Long l4 = new Long(127L);
        System.out.println(l1 == l2);
        System.out.println(l3 == l4);
    }
}
