package com.project.common;

import com.project.model.Driver;
import com.project.model.User;

/**
 * @program: car
 * @description: 经纬度计算距离
 * @author: Administrator
 * @create: 2020-04-02 23:51
 */
public class CalculateDistance {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(User user, Driver driver){
        String[] userPostion = user.getUserPosition().split(",");
        String[] driverPostion = driver.getCarPosition().split(",");
        double lat1 = Double.parseDouble(userPostion[0]);
        double lng1 = Double.parseDouble(userPostion[1]);
        double lat2 = Double.parseDouble(driverPostion[0]);
        double lng2 = Double.parseDouble(driverPostion[1]);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000d) / 10000d;
        return distance;

    }

//    public static void main(String[] args) {
//        User user = new User();
//        Driver driver = new Driver();
//        user.setUserPosition("116.004558,40.119388");
//        driver.setCarPosition("117.000781,40.119389");
//        double ans = getDistance(user,driver);
//        System.out.println(ans);
//    }
}
