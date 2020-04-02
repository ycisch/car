package com.project.service;

import com.project.model.Demand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface DemandService {

    /**
    *@Description: 查询需求
    *@Param: [demand]
    *@return: java.util.List<com.project.model.Demand>
    *@Author: Administrator
    *@date: 2020/3/31
    */

    List<Demand> findALlDemand(Demand demand);

    /**
     *@Description: 发布需求
     *@Param: [demand]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertDemand(Demand demand);
}
