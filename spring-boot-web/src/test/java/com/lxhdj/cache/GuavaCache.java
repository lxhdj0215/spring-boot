package com.lxhdj.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jd.jim.cli.Cluster;
import com.lxhdj.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-05-06 16:24
 **/

public class GuavaCache extends BaseTest {

    @Autowired
    private Cluster cluster;

    @Test
    public void test1() {
        System.out.println("7c7e1d902dddd00906fbeb8f4a83cb504");
        Cache<String, ResponseEntity> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build();
        // 获取某个key时，在Cache.get中单独为其指定load方法
        try {
            String key = "wgj";
            cluster.set(key, "wangguijun");
            for (int i = 0; i < 10; i++) {
                ResponseEntity<String> responseEntity = cache.get(key, () -> getValue(key, String.class));
                System.out.println(responseEntity.getBody());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private <T>  ResponseEntity<T> getValue(String key, Class<T> clazz) {
        String bodyStr = cluster.get(key);
        T responseBody = JSON.parseObject(bodyStr, clazz);
        // 若存储的内容正常时，返回此内容
        if (responseBody == null) {
            return null;
        }
        ResponseEntity<T> responseEntity = new ResponseEntity<T>(responseBody, HttpStatus.OK);
        return null;
    }
}
