package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.CalculateDistance;
import com.project.model.Admin;
import com.project.model.Driver;
import com.project.model.LoginForm;
import com.project.model.User;
import com.project.service.AdminService;
import com.project.service.DriverService;
import com.project.service.UserService;
import com.project.util.CreateVerifiCodeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: truck
 * @description: 用户服务
 * @author: Administrator
 * @create: 2020-03-07 12:46
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    DriverService driverService;

    //存储返回给页面的对象数据
    private Map<String, Object> result = new HashMap<>();

    @RequestMapping("goUserView")
    public String goUserView(){
        return "truckUser/userList";
    }


    @PostMapping("login")
    @ResponseBody
    public Map<String, Object> login(LoginForm loginForm, HttpServletRequest request) {

        // 校验验证码信息
        String vcode = (String) request.getSession().getAttribute("verifiCode");
        if ("".equals(vcode)) {
            result.put("success", false);
            result.put("msg", "长时间为操作,会话已失效,请刷新页面后重试!");
            return result;
        } else if (!loginForm.getVerifiCode().equalsIgnoreCase(vcode)) {
            result.put("success", false);
            result.put("msg", "验证码错误!");
            return result;
        }
        request.getSession().removeAttribute("verifiCode");

        //效验用户登录信息
        try {

            int type = loginForm.getUserType();
            if(type == 1){

                Admin admin = new Admin();
                admin.setAdminName(loginForm.getUsername());
                admin.setAdminPassword(loginForm.getPassword());
                admin = adminService.adminLogin(admin);
                if (admin != null) {
                    HttpSession session = request.getSession(); //将用户信息存储到Session
                    session.setAttribute("adminInfo", admin);
                    session.setAttribute("userType", loginForm.getUserType());
                    result.put("success", true);
                    return result;
                }
            }else if(type == 2){
                User user = userService.userLogin(loginForm);//验证账户和密码是否存在
                if (user != null) {
                    HttpSession session = request.getSession(); //将用户信息存储到Session
                    session.setAttribute("userInfo", user);
                    session.setAttribute("userType", loginForm.getUserType());
                    result.put("success", true);
                    return result;
                }
            }else{
                Driver driver = driverService.driverLogin(loginForm);
                if (driver != null) {
                    HttpSession session = request.getSession(); //将用户信息存储到Session
                    session.setAttribute("userInfo", driver);
                    session.setAttribute("userType", loginForm.getUserType());
                    result.put("success", true);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "登录失败! 服务器端发生异常!");
            return result;
        }
        //登录失败
        result.put("success", false);
        result.put("msg", "用户名或密码错误!");
        return result;
    }

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
    *@Description: 调到系统登陆界面
    *@Param: []
    *@return: java.lang.String
    *@Author: Administrator
    *@date: 2020/3/9
    */
    @RequestMapping("goSystemMainView")
    public String goSystemMainView(){
        return "system/main";
    }

    /**
     * @description: 注销用户信息
     * @param: request
     * @date: 2019-06-11 6:40 PM
     * @return: void
     */
    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("userType");

        //注销后重定向到登录页面
        try {
            response.sendRedirect("../index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Description: 添加用户
     *@Param: [user]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/8
     */
    @ResponseBody
    @RequestMapping("addUser")
    public Map<String, Object> addUser(User user) {

        if(userService.addUser(user) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }




    @RequestMapping("addPosition")
    public String addPosition(String lng, String lat,String site,HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("userInfo");
        user.setUserPosition(lng+","+lat);
        user.setCoordinate(site);
        request.setAttribute("userInfo",user);
        Driver driver = new Driver();
        List<Driver> list = driverService.findAllDriver(driver);
        CalculateDistance calculateDistance = new CalculateDistance();
        for (int i = 0;i<list.size();i++){
            Driver driver1 = list.get(i);
            double distance = calculateDistance.getDistance(user, driver1);
            driver1.setDistance((float)distance);
            driverService.updateDriver(driver1);
        }


        return "common/success";
    }


    @ResponseBody
    @RequestMapping("editUser")
    public Map<String, Object> updateUser(User user,HttpServletRequest request) {

        user.setUserName(user.getUserFirstName()+user.getUserLastName());

        if(userService.updateUser(user) > 0){
            result.put("success", true);
            User user1 = (User) request.getSession().getAttribute("userInfo");
            user1.setUserFirstName(user.getUserFirstName());
            user1.setUserLastName(user.getUserLastName());
            user1.setUserName(user.getUserName());
            user1.setUserSex(user.getUserSex());
            user1.setUserPhone(user.getUserPhone());
            user1.setUserPassword(user.getUserPassword());
            request.getSession().setAttribute("userInfo",user1);
        }else{
            result.put("success", false);
            result.put("msg", "修改失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 删除用户
     *@Param: [ids]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/8
     */
    @ResponseBody
    @RequestMapping("deleteUser")
    public Map<String, Object> deleteUser(@RequestParam(value = "ids[]") Integer[] ids) {

        if(userService.deleteUser(ids) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "删除失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 查看所有用户信息
     *@Param: [page, rows, order]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/9
     */
    @ResponseBody
    @RequestMapping("findAllUser")
    public Map<String, Object> findAllUser(Integer page, Integer rows,User user) {

        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //查询订单信息
        List<User> userList = userService.findAllUser(user);
        //封装信息列表
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<User> noticeList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", userList);
        return result;
    }
}
