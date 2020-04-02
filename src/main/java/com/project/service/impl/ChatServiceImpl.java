package com.project.service.impl;

import com.project.mapper.ChatMapper;
import com.project.model.Chat;
import com.project.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Override
    public List<Chat> findAllChat(Chat chat) {
        return chatMapper.findAllChat(chat);
    }

    @Override
    public List<Chat> findAllChatByUser(Chat chat) {
        return chatMapper.findAllChatByUser(chat);
    }

    @Override
    public List<Chat> findAllChatCount(Chat chat) {
        return chatMapper.findAllChatCount(chat);
    }

    @Override
    public int insertChat(Chat chat) {
        return chatMapper.insertChat(chat);
    }
}
