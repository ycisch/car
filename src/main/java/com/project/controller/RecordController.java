package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Order;
import com.project.model.Record;
import com.project.service.OrderService;
import com.project.service.RecordService;
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
 * @description: 记录控制层
 * @author: Administrator
 * @create: 2020-03-31 19:46
 */
@Api("记录控制层")
@Controller
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;

    //返回前端JSON数据
    Map<String,Object> result = new HashMap<>();

    @ApiOperation(value = "查找记录信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="record",value = "订单信息",paramType = "query"),
            @ApiImplicitParam(name="page",value = "页数",paramType = "query"),
            @ApiImplicitParam(name="rows",value = "行数",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAllRecord")
    public Map<String, Object> findAllRecord(Integer page,Integer rows,Record record) {

        //设置每页的记录数
        PageHelper.startPage(page,rows);
        //查询订单信息
        List<Record> list = recordService.findAllRecord(record);
        //封装信息列表
        PageInfo<Record> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Record> recordList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", recordList);

        return result;
    }

    @ApiOperation(value = "插入记录信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="record",value = "记录信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("insertRecord")
    public Map<String, Object> insertRecord(Record record) {

        if(recordService.insertRecord(record) > 0){
            result.put("success",true);
            result.put("msg","添加成功!");
        }else{
            result.put("success",false);
            result.put("msg","添加失败!");
        }
        return result;
    }

    @ApiOperation(value = "修改记录信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="record",value = "记录信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("updateRecord")
    public Map<String, Object> updateOrder(Record record) {

        if(recordService.updateRecord(record) > 0){
            result.put("success",true);
            result.put("msg","修改成功!");
        }else{
            result.put("success",false);
            result.put("msg","修改失败!");
        }
        return result;
    }

    @ApiOperation(value = "删除记录信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids",value = "id号",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("deleteRecord")
    public Map<String, Object> deleteRecord(Integer[] ids) {

        if(recordService.deleteRecord(ids) > 0){
            result.put("success",true);
            result.put("msg","删除成功!");
        }else{
            result.put("success",false);
            result.put("msg","删除失败!");
        }

        return result;
    }
}
