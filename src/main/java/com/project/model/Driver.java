package com.project.model;

/**
 *@Description: 司机表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Driver {
    private Integer driverId;

    private String driverFirstName;

    private String driverLastName;

    private String driverName;

    private String driverSex;

    private String driverPhone;

    private String driverPassword;

    private String driverCardid;

    private Integer carId;

    private String carType;

    private String carColor;

    private String carSeat;

    private String carStatus;

    private String carPosition;

    private Integer carNum;

    private Float distance;

    private Float carScore;

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverFirstName='" + driverFirstName + '\'' +
                ", driverLastName='" + driverLastName + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverSex='" + driverSex + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", driverPassword='" + driverPassword + '\'' +
                ", driverCardid='" + driverCardid + '\'' +
                ", carId=" + carId +
                ", carType='" + carType + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carSeat='" + carSeat + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", carPosition='" + carPosition + '\'' +
                ", carNum=" + carNum +
                ", distance=" + distance +
                ", carScore=" + carScore +
                '}';
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public String getDriverSex() {
        return driverSex;
    }

    public void setDriverSex(String driverSex) {
        this.driverSex = driverSex;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public String getDriverCardid() {
        return driverCardid;
    }

    public void setDriverCardid(String driverCardid) {
        this.driverCardid = driverCardid;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(String carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(String carPosition) {
        this.carPosition = carPosition;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getCarScore() {
        return carScore;
    }

    public void setCarScore(Float carScore) {
        this.carScore = carScore;
    }

    public Driver(Integer driverId, String driverFirstName, String driverLastName, String driverName, String driverSex, String driverPhone, String driverPassword, String driverCardid, Integer carId, String carType, String carColor, String carSeat, String carStatus, String carPosition, Integer carNum, Float distance, Float carScore) {
        this.driverId = driverId;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverName = driverName;
        this.driverSex = driverSex;
        this.driverPhone = driverPhone;
        this.driverPassword = driverPassword;
        this.driverCardid = driverCardid;
        this.carId = carId;
        this.carType = carType;
        this.carColor = carColor;
        this.carSeat = carSeat;
        this.carStatus = carStatus;
        this.carPosition = carPosition;
        this.carNum = carNum;
        this.distance = distance;
        this.carScore = carScore;
    }

    public Driver() {
    }
}

/*

edit_driverFirstName
edit_driverLastName
edit_driverSex
edit_driverPhone
edit_driverPassword
edit_driverCardid
edit_carType
edit_carColor
edit_carSeat



add_driverFirstName
add_driverLastName
add_driverSex
add_driverPhone
add_driverPassword
add_driverCardid
add_carType
add_carColor
add_carSeat

*/