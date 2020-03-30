package com.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: car
 * @description:控制刚开始所有前端页面跳转
 * @author: Administrator
 * @create: 2020-03-30 00:37
 */
@Api("跳转方法")
@RequestMapping("sys")
@Controller
public class SystemController {

    /**
     * @description: 跳转到用户登录页面
     * @param: no
     * @date: 2019-06-09 6:34 PM
     * @return: java.lang.String
     */
    @RequestMapping("goLogin")
    @ApiOperation(value = "跳转到登陆界面",httpMethod = "GET")
    public String goLogin(){
        return "system/login";
    }

    /**
     *@Description: 跳转到管理员页面
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("adminList")
    @ApiOperation(value = "跳转到管理员界面",httpMethod = "GET")
    public String goAdminList(){
        return "pradmin/adminList";
    }

    /**
    *@Description: 跳转到聊天页面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("chatList")
    @ApiOperation(value = "跳转到聊天界面",httpMethod = "GET")
    public String goChatList(){
        return "prchat/chatList";
    }

    /**
    *@Description: 需求界面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("demandList")
    @ApiOperation(value = "跳转到需求界面",httpMethod = "GET")
    public String goDemandList(){
        return "prdemand/demandList";
    }

    /**
    *@Description: 司机界面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("driverList")
    @ApiOperation(value = "跳转到司机界面",httpMethod = "GET")
    public String goDriverList(){
        return "prdriver/driverList";
    }

    /**
     *@Description:留言板
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("messageList")
    @ApiOperation(value = "跳转到留言板界面",httpMethod = "GET")
    public String goMessageList(){
        return "prmessage/messageList";
    }

    /**
     *@Description:订单界面
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("orderList")
    @ApiOperation(value = "跳转到订单界面",httpMethod = "GET")
    public String goOrderList(){
        return "prorder/orderList";
    }

    /**
     *@Description:记录界面
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("recordList")
    @ApiOperation(value = "跳转到记录界面",httpMethod = "GET")
    public String goRecordList(){
        return "prrecord/recordList";
    }

    /**
     *@Description:建议界面
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("suggestList")
    @ApiOperation(value = "跳转到建议界面",httpMethod = "GET")
    public String goSuggestList(){
        return "prsuggest/suggestList";
    }

    /**
    *@Description: 跳转到顾客页面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("userList")
    @ApiOperation(value = "跳转到用户列表界面",httpMethod = "GET")
    public String goUserList(){
        return "pruser/userList";
    }
    
    /**
    *@Description: 跳转到用户个人信息页面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("userInfo")
    @ApiOperation(value = "跳转到用户信息界面",httpMethod = "GET")
    public String goUserInfo(){
        return "pruser/userInfo";
    }
    
    /**
    *@Description: 司机个人信息页面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("driverInfo")
    @ApiOperation(value = "跳转到司机信息界面",httpMethod = "GET")
    public String goDriverInfo(){
        return "prdriver/driverInfo";
    }
    
    /**
    *@Description: 管理员个人信息页面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/30
    */
    @RequestMapping("adminInfo")
    @ApiOperation(value = "跳转到管理员信息界面",httpMethod = "GET")
    public String goAdminInfo(){
        return "pradmin/adminInfo";
    }
}
