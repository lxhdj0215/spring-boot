package com.lxhdj.dao;


import com.alibaba.fastjson.JSON;
import com.lxhdj.base.BaseTest;
import com.lxhdj.dao.domain.ActivityPinDO;
import com.lxhdj.dao.mapper.ActivityPinDOMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ActivityPinDOTest extends BaseTest {

    @Autowired
    private ActivityPinDOMapper activityPinDOMapper;

    @Test
    public void activityPinInsertTest() {
        ActivityPinDO activityPinDO = new ActivityPinDO();
        activityPinDO.setActivityId(12346);
        activityPinDO.setLaunchTaskPin("wgj");
        activityPinDO.setCreateTime(new Date());
        activityPinDO.setModifyTime(new Date());
        activityPinDO.setActivityStatus(1);
        int count = activityPinDOMapper.insert(activityPinDO);
        System.out.println(count);
    }

    @Test
    public void select() {
        ActivityPinDO activityPinDO = activityPinDOMapper.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(activityPinDO));
    }
}
