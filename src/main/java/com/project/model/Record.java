package com.project.model;

import java.util.Date;

/**
 *@Description: 记录表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Record {
    private Integer recordId;

    private String recordType;

    private String recordStart;

    private String recordEnd;

    private Integer driverId;

    private Integer userId;

    private Date createTime;

    private Date endTime;

    private Float recordFare;

    private Float recordStatus;

    private User user;

    private Driver driver;

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", recordType='" + recordType + '\'' +
                ", recordStart='" + recordStart + '\'' +
                ", recordEnd='" + recordEnd + '\'' +
                ", driverId=" + driverId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", recordFare=" + recordFare +
                ", recordStatus=" + recordStatus +
                ", user=" + user +
                ", driver=" + driver +
                '}';
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordStart() {
        return recordStart;
    }

    public void setRecordStart(String recordStart) {
        this.recordStart = recordStart;
    }

    public String getRecordEnd() {
        return recordEnd;
    }

    public void setRecordEnd(String recordEnd) {
        this.recordEnd = recordEnd;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getRecordFare() {
        return recordFare;
    }

    public void setRecordFare(Float recordFare) {
        this.recordFare = recordFare;
    }

    public Float getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Float recordStatus) {
        this.recordStatus = recordStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Record(Integer recordId, String recordType, String recordStart, String recordEnd, Integer driverId, Integer userId, Date createTime, Date endTime, Float recordFare, Float recordStatus, User user, Driver driver) {
        this.recordId = recordId;
        this.recordType = recordType;
        this.recordStart = recordStart;
        this.recordEnd = recordEnd;
        this.driverId = driverId;
        this.userId = userId;
        this.createTime = createTime;
        this.endTime = endTime;
        this.recordFare = recordFare;
        this.recordStatus = recordStatus;
        this.user = user;
        this.driver = driver;
    }

    public Record() {
    }
}