package com.lxhdj.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.lxhdj.dao.domain.ShareTask;
import com.lxhdj.dao.mapper.ShareTaskMapper;
import com.lxhdj.service.ShareTaskServiceImpl;
import com.lxhdj.web.config.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 分享任务
 * @author: wangguijun1
 * @create: 2019-11-26 10:48
 **/

@RestController
@RequestMapping("/shareTask")
@Slf4j
public class ShareTaskController {

    @Autowired
    private ShareTaskMapper shareTaskMapper;

    @Autowired
    private ShareTaskServiceImpl shareTaskService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String one) {
        log.info("getBeanDefinitionNames=================" + JSON.toJSONString(applicationContext.getBeanDefinitionNames()));
        log.info("shareTaskService================" + shareTaskService.getClass().getName());
        String name = shareTaskService.shareTaskServiceImplOne(one);
        return name;
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<ShareTask> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ShareTask> shareTaskList = shareTaskMapper.selectAll();
        return shareTaskList;
    }

    @RequestMapping(value = "/selectAllTwo", method = RequestMethod.GET)
    public List<ShareTask> selectAllTwo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ShareTaskMapper shareTaskMapper = applicationContext.getBean(ShareTaskMapper.class);
        List<ShareTask> shareTaskList = shareTaskMapper.selectAll();
        return shareTaskList;
    }

    @RequestMapping(value = "/selectByActivityId", method = RequestMethod.GET)
    public List<ShareTask> selectByActivityId(int activityId) {
        ShareTask shareTask = new ShareTask();
        shareTask.setActivityId(activityId);
        ShareTaskMapper shareTaskMapper = SpringContextHolder.getBean(ShareTaskMapper.class);
        List<ShareTask> list = shareTaskMapper.selectBySelective(shareTask, 10);
        return list;
    }


}
