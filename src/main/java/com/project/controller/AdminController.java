package com.project.controller;

import com.project.model.Admin;
import com.project.service.AdminService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: car
 * @description: 管理员控制层
 * @author: Administrator
 * @create: 2020-03-31 16:35
 */
@Api("管理员控制层功能")
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //返回前端JSON数据
    Map<String,Object> result = new HashMap<>();

    @ApiOperation(value = "查询管理员信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="admin",value = "管理员信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAdminInfo")
    public Map<String,Object> findAdminInfo(Admin admin, HttpServletRequest request){

        admin = adminService.findAdminInfo(admin);

        request.getSession().setAttribute("adminInfo",admin);

        if(admin != null){
            result.put("admin",admin);
            result.put("success",true);
            result.put("msg","查询成功");
        }else{
            result.put("success",false);
        }

        return result;
    }

    @ApiOperation(value = "修改管理员信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="admin",value = "管理员信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("updateAdmin")
    public Map<String, Object> updateAdmin(Admin admin,HttpServletRequest request) {

        if(adminService.updateAdmin(admin) > 0){
            result.put("success",true);
            result.put("msg","修改成功!");
            request.getSession().setAttribute("adminInfo",admin);
        }else{
            result.put("success",false);
            result.put("msg","服务器出现问题，请重新尝试!");
        }
        return result;
    }

    @ApiOperation(value = "管理员登录", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name="admin",value = "管理员信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("adminLogin")
    public Map<String, Object> adminLogin(Admin admin,HttpServletRequest request) {

        admin = adminService.adminLogin(admin);
        if(admin != null){
            request.getSession().setAttribute("adminInfo",admin);
            result.put("success",true);
            result.put("msg","登陆成功!");
        }else{
            result.put("success",false);
            result.put("msg","服务器出现问题，请重新尝试!");
        }
        return result;
    }
}
