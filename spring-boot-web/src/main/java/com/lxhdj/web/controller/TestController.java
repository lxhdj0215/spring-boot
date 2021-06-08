package com.lxhdj.web.controller;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lxhdj.dao.domain.ShareTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController implements InitializingBean, BeanNameAware, DisposableBean, ApplicationContextAware {

    public TestController() {
        System.out.println("==========instance==========");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==========InitializingBean==========");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("==========BeanNameAware==========" + name);
    }

    @Value("${profiles.active}")
    private String environment;

    @Value("${ppms_36260_item_coreprop_cfg}")
    private String ppms_36260_item_coreprop_cfg;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("==========ApplicationContextAware==========");
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/jsonp")
    public Object jsonP(String name) {
        ShareTask shareTask = new ShareTask();
        shareTask.setBizName(name);
        shareTask.setId(111111111L);
        JSONPObject jsonpObject = new JSONPObject("callback", shareTask);
        return jsonpObject;
    }

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String test(String name) {
        System.out.println(ppms_36260_item_coreprop_cfg);
        TestController testController = applicationContext.getBean(TestController.class);
//        ((TestController) AopContext.currentProxy()).testAop();
//        applicationContext.getBean(TestController.class).testAop("wgj");
//        testAop("wgj");
        System.out.println(JSON.toJSONString(applicationContext.getBeanDefinitionNames()));
        return "Hello " + name;
    }

    private String testAop(String name) {
        System.out.println("=============testAop====================");
        String one = one("wangguijun");
        return "test " + name;
    }

    private String one(String name) {
        System.out.println("one：" + name);
        String two = two("two");
        return "hello " + name;
    }

    private String two(String two) {
        System.out.println("two：" + two);

        Thread thread = new Thread(() -> System.out.println(""));
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("11");
            }
        });

        return "Hello " + two;
    }


    @Override
    public void destroy() throws Exception {

    }
}
