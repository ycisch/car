package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Message;
import com.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: Message
 * @author: Administrator
 * @create: 2020-03-31 21:13
 */
@RequestMapping("Message")
@Controller
public class MessageController {
    private Map<String , Object > result = new HashMap<>();

    @Autowired
    private MessageService messageService;


    /**
     *@Description: 跳转需求页面显示页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @ResponseBody
    @RequestMapping("goMessageList")
    public ModelAndView goMessageList(ModelAndView modelAndView){
        modelAndView.setViewName("message/goMessageList");
        return modelAndView;
    }


    /**
     *@Description: 添加留言
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("insertMessage")
    @ResponseBody
    public Map<String , Object > insertMessage(Message message){
        if(messageService.insertMessage(message) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 删除留言
     *@Param: [ids]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("deleteMessage")
    @ResponseBody
    public Map<String,Object> deleteMessage(@RequestParam(value = "ids[]", required = true) Integer[] ids){

        if(messageService.deleteMessage(ids) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "删除失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 修改留言
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/7
     */
    @RequestMapping("editMessage")
    @ResponseBody
    public Map<String,Object>updateMessage(Message message){
        if(messageService.updateMessage(message) > 0){
            result.put("success", true);
        }
        else {
            result.put("success", false);
            result.put("msg", "修改失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 查询留言
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("getMessageList")
    @ResponseBody
    public Map<String,Object>findAllMessage(Integer page, Integer rows,Message message){
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //查询公告信息
        List<Message> list = messageService.findAllMessage(message);
        //封装信息列表
        PageInfo<Message> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Message> messageList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", messageList);
        return result;
    }

}
