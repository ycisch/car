package com.project.model;

import java.util.Date;

/**
 *@Description: 需求表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Demand {
    private Integer demandId;

    private Integer userId;

    private Date demandTime;

    private String demandContent;

    private User user;

    @Override
    public String toString() {
        return "Demand{" +
                "demandId=" + demandId +
                ", userId=" + userId +
                ", demandTime=" + demandTime +
                ", demandContent='" + demandContent + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
    }

    public String getDemandContent() {
        return demandContent;
    }

    public void setDemandContent(String demandContent) {
        this.demandContent = demandContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Demand() {
    }

    public Demand(Integer demandId, Integer userId, Date demandTime, String demandContent, User user) {
        this.demandId = demandId;
        this.userId = userId;
        this.demandTime = demandTime;
        this.demandContent = demandContent;
        this.user = user;
    }
}