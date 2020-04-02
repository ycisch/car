package com.project.service.impl;

import com.project.mapper.MessageMapper;
import com.project.model.Message;
import com.project.service.MessageService;
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
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper ;

    @Override
    public List<Message> findAllMessage(Message message) {
        return messageMapper.findAllMessage(message);
    }

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateMessage(message);
    }

    @Override
    public int deleteMessage(Integer[] ids) {
        return messageMapper.deleteMessage(ids);
    }
}
