package com.project.model;

/**
 *@Description: 顾客表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class User {
    private Integer userId;

    private String userFirstName;

    private String userLastName;

    private String userName;

    private String userSex;

    private String userPhone;

    private String userPassword;

    private String coordinate;

    private String userPosition;

    public User(Integer userId, String userFirstName, String userLastName, String userName, String userSex, String userPhone, String userPassword, String userPosition) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userPosition = userPosition;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPosition='" + userPosition + '\'' +
                '}';
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public User() {
    }
}