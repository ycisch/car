package com.project.service;

import com.project.model.Chat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface ChatService {

    /**
     *@Description: 查找聊天信息 可以根据聊天时间与用户名称去查找
     *@Param: [chat]
     *@return: java.util.List<com.project.model.Chat>
     *@Author: Administrator
     *@date: 2020/3/29
     */
    List<Chat> findAllChat(Chat chat);

    /**
     *@Description: 根据聊天用户与被聊天者去查询聊天信息
     *@Param: [chat]
     *@return: java.util.List<com.project.model.Chat>
     *@Author: Administrator
     *@date: 2020/3/29
     */
    List<Chat> findAllChatByUser(Chat chat);

    /**
     *@Description: 查找所有聊天信息的数量 类似于微信右上角小红标
     *@Param: [chat]
     *@return: java.util.List<com.project.model.Chat>
     *@Author: Administrator
     *@date: 2020/3/29
     */
    List<Chat> findAllChatCount(Chat chat);

    /**
     *@Description: 提交聊天信息
     *@Param: [chat]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertChat(Chat chat);

}
