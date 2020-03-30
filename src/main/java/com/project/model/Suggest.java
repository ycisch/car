package com.project.model;

/**
 *@Description: 建议表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Suggest {
    private Integer suggestId;

    private Integer userId;

    private Integer driverId;

    private Float suggestScore;

    private String suggestContent;

    private User user;

    private Driver driver;

    @Override
    public String toString() {
        return "Suggest{" +
                "suggestId=" + suggestId +
                ", userId=" + userId +
                ", driverId=" + driverId +
                ", suggestScore=" + suggestScore +
                ", suggestContent='" + suggestContent + '\'' +
                ", user=" + user +
                ", driver=" + driver +
                '}';
    }

    public Integer getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(Integer suggestId) {
        this.suggestId = suggestId;
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

    public Float getSuggestScore() {
        return suggestScore;
    }

    public void setSuggestScore(Float suggestScore) {
        this.suggestScore = suggestScore;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
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

    public Suggest(Integer suggestId, Integer userId, Integer driverId, Float suggestScore, String suggestContent, User user, Driver driver) {
        this.suggestId = suggestId;
        this.userId = userId;
        this.driverId = driverId;
        this.suggestScore = suggestScore;
        this.suggestContent = suggestContent;
        this.user = user;
        this.driver = driver;
    }

    public Suggest() {
    }
}