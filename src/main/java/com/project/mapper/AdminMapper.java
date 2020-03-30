package com.project.mapper;

import com.project.model.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: car
 * @description: 管理员Mapper
 * @author: Administrator
 * @create: 2020-03-29 23:18
 */
@Mapper
public interface AdminMapper {

    /**
    *@Description: 查看管理员信息
    *@Param: [admin]
    *@return: com.project.model.Admin
    *@Author: Administrator
    *@date: 2020/3/29
    */
    Admin findAdminInfo(Admin admin);

    /**
    *@Description: 修改管理员信息
    *@Param: [admin]
    *@return: int
    *@Author: Administrator
    *@date: 2020/3/29
    */
    int updateAdmin(Admin admin);

    /**
    *@Description: 管理员登陆
    *@Param: [admin]
    *@return: int
    *@Author: Administrator
    *@date: 2020/3/29
    */
    Admin adminLogin(Admin admin);
}
