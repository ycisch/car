package com.project.model;

import java.util.Date;

/**
*@Description: 留言表
*@Author: Administrator
*@date: 2020/3/29
*/
public class Message {
    private Integer messageId;

    private Integer userId;

    private Integer driverId;

    private Date messageTime;

    private String messageContent;
    
    private User user;
    
    private Driver driver;

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", driverId=" + driverId +
                ", messageTime=" + messageTime +
                ", messageContent='" + messageContent + '\'' +
                ", user=" + user +
                ", driver=" + driver +
                '}';
    }

    public Message(Integer messageId, Integer userId, Integer driverId, Date messageTime, String messageContent, User user, Driver driver) {
        this.messageId = messageId;
        this.userId = userId;
        this.driverId = driverId;
        this.messageTime = messageTime;
        this.messageContent = messageContent;
        this.user = user;
        this.driver = driver;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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

    public Message() {
    }
}