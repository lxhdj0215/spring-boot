package com.lxhdj.dao;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.lxhdj.base.BaseTest;
import com.lxhdj.dao.domain.ShareTask;
import com.lxhdj.dao.mapper.ShareTaskMapper;
import com.lxhdj.service.ShareTaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class ShareTaskTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(ShareTaskTest.class);

    @Autowired
    private ShareTaskMapper shareTaskMapper;

    @Autowired
    private ShareTaskServiceImpl shareTaskServiceImpl;

    @Test
    public void test() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/workspace/spring-boot/target/cglib/");
        String name = shareTaskServiceImpl.shareTaskServiceImplOne("wgj");
        System.out.println(shareTaskServiceImpl.getClass().getName());
        System.out.println(name);
    }

    @Test
    public void selectAll() {
        int pageNum = 0;
        int pageSize = 1000;
        PageHelper.startPage(pageNum, pageSize);
        List<ShareTask> shareTaskList = shareTaskMapper.selectAll();
        log.info("shareTaskList length = " + shareTaskList.size());
        log.info(JSON.toJSONString(shareTaskList));
    }

    @Test
    public void insertSelectiveTest() {
        ShareTask shareTask = new ShareTask();
        shareTask.setActivityId(866);
        shareTask.setType(1);
        shareTask.setBizId("100472");
        shareTask.setBizName("施德楼（STAEDTLER）S318-9 黑色 光盘笔（采用特殊墨水，书写流畅）");
        shareTask.setAwardDesc("邀请3人最多可得10京豆");
        shareTask.setAwardType(2);
        shareTask.setMatchType(1);
        shareTask.setActivityEndTime(new Date());
        int result = shareTaskMapper.insertSelective(shareTask);
        System.out.println(result);
    }

    @Test
    public void selectBySelectiveTest() {
        ShareTask shareTask = new ShareTask();
        shareTask.setActivityId(865);
        List<ShareTask> list = shareTaskMapper.selectBySelective(shareTask, 10);
        logger.info("============" + JSON.toJSONString(list));
    }
}
