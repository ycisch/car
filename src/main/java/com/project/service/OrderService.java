package com.project.service;

import com.project.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface OrderService {

    /**
     *@Description: 查看所有订单信息
     *@Param: [order]
     *@return: java.util.List<com.project.model.Order>
     *@Author: Administrator
     *@date: 2020/3/30
     */
    List<Order> findAllOrder(Order order);

    /**
     *@Description: 添加订单信息
     *@Param: [order]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertOrder(Order order);

    /**
     *@Description: 修改订单信息
     *@Param: [order]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int updateOrder(Order order);

    /**
     *@Description: 删除订单信息
     *@Param: [ids]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int deleteOrder(Integer[] ids);

}
