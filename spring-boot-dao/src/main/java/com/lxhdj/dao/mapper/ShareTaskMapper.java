package com.lxhdj.dao.mapper;

import com.lxhdj.dao.domain.ShareTask;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShareTaskMapper extends Mapper<ShareTask> {

    List<ShareTask> selectBySelective(@Param("shareTask")ShareTask shareTask, @Param("limit") Integer limit);

}