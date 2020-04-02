package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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


    /**
     *@Description: 跳转司机页面显示页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/3/31
     */
    @RequestMapping("goDriverList")
    public ModelAndView goDemandList(ModelAndView modelAndView){
        modelAndView.setViewName("driver/DriverList");
        return modelAndView;
    }


}
