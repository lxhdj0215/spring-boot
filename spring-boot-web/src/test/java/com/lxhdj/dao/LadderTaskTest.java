package com.lxhdj.dao;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxhdj.base.BaseTest;
import com.lxhdj.dao.domain.LadderTask;
import com.lxhdj.dao.mapper.LadderTaskMapper;
import com.lxhdj.dao.mapper.ShareTaskMapper;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LadderTaskTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(LadderTaskTest.class);

    @Autowired
    private LadderTaskMapper ladderTaskMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void selectAll() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/workspace/spring-boot/target/cglib/");
        List<LadderTask> ladderTaskList = ladderTaskMapper.selectAll();
        logger.info("=====================" + ladderTaskMapper.getClass().getName());
        logger.info("=====================" + JSON.toJSONString(ladderTaskMapper.getClass().getInterfaces()));
        logger.info("=====================" + ladderTaskList.size());
        logger.info("=================" + JSON.toJSONString(applicationContext.getBeanDefinitionNames()));
//        ObjectMapper jacksonObjectMapper = (ObjectMapper) applicationContext.getBean("jacksonObjectMapper");
        logger.info("jacksonObjectMapper = " + JSON.toJSONString(applicationContext.getBean("jacksonObjectMapper").getClass().getInterfaces()));
        logger.info("jacksonObjectMapper = " + JSON.toJSONString(applicationContext.getBean("jacksonObjectMapper").getClass().getSuperclass().getName()));
        System.out.println(JSON.toJSONString(ladderTaskList));
    }

    @Test
    public void selectTest() {
        LadderTask ladderTask = new LadderTask();
        ladderTask.setLaunchTaskPin("wgj5");
        List<LadderTask> ladderTaskList = ladderTaskMapper.select(ladderTask);
        logger.info("=====================" + ladderTaskList.size());
        System.out.println(JSON.toJSONString(ladderTaskList));
    }

    @Test
    public void insertSelective() {
        LadderTask ladderTask = new LadderTask();
        ladderTask.setActivityId(111);
        ladderTask.setBizId("11243");
        ladderTask.setType(1);
        ladderTask.setMatchType(1);
        ladderTask.setBizName("王桂军");
        ladderTask.setToken("asldfjaskfdasdjdfsdkafjk");
        ladderTask.setLaunchTaskPin("wangguijun1");
        ladderTask.setAwardType(1);
        ladderTask.setActivityEndTime(new Date());
        ladderTask.setFirstLadderStatus(0);
        ladderTask.setSecondLadderStatus(0);
        ladderTask.setLadder(1);
        ladderTask.setTaskStatus(1);
        ladderTask.setModifyTime(new Date());
        ladderTask.setCreateTime(new Date());
        int count = ladderTaskMapper.insertSelective(ladderTask);
        logger.info("==========================count = " + count);
    }
}
