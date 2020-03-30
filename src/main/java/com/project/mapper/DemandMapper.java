package com.project.mapper;

import com.project.model.Demand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: car
 * @description: 需求Mapper
 * @author: Administrator
 * @create: 2020-03-29 23:18
 */
@Mapper
public interface DemandMapper {

    /**
    *@Description: 查看所有需求  可以根据用户来进行查找
    *@Param: [demand]
    *@return: java.util.List<com.project.model.Demand>
    *@Author: Administrator
    *@date: 2020/3/30
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
