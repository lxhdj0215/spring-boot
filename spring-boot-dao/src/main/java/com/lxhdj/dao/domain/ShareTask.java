package com.lxhdj.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "share_task")
public class ShareTask {
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
     * 描述语
     */
    @Column(name = "award_desc")
    private String awardDesc;

    /**
     * 奖励类型，1：分享完成返奖；2：分享引入好友查看返奖
     */
    @Column(name = "award_type")
    private Integer awardType;

    /**
     * 活动结束时间
     */
    @Column(name = "activity_end_time")
    private Date activityEndTime;

    /**
     * 分享数
     */
    @Column(name = "shared_num")
    private Integer sharedNum;

    /**
     * 活动状态 1：正在进行 2：已结束
     */
    @Column(name = "activity_status")
    private Integer activityStatus;

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
     * 获取描述语
     *
     * @return award_desc - 描述语
     */
    public String getAwardDesc() {
        return awardDesc;
    }

    /**
     * 设置描述语
     *
     * @param awardDesc 描述语
     */
    public void setAwardDesc(String awardDesc) {
        this.awardDesc = awardDesc == null ? null : awardDesc.trim();
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
     * 获取分享数
     *
     * @return shared_num - 分享数
     */
    public Integer getSharedNum() {
        return sharedNum;
    }

    /**
     * 设置分享数
     *
     * @param sharedNum 分享数
     */
    public void setSharedNum(Integer sharedNum) {
        this.sharedNum = sharedNum;
    }

    /**
     * 获取活动状态 1：正在进行 2：已结束
     *
     * @return activity_status - 活动状态 1：正在进行 2：已结束
     */
    public Integer getActivityStatus() {
        return activityStatus;
    }

    /**
     * 设置活动状态 1：正在进行 2：已结束
     *
     * @param activityStatus 活动状态 1：正在进行 2：已结束
     */
    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
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