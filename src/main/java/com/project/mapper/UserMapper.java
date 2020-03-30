package com.project.mapper;

import com.project.model.LoginForm;
import com.project.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: ssm
 * @description: 用户/管理员
 * @author: Administrator
 * @create: 2020-03-07 11:05
 */
@Mapper
public interface UserMapper {

    /**
    *@Description: 用户登录 根据类别进行判断
    *@Param: [user]
    *@return: com.project.model.User
    *@Author: Administrator
    *@date: 2020/3/8
    */
    User userLogin(LoginForm loginForm);

    /**
    *@Description: 添加企业信息
    *@Param: [user]
    *@return: int
    *@Author: Administrator
    *@date: 2020/3/8
    */
    int addUser(User user);

    /**
    *@Description: 修改企业信息
    *@Param: [user]
    *@return: int
    *@Author: Administrator
    *@date: 2020/3/8
    */
    int updateUser(User user);

    /**
    *@Description: 查找所有用户
    *@Param: [user]
    *@return: java.util.List<com.project.model.User>
    *@Author: Administrator
    *@date: 2020/3/9
    */
    List<User> findAllUser(User user);

    /**
    *@Description: 删除用户
    *@Param: [ids]
    *@return: int
    *@Author: Administrator
    *@date: 2020/3/9
    */
    int deleteUser(Integer[] ids);

}
