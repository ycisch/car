package com.project.service;

import com.project.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface MessageService {
    /**
     *@Description: 查看司机的留言信息 可以使用时间进行模糊查找(范围)  要根据时间去排序 并且可以对司机和客户单独去查找
     *@Param: [message]
     *@return: java.util.List<com.project.model.Message>
     *@Author: Administrator
     *@date: 2020/3/30
     */
    List<Message> findAllMessage(Message message);

    /**
     *@Description: 添加留言信息
     *@Param: [message]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertMessage(Message message);

    /**
     *@Description: 修改留言信息
     *@Param: [message]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int updateMessage(Message message);

    /**
     *@Description: 删除留言信息
     *@Param: [ids]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int deleteMessage(Integer[] ids);
}
