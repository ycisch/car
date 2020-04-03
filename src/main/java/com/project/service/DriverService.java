package com.project.service;

import com.project.model.Driver;
import com.project.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface DriverService {

    /**
     *@Description: 获取司机信息 可以根据司机姓名进行查找
     *@Param: [driver]
     *@return: java.util.List<com.project.model.Driver>
     *@Author: Administrator
     *@date: 2020/3/30
     */
    List<Driver> findAllDriver(Driver driver);

    /**
     *@Description: 添加司机
     *@Param: [driver]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertDriver(Driver driver);

    /**
     *@Description: 修改司机信息
     *@Param: [driver]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int updateDriver(Driver driver);

    /**
     *@Description: 删除司机信息
     *@Param: [ids]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int deleteDriver(Integer[] ids);

    /**
     *@Description: 司机登陆
     *@Param: [driver]
     *@return: com.project.model.Driver
     *@Author: Administrator
     *@date: 2020/4/3
     */
    Driver driverLogin(Driver driver);
}
