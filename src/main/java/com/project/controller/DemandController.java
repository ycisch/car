package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Demand;
import com.project.model.User;
import com.project.service.DemandService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: 需求
 * @author: Administrator
 * @create: 2020-03-31 20:21
 */

@RequestMapping("demand")
@Controller
public class DemandController {
    private Map<String , Object > result = new HashMap<>();

    @Autowired
    private DemandService demandService;
    @Autowired
    private UserService userService;

    /**
    *@Description: 跳转需求页面显示页面
    *@Param: [modelAndView]
    *@return: org.springframework.web.servlet.ModelAndView
    *@Author: Administrator
    *@date: 2020/3/31
    */
    @RequestMapping("goDemandList")
    public ModelAndView goDemandList(ModelAndView modelAndView){
        modelAndView.setViewName("demand/DemandList");
        return modelAndView;
    }

    /**
    *@Description: 查询需求
    *@Param: []
    *@return: java.util.Map<java.lang.String,java.lang.Object>
    *@Author: Administrator
    *@date: 2020/3/31
    */
    @RequestMapping("getDemandList")
    public Map<String, Object> getDemandList(Integer page, Integer rows,Demand demand){

        PageHelper.startPage(page,rows);
        List<Demand> list = demandService.findALlDemand(demand);
        PageInfo<Demand> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();

        List<Demand> DemandList = pageInfo.getList();

        result.put("total",total);
        result.put("rows",DemandList);
        return  result;
    }

    /**
    *@Description: 添加需求
    *@Param: [demand, request]
    *@return: java.util.Map<java.lang.String,java.lang.Object>
    *@Author: Administrator
    *@date: 2020/3/31
    */
    @RequestMapping("addDemand")
    public Map<String, Object> addDemand(Demand demand, HttpServletRequest request){
        demand.setUser((User)request.getSession().getAttribute("userInfo"));
        if(demandService.insertDemand(demand) > 0 ){
            result.put("Success" ,true);
        }else{
            result.put("Success" ,false);
            result.put("msg","添加失败");
        }
        return result;
    }
}
