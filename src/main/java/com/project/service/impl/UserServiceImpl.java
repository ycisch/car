package com.project.service.impl;

import com.project.mapper.UserMapper;
import com.project.model.LoginForm;
import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: truck
 * @description:
 * @author: Administrator
 * @create: 2020-03-07 12:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(LoginForm loginForm) {
        return userMapper.userLogin(loginForm);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> findAllUser(User user) {
        return userMapper.findAllUser(user);
    }

    @Override
    public int deleteUser(Integer[] ids) {
        return userMapper.deleteUser(ids);
    }
}
