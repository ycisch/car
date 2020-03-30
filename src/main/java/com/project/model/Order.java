package com.project.model;

import java.util.Date;

/**
 *@Description: 订单表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Order {
    private Integer orderId;

    private String orderType;

    private String orderStart;

    private String orderEnd;

    private Integer driverId;

    private Integer userId;

    private Date createTime;

    private Date endTime;

    private Float orderFare;

    private Float orderScore;

    private String orderStatus;

    private User user;

    private Driver driver;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderType='" + orderType + '\'' +
                ", orderStart='" + orderStart + '\'' +
                ", orderEnd='" + orderEnd + '\'' +
                ", driverId=" + driverId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", orderFare=" + orderFare +
                ", orderScore=" + orderScore +
                ", orderStatus='" + orderStatus + '\'' +
                ", user=" + user +
                ", driver=" + driver +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStart() {
        return orderStart;
    }

    public void setOrderStart(String orderStart) {
        this.orderStart = orderStart;
    }

    public String getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
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

    public Float getOrderFare() {
        return orderFare;
    }

    public void setOrderFare(Float orderFare) {
        this.orderFare = orderFare;
    }

    public Float getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(Float orderScore) {
        this.orderScore = orderScore;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public Order(Integer orderId, String orderType, String orderStart, String orderEnd, Integer driverId, Integer userId, Date createTime, Date endTime, Float orderFare, Float orderScore, String orderStatus, User user, Driver driver) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.orderStart = orderStart;
        this.orderEnd = orderEnd;
        this.driverId = driverId;
        this.userId = userId;
        this.createTime = createTime;
        this.endTime = endTime;
        this.orderFare = orderFare;
        this.orderScore = orderScore;
        this.orderStatus = orderStatus;
        this.user = user;
        this.driver = driver;
    }

    public Order() {
    }
}