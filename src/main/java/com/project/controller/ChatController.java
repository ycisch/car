package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Chat;
import com.project.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: 聊天控制层
 * @author: Administrator
 * @create: 2020-03-31 17:02
 */
@Api("聊天控制层")
@Controller
@RequestMapping("chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    //返回前端JSON数据
    Map<String,Object> result = new HashMap<>();

    @ApiOperation(value = "查找聊天信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="chat",value = "聊天信息",paramType = "query"),
            @ApiImplicitParam(name="page",value = "页数",paramType = "query"),
            @ApiImplicitParam(name="rows",value = "行数",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAllChat")
    public Map<String, Object> findAllChat(Integer page,Integer rows,Chat chat) {

        //设置每页的记录数
        PageHelper.startPage(page,rows);
        //查询聊天信息
        List<Chat> list = chatService.findAllChat(chat);
        //封装信息列表
        PageInfo<Chat> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Chat> chatList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", chatList);

        return result;
    }

    @ApiOperation(value = "根据用户去查找聊天信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="chat",value = "聊天信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAllChatByUser")
    public Map<String, Object> findAllChatByUser(Chat chat) {
        List<Chat> chatList = chatService.findAllChatByUser(chat);
        result.put("rows", chatList);
        return result;
    }


    @ApiOperation(value = "查找数量用来实时显示",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="chat",value = "聊天信息",paramType = "query")
    })
    @ResponseBody
    @RequestMapping("findAllChatCount")
    public Map<String, Object> findAllChatCount(Chat chat) {

        List<Chat> chatList = chatService.findAllChatCount(chat);
        result.put("rows", chatList);
        return result;
    }
}
