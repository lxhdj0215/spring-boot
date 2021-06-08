package com.lxhdj.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ladder_task")
public class LadderTask {
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
     * 类型：1、商详；2、店铺；3、通天塔
     */
    private Integer type;

    /**
     * 活动类型,活动规则类型：1sku，2spu，3店铺id，4通天塔id,5直播间id
     */
    @Column(name = "match_type")
    private Integer matchType;

    /**
     * 业务id名称
     */
    @Column(name = "biz_name")
    private String bizName;

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
     * 奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     */
    @Column(name = "award_type")
    private Integer awardType;

    /**
     * 任务开始时间
     */
    @Column(name = "task_start_time")
    private Date taskStartTime;

    /**
     * 最近的分享时间
     */
    @Column(name = "recent_share_time")
    private Date recentShareTime;

    /**
     * 活动结束时间
     */
    @Column(name = "activity_end_time")
    private Date activityEndTime;

    /**
     * 第一阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖 3：领奖失败
     */
    @Column(name = "first_ladder_status")
    private Integer firstLadderStatus;

    /**
     * 第一阶梯完成时间
     */
    @Column(name = "first_ladder_complete_time")
    private Date firstLadderCompleteTime;

    /**
     * 第一阶梯助力pin集合
     */
    @Column(name = "first_ladder_pins")
    private String firstLadderPins;

    /**
     * 第一阶梯奖励信息
     */
    @Column(name = "first_ladder_awards")
    private String firstLadderAwards;

    /**
     * 第二阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    @Column(name = "second_ladder_status")
    private Integer secondLadderStatus;

    /**
     * 第二阶梯完成时间
     */
    @Column(name = "second_ladder_complete_time")
    private Date secondLadderCompleteTime;

    /**
     * 第二阶梯助力pin集合
     */
    @Column(name = "second_ladder_pins")
    private String secondLadderPins;

    /**
     * 第二阶梯奖励信息
     */
    @Column(name = "second_ladder_awards")
    private String secondLadderAwards;

    /**
     * 第三阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    @Column(name = "third_ladder_status")
    private Integer thirdLadderStatus;

    /**
     * 第三阶梯完成时间
     */
    @Column(name = "third_ladder_complete_time")
    private Date thirdLadderCompleteTime;

    /**
     * 第三阶梯助力pin集合
     */
    @Column(name = "third_ladder_pins")
    private String thirdLadderPins;

    /**
     * 第三阶梯奖励信息
     */
    @Column(name = "third_ladder_awards")
    private String thirdLadderAwards;

    /**
     * 当前所在阶梯
     */
    private Integer ladder;

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
     * 描述图片
     */
    private String image;

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
     * 获取类型：1、商详；2、店铺；3、通天塔
     *
     * @return type - 类型：1、商详；2、店铺；3、通天塔
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：1、商详；2、店铺；3、通天塔
     *
     * @param type 类型：1、商详；2、店铺；3、通天塔
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取活动类型,活动规则类型：1sku，2spu，3店铺id，4通天塔id,5直播间id
     *
     * @return match_type - 活动类型,活动规则类型：1sku，2spu，3店铺id，4通天塔id,5直播间id
     */
    public Integer getMatchType() {
        return matchType;
    }

    /**
     * 设置活动类型,活动规则类型：1sku，2spu，3店铺id，4通天塔id,5直播间id
     *
     * @param matchType 活动类型,活动规则类型：1sku，2spu，3店铺id，4通天塔id,5直播间id
     */
    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    /**
     * 获取业务id名称
     *
     * @return biz_name - 业务id名称
     */
    public String getBizName() {
        return bizName;
    }

