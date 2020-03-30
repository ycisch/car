package com.project.model;

import java.util.Date;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-30 00:25
 */
public class Money {

    public static String idmoney = "";            //商品编号
    public static float money = 0.0f;          //价格

    private int id;
    private User user;
    private String moneyId;
    private float moneyNum;
    private Date moneyTime;
    private String moneyType;

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", user=" + user +
                ", moneyId='" + moneyId + '\'' +
                ", moneyNum=" + moneyNum +
                ", moneyTime=" + moneyTime +
                ", moneyType='" + moneyType + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId;
    }

    public float getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(float moneyNum) {
        this.moneyNum = moneyNum;
    }

    public Date getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public Money() {
    }

    public Money(int id, User user, String moneyId, float moneyNum, Date moneyTime, String moneyType) {
        this.id = id;
        this.user = user;
        this.moneyId = moneyId;
        this.moneyNum = moneyNum;
        this.moneyTime = moneyTime;
        this.moneyType = moneyType;
    }
}
