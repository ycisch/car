package com.project.controller;

import com.project.model.Chat;
import com.project.model.User;
import com.project.service.ChatService;
import com.project.util.CreateVerifiCodeImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    ChatService chatService;

    /**
     * @description: 获取并显示验证码图片
     * @param: request
     * @param: response
     * @date: 2019-06-09 6:34 PM
     * @return: void
     */
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 验证码
        String verifiCode = String.valueOf(CreateVerifiCodeImage.getVerifiCode());
        // 将验证码图片输出到登录页面
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 存储验证码Session
        request.getSession().setAttribute("verifiCode", verifiCode);
    }

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
    public ModelAndView goChatList(HttpServletRequest request, ModelAndView model){

        //获取所有聊天信息与数量
        Chat chat = new Chat();
        User send = (User) request.getSession().getAttribute("userInfo");
        chat.setSend(send);
        List<Chat> chatList = chatService.findAllChat(chat);
        List<List<Chat>> chatList1 = new ArrayList<>();

        for (Chat chat1 : chatList) {
            chat.setReceive(chat1.getReceive());
            List<Chat> list = chatService.findAllChatByUser(chat);
            chatList1.add(list);
        }

        model.addObject("chatList",chatList);
        model.addObject("chatList1",chatList1);
        model.setViewName("prchat/chatList");
        return model;
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

    /**
     *@Description: 跳转到用户个人信息页面
     *@Param: []
     *@return: java.lang.String
     *@Author: Administrator
     *@date: 2020/3/30
     */
    @RequestMapping("userPosition")
    @ApiOperation(value = "跳转到用户选择地址",httpMethod = "GET")
    public String gouserPosition(){
        return "pruser/userPosition";
    }

    @RequestMapping("addDemandView")
    @ApiOperation(value = "跳转到需求添加地址",httpMethod = "GET")
    public String addDemandView(){
        return "prdemand/addDemand";
    }
}
