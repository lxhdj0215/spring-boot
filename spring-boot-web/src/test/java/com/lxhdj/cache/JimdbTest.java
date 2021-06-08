package com.lxhdj.cache;

import com.alibaba.fastjson.JSON;
import com.jd.jim.cli.Cluster;
import com.lxhdj.base.BaseTest;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JimdbTest extends BaseTest {

    @Autowired
    private Cluster cluster;

    @Test
    public void jimTest() {
        ArrayList list = new ArrayList<>();
        list.add("ceshi");

        String key = "wgj";
        String value = cluster.get(key);
        if (StringUtils.isBlank(value)) {
            cluster.set(key, key);
        }
        value = cluster.get(key);
        System.out.println(value);
    }

    public void limit2() {
        String key = "wgj";
        Long count = cluster.incr(key);
        if (count == 1) {
            // 首次
            cluster.setEx(key, String.valueOf(1), 1, TimeUnit.SECONDS);
        } else if (count > 100) {
            // 限流
            return;
        }

    }

    @Test
    public void limit3() {
        String key = "wgj";
        cluster.del(key);
        for (int i = 0; i < 10; i++) {
            Boolean bol = cluster.set(key, "1", 1, TimeUnit.SECONDS, false);
            Long count = cluster.incr(key);
            System.out.println("bol = " + bol + " count = " + count);
            if (count > 1000) {
                // 限流
                return;
            }
        }
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================" + cluster.get(key));
    }

    public void limit1() {
        String key = "wgj";
        if (cluster.exists(key)) {
            Long count = cluster.incr(key);
            if (count == 1) {
                cluster.setEx(key, String.valueOf(1), 1, TimeUnit.SECONDS);
            }
            if (count >= 100) {
                // 限流
                return;
            }
        } else {
            cluster.setEx(key, String.valueOf(1), 1, TimeUnit.SECONDS);
        }
    }
}