    /**
     * 设置业务id名称
     *
     * @param bizName 业务id名称
     */
    public void setBizName(String bizName) {
        this.bizName = bizName == null ? null : bizName.trim();
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
     * 获取奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     *
     * @return award_type - 奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     */
    public Integer getAwardType() {
        return awardType;
    }

    /**
     * 设置奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     *
     * @param awardType 奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     */
    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    /**
     * 获取任务开始时间
     *
     * @return task_start_time - 任务开始时间
     */
    public Date getTaskStartTime() {
        return taskStartTime;
    }

    /**
     * 设置任务开始时间
     *
     * @param taskStartTime 任务开始时间
     */
    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    /**
     * 获取最近的分享时间
     *
     * @return recent_share_time - 最近的分享时间
     */
    public Date getRecentShareTime() {
        return recentShareTime;
    }

    /**
     * 设置最近的分享时间
     *
     * @param recentShareTime 最近的分享时间
     */
    public void setRecentShareTime(Date recentShareTime) {
        this.recentShareTime = recentShareTime;
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
     * 获取第一阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖 3：领奖失败
     *
     * @return first_ladder_status - 第一阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖 3：领奖失败
     */
    public Integer getFirstLadderStatus() {
        return firstLadderStatus;
    }

    /**
     * 设置第一阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖 3：领奖失败
     *
     * @param firstLadderStatus 第一阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖 3：领奖失败
     */
    public void setFirstLadderStatus(Integer firstLadderStatus) {
        this.firstLadderStatus = firstLadderStatus;
    }

    /**
     * 获取第一阶梯完成时间
     *
     * @return first_ladder_complete_time - 第一阶梯完成时间
     */
    public Date getFirstLadderCompleteTime() {
        return firstLadderCompleteTime;
    }

    /**
     * 设置第一阶梯完成时间
     *
     * @param firstLadderCompleteTime 第一阶梯完成时间
     */
    public void setFirstLadderCompleteTime(Date firstLadderCompleteTime) {
        this.firstLadderCompleteTime = firstLadderCompleteTime;
    }

    /**
     * 获取第一阶梯助力pin集合
     *
     * @return first_ladder_pins - 第一阶梯助力pin集合
     */
    public String getFirstLadderPins() {
        return firstLadderPins;
    }

    /**
     * 设置第一阶梯助力pin集合
     *
     * @param firstLadderPins 第一阶梯助力pin集合
     */
    public void setFirstLadderPins(String firstLadderPins) {
        this.firstLadderPins = firstLadderPins == null ? null : firstLadderPins.trim();
    }

    /**
     * 获取第一阶梯奖励信息
     *
     * @return first_ladder_awards - 第一阶梯奖励信息
     */
    public String getFirstLadderAwards() {
        return firstLadderAwards;
    }

    /**
     * 设置第一阶梯奖励信息
     *
     * @param firstLadderAwards 第一阶梯奖励信息
     */
    public void setFirstLadderAwards(String firstLadderAwards) {
        this.firstLadderAwards = firstLadderAwards == null ? null : firstLadderAwards.trim();
    }

    /**
     * 获取第二阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     *
     * @return second_ladder_status - 第二阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    public Integer getSecondLadderStatus() {
        return secondLadderStatus;
    }

    /**
     * 设置第二阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     *
     * @param secondLadderStatus 第二阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    public void setSecondLadderStatus(Integer secondLadderStatus) {
        this.secondLadderStatus = secondLadderStatus;
    }

    /**
     * 获取第二阶梯完成时间
     *
     * @return second_ladder_complete_time - 第二阶梯完成时间
     */
    public Date getSecondLadderCompleteTime() {
        return secondLadderCompleteTime;
    }

    /**
     * 设置第二阶梯完成时间
     *
     * @param secondLadderCompleteTime 第二阶梯完成时间
     */
    public void setSecondLadderCompleteTime(Date secondLadderCompleteTime) {
        this.secondLadderCompleteTime = secondLadderCompleteTime;
    }

    /**
     * 获取第二阶梯助力pin集合
     *
     * @return second_ladder_pins - 第二阶梯助力pin集合
     */
    public String getSecondLadderPins() {
        return secondLadderPins;
    }

    /**
     * 设置第二阶梯助力pin集合
     *
     * @param secondLadderPins 第二阶梯助力pin集合
     */
    public void setSecondLadderPins(String secondLadderPins) {
        this.secondLadderPins = secondLadderPins == null ? null : secondLadderPins.trim();
    }

    /**
     * 获取第二阶梯奖励信息
     *
     * @return second_ladder_awards - 第二阶梯奖励信息
     */
    public String getSecondLadderAwards() {
        return secondLadderAwards;
    }

    /**
     * 设置第二阶梯奖励信息
     *
     * @param secondLadderAwards 第二阶梯奖励信息
     */
    public void setSecondLadderAwards(String secondLadderAwards) {
        this.secondLadderAwards = secondLadderAwards == null ? null : secondLadderAwards.trim();
    }

    /**
     * 获取第三阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     *
     * @return third_ladder_status - 第三阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    public Integer getThirdLadderStatus() {
        return thirdLadderStatus;
    }

    /**
     * 设置第三阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     *
     * @param thirdLadderStatus 第三阶梯状态 0:未完成 1:已完成 未领奖 2：已完成 已领奖
     */
    public void setThirdLadderStatus(Integer thirdLadderStatus) {
        this.thirdLadderStatus = thirdLadderStatus;
    }

    /**
     * 获取第三阶梯完成时间
     *
     * @return third_ladder_complete_time - 第三阶梯完成时间
     */
    public Date getThirdLadderCompleteTime() {
        return thirdLadderCompleteTime;
    }

    /**
     * 设置第三阶梯完成时间
     *
     * @param thirdLadderCompleteTime 第三阶梯完成时间
     */
    public void setThirdLadderCompleteTime(Date thirdLadderCompleteTime) {
        this.thirdLadderCompleteTime = thirdLadderCompleteTime;
    }

    /**
     * 获取第三阶梯助力pin集合
     *
     * @return third_ladder_pins - 第三阶梯助力pin集合
     */
    public String getThirdLadderPins() {
        return thirdLadderPins;
    }

    /**
     * 设置第三阶梯助力pin集合
     *
     * @param thirdLadderPins 第三阶梯助力pin集合
     */
    public void setThirdLadderPins(String thirdLadderPins) {
        this.thirdLadderPins = thirdLadderPins == null ? null : thirdLadderPins.trim();
    }

    /**
     * 获取第三阶梯奖励信息
     *
     * @return third_ladder_awards - 第三阶梯奖励信息
     */
    public String getThirdLadderAwards() {
        return thirdLadderAwards;
    }

    /**
     * 设置第三阶梯奖励信息
     *
     * @param thirdLadderAwards 第三阶梯奖励信息
     */
    public void setThirdLadderAwards(String thirdLadderAwards) {
        this.thirdLadderAwards = thirdLadderAwards == null ? null : thirdLadderAwards.trim();
    }

    /**
     * 获取当前所在阶梯
     *
     * @return ladder - 当前所在阶梯
     */
    public Integer getLadder() {
        return ladder;
    }

    /**
     * 设置当前所在阶梯
     *
     * @param ladder 当前所在阶梯
     */
    public void setLadder(Integer ladder) {
        this.ladder = ladder;
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
     * 获取描述图片
     *
     * @return image - 描述图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置描述图片
     *
     * @param image 描述图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}