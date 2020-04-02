package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Chat;
import com.project.model.Order;
import com.project.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: 订单控制层
 * @author: Administrator
 * @create: 2020-03-31 19:46
 */
@Api("订单控制层")
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //返回前端JSON数据
    Map<String,Object> result = new HashMap<>();

    @ApiOperation(value = "查找订单信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="order",value = "订单信息",paramType = "query"),
            @ApiImplicitParam(name="page",value = "页数",paramType = "query"),
            @ApiImplicitParam(name="rows",value = "行数",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAllOrder")
    public Map<String, Object> findAllOrder(Integer page,Integer rows,Order order) {

        //设置每页的记录数
        PageHelper.startPage(page,rows);
        //查询订单信息
        List<Order> list = orderService.findAllOrder(order);
        //封装信息列表
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Order> orderList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", orderList);

        return result;
    }

    @ApiOperation(value = "插入订单信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="order",value = "订单信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("insertOrder")
    public Map<String, Object> insertOrder(Order order) {

        if(orderService.insertOrder(order) > 0){
            result.put("success",true);
            result.put("msg","添加成功!");
        }else{
            result.put("success",false);
            result.put("msg","添加失败!");
        }
        return result;
    }

    @ApiOperation(value = "修改订单信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="order",value = "订单信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("updateOrder")
    public Map<String, Object> updateOrder(Order order) {

        if(orderService.updateOrder(order) > 0){
            result.put("success",true);
            result.put("msg","修改成功!");
        }else{
            result.put("success",false);
            result.put("msg","修改失败!");
        }
        return result;
    }

    @ApiOperation(value = "删除订单信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids",value = "id号",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("deleteOrder")
    public Map<String, Object> deleteOrder(Integer[] ids) {

        if(orderService.deleteOrder(ids) > 0){
            result.put("success",true);
            result.put("msg","删除成功!");
        }else{
            result.put("success",false);
            result.put("msg","删除失败!");
        }

        return result;
    }
}
