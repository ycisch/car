package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.CalculateDistance;
import com.project.model.Driver;
import com.project.model.User;
import com.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: 司机
 * @author: Administrator
 * @create: 2020-03-31 21:12
 */
@RequestMapping("Driver")
@Controller
public class DriverController {

    private Map<String , Object > result = new HashMap<>();


    @Autowired
    private DriverService driverService;

    /**
     *@Description: 跳转司机页面显示页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/3/31
     */
    @ResponseBody
    @RequestMapping("goDriverList")
    public ModelAndView goDriverList(ModelAndView modelAndView){
        modelAndView.setViewName("driver/DriverList");
        return modelAndView;
    }

    /**
    *@Description: 添加司机
    *@Param: [driver]
    *@return: java.util.Map<java.lang.String,java.lang.Object>
    *@Author: Administrator
    *@date: 2020/4/2
    */
    @RequestMapping("insertDriver")
    @ResponseBody
    public Map<String , Object > insertDriver(Driver driver){
        if(driverService.insertDriver(driver) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 删除司机档案
     *@Param: [ids]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("deleteDriver")
    @ResponseBody
    public Map<String,Object> deleteDriver(@RequestParam(value = "ids[]", required = true) Integer[] ids){

        if(driverService.deleteDriver(ids) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "删除失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 修改司机档案
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/7
     */
    @RequestMapping("editDriver")
    @ResponseBody
    public Map<String,Object>updataDriver(Driver driver){
        if(driverService.updateDriver(driver) > 0){
            result.put("success", true);
        }
        else {
            result.put("success", false);
            result.put("msg", "修改失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 查询司机
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("getDriverList")
    @ResponseBody
    public Map<String,Object>findAllDriver(Integer page, Integer rows,Driver driver){
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //查询公告信息
        List<Driver> list = driverService.findAllDriver(driver);
        //封装信息列表
        PageInfo<Driver> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Driver> noticeList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", noticeList);
        return result;
    }

//    /**
//    *@Description: 查找附近司机
//    *@Param: [page, rows, driver]
//    *@return: java.util.Map<java.lang.String,java.lang.Object>
//    *@Author: Administrator
//    *@date: 2020/4/2
//    */
//    public Map<String,Object>findDriverByDistance(Integer page, Integer rows, Driver driver, HttpServletRequest request){
//
//        User user = ((User) request.getSession().getAttribute("userInfo"));
//        PageHelper.startPage(page, rows);
//        CalculateDistance calculateDistance = new CalculateDistance();
//        List<Driver> list = driverService.findAllDriver(driver);
//        for (int i = 0;i<list.size();i++){
//            Driver driver1 = list.get(i);
//            double distance = calculateDistance.getDistance(user, driver1);
//            driver1.setDistance((float)distance);
//            driverService.updateDriver(driver1);
//        }
//
//        PageInfo<Driver> pageInfo = new PageInfo<>(list);
//        long total = pageInfo.getTotal();
//        List<Driver> driverList = pageInfo.getList();
//        result.put("rows", driverList);
//        result.put("total", total);
//        return result;
//    }
}
