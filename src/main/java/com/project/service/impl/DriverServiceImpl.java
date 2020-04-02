package com.project.service.impl;

import com.project.mapper.DriverMapper;
import com.project.model.Driver;
import com.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverMapper driverMapper;

    @Override
    public List<Driver> findAllDriver(Driver driver) {
        return driverMapper.findAllDriver(driver);
    }

    @Override
    public int insertDriver(Driver driver) {
        return driverMapper.insertDriver(driver);
    }

    @Override
    public int updateDriver(Driver driver) {
        return driverMapper.updateDriver(driver);
    }

    @Override
    public int deleteDriver(Integer[] ids) {
        return driverMapper.deleteDriver(ids);
    }

//    @Override
//    public int deleteDriverOrderInfo(Integer[] ids) {
//        return driverMapper.deleteDriverOrderInfo(ids);
//    }

}
