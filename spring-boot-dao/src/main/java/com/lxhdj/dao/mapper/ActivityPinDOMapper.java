package com.lxhdj.dao.mapper;

import com.lxhdj.dao.domain.ActivityPinDO;

public interface ActivityPinDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    int insert(ActivityPinDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    int insertSelective(ActivityPinDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    ActivityPinDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ActivityPinDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_pin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ActivityPinDO record);
}