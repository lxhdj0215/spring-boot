package com.lxhdj.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "share_award")
public class ShareAward {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 活动id
     */
    @Column(name = "activity_id")
    private Integer activityId;

    /**
     * biz_id
     */
    @Column(name = "biz_id")
    private String bizId;

    /**
     * 任务标识
     */
    private String token;

    /**
     * 任务发起人pin
     */
    @Column(name = "launch_task_pin")
    private String launchTaskPin;

    /**
     * 京豆数
     */
    private Integer beans;

    /**
     * 优惠券信息
     */
    @Column(name = "coupons_num")
    private Integer couponsNum;

    /**
     * 优惠券信息
     */
    private String coupons;

    /**
     * 领奖状态 0：未领奖，1：已领奖，2：领奖失败
     */
    @Column(name = "reward_flag")
    private Integer rewardFlag;

    /**
     * 阶梯完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 领奖时间
     */
    @Column(name = "reward_time")
    private Date rewardTime;

    /**
     * 阶梯数
     */
    @Column(name = "ladder_num")
    private Integer ladderNum;

    /**
     * 活动结束时间
     */
    @Column(name = "activity_end_time")
    private Date activityEndTime;

    /**
     * 任务的状态 1:正在进行 2：完成 3：失效
     */
    @Column(name = "task_status")
    private Integer taskStatus;

    /**
     * 记录更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 1：分享者 2：被分享者
     */
    private Integer type;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取活动id
     *
     * @return activity_id - 活动id
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * 设置活动id
     *
     * @param activityId 活动id
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取biz_id
     *
     * @return biz_id - biz_id
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 设置biz_id
     *
     * @param bizId biz_id
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 获取任务标识
     *
     * @return token - 任务标识
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置任务标识
     *
     * @param token 任务标识
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取任务发起人pin
     *
     * @return launch_task_pin - 任务发起人pin
     */
    public String getLaunchTaskPin() {
        return launchTaskPin;
    }

    /**
     * 设置任务发起人pin
     *
     * @param launchTaskPin 任务发起人pin
     */
    public void setLaunchTaskPin(String launchTaskPin) {
        this.launchTaskPin = launchTaskPin == null ? null : launchTaskPin.trim();
    }

    /**
     * 获取京豆数
     *
     * @return beans - 京豆数
     */
    public Integer getBeans() {
        return beans;
    }

    /**
     * 设置京豆数
     *
     * @param beans 京豆数
     */
    public void setBeans(Integer beans) {
        this.beans = beans;
    }

    /**
     * 获取优惠券信息
     *
     * @return coupons_num - 优惠券信息
     */
    public Integer getCouponsNum() {
        return couponsNum;
    }

    /**
     * 设置优惠券信息
     *
     * @param couponsNum 优惠券信息
     */
    public void setCouponsNum(Integer couponsNum) {
        this.couponsNum = couponsNum;
    }

    /**
     * 获取优惠券信息
     *
     * @return coupons - 优惠券信息
     */
    public String getCoupons() {
        return coupons;
    }

    /**
     * 设置优惠券信息
     *
     * @param coupons 优惠券信息
     */
    public void setCoupons(String coupons) {
        this.coupons = coupons == null ? null : coupons.trim();
    }

    /**
     * 获取领奖状态 0：未领奖，1：已领奖，2：领奖失败
     *
     * @return reward_flag - 领奖状态 0：未领奖，1：已领奖，2：领奖失败
     */
    public Integer getRewardFlag() {
        return rewardFlag;
    }

    /**
     * 设置领奖状态 0：未领奖，1：已领奖，2：领奖失败
     *
     * @param rewardFlag 领奖状态 0：未领奖，1：已领奖，2：领奖失败
     */
    public void setRewardFlag(Integer rewardFlag) {
        this.rewardFlag = rewardFlag;
    }

    /**
     * 获取阶梯完成时间
     *
     * @return complete_time - 阶梯完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置阶梯完成时间
     *
     * @param completeTime 阶梯完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取领奖时间
     *
     * @return reward_time - 领奖时间
     */
    public Date getRewardTime() {
        return rewardTime;
    }

    /**
     * 设置领奖时间
     *
     * @param rewardTime 领奖时间
     */
    public void setRewardTime(Date rewardTime) {
        this.rewardTime = rewardTime;
    }

    /**
     * 获取阶梯数
     *
     * @return ladder_num - 阶梯数
     */
    public Integer getLadderNum() {
        return ladderNum;
    }

    /**
     * 设置阶梯数
     *
     * @param ladderNum 阶梯数
     */
    public void setLadderNum(Integer ladderNum) {
        this.ladderNum = ladderNum;
    }

    /**
     * 获取活动结束时间
     *
     * @return activity_end_time - 活动结束时间
     */
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    /**
     * 设置活动结束时间
     *
     * @param activityEndTime 活动结束时间
     */
    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    /**
     * 获取任务的状态 1:正在进行 2：完成 3：失效
     *
     * @return task_status - 任务的状态 1:正在进行 2：完成 3：失效
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置任务的状态 1:正在进行 2：完成 3：失效
     *
     * @param taskStatus 任务的状态 1:正在进行 2：完成 3：失效
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取记录更新时间
     *
     * @return modify_time - 记录更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置记录更新时间
     *
     * @param modifyTime 记录更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取记录创建时间
     *
     * @return create_time - 记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录创建时间
     *
     * @param createTime 记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取1：分享者 2：被分享者
     *
     * @return type - 1：分享者 2：被分享者
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1：分享者 2：被分享者
     *
     * @param type 1：分享者 2：被分享者
     */
    public void setType(Integer type) {
        this.type = type;
    }
}