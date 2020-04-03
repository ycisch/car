<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/10/2019
  Time: 5:23 PM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>智能拼车系统 | 系统主页面</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css"/>
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath}/static/easyui/js/outlook2.js'></script>

    <!-- 页面事件 -->
    <script type="text/javascript">
        //加载页面函数
        $(function () {
            //消息推送窗口
            $.messager.show({
                width: 360,
                height: 150,
                title: '推送',
                msg: '欢迎来到汽车管理系统！！',
                showSpeed: 1500,
                timeout: 0,
                showType: 'slide'
            });
        });
        //设置系统功能菜单栏
        var _menus = {
            "menus": [
                <c:if test="${userType==1 }">
                {
                    "menuid": "1", "icon": "", "menuname": "顾客信息管理",
                    "menus": [
                        {
                            "menuid": "21",
                            "menuname": "顾客列表",
                            "icon": "icon-student",
                            "url": "../sys/userList"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 1}">
                {
                    "menuid": "2", "icon": "", "menuname": "车主信息管理",
                    "menus": [
                        {
                            "menuid": "22",
                            "menuname": "车主列表",
                            "icon": "icon-teacher",
                            "url": "../sys/driverList"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 1}">
                {
                    "menuid": "3", "icon": "", "menuname": "需求信息查看",
                    "menus": [
                        {
                            "menuid": "23",
                            "menuname": "需求列表",
                            "icon": "icon-tip",
                            "url": "../sys/demandList"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 1}">
                {
                    "menuid": "4", "icon": "", "menuname": "管理员信息管理",
                    "menus": [
                        {
                            "menuid": "24",
                            "menuname": "修改个人信息",
                            "icon": "icon-edit",
                            "url": "../sys/adminList"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 2}">
                {
                    "menuid": "5", "icon": "", "menuname": "个人行程记录",
                    "menus": [
                        {
                            "menuid": "25",
                            "menuname": "记录列表",
                            "icon": "icon-settings",
                            "url": "../sys/recordList"
                        },
                        // {
                        //     "menuid": "26",
                        //     "menuname": "收藏列表",
                        //     "icon": "icon-settings",
                        //     "url": "../sys/choucanglist"
                        // },
                        {
                            "menuid": "27",
                            "menuname": "订单列表",
                            "icon": "icon-settings",
                            "url": "../sys/orderList"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 2}">
                {
                    "menuid": "6", "icon": "", "menuname": "出行服务",
                    "menus": [
                        {
                            "menuid": "28",
                            "menuname": "显示个人信息",
                            "icon": "icon-user",
                            "url": "../sys/userInfo"
                        },
                        {
                            "menuid": "29",
                            "menuname": "发布需求",
                            "icon": "icon-add",
                            "url": "../sys/addDemandView"
                        },
                        {
                            "menuid": "30",
                            "menuname": "查看附近车辆",
                            "icon": "icon-edit",
                            "url": "../sys/driverList"
                        },
                        {
                            "menuid": "31",
                            "menuname": "查看聊天信息",
                            "icon": "icon-user",
                            "url": "../sys/chatList"
                        },
                        // {
                        //     "menuid": "32",
                        //     "menuname": "平台打分",
                        //     "icon": "icon-settings",
                        //     "url": "../common/addScore"
                        // },
                        {
                            "menuid": "38",
                            "menuname": "顾客选择地址",
                            "icon": "icon-student",
                            "url": "../sys/userPosition"
                        }
                    ]
                },
                </c:if>
                <c:if test="${userType == 3}">
                {
                    "menuid": "7", "icon": "", "menuname": "出行服务",
                    "menus": [
                        {
                            "menuid": "33",
                            "menuname": "个人信息修改",
                            "icon": "icon-settings",
                            "url": "../info/goInfoView"
                        },
                        {
                            "menuid": "34",
                            "menuname": "查看出行记录",
                            "icon": "icon-settings",
                            "url": "../info/goInfoView1"
                        },
                        {
                            "menuid": "35",
                            "menuname": "查看留言",
                            "icon": "icon-settings",
                            "url": "../info/goInfoView1"
                        },
                        {
                            "menuid": "36",
                            "menuname": "查看个人信息",
                            "icon": "icon-settings",
                            "url": "../info/goInfoView1"
                        },
                        {
                            "menuid": "37",
                            "menuname": "平台打分",
                            "icon": "icon-settings",
                            "url": "../info/goInfoView1"
                        }
                    ]
                }
                </c:if>
            ]
        };

    </script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">

<!-- 页面顶部 -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 100px;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体,'Lucida Console',serif">
        <span style="float:right; padding-right:20px; padding-top: 50px"  class="head">
        	<span style="color:blue;" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true">
                <!-- 获取用户登录类型 -->
        		<c:choose>
                    <c:when test="${userType==1 }">管理员 : </c:when>
                    <c:when test="${userType==2 }">顾客 : </c:when>
                    <c:when test="${userType==2 }">车主 : </c:when>
                </c:choose>
        	</span>
            <%-- 从Session中获取登录用户的用户名	--%>
        	<span style="color:red; font-weight:bold;">
                <c:if test="${userType == 1}">${adminInfo.adminName}</c:if>
                <c:if test="${userType == 2}">${userInfo.userName}</c:if>
                <c:if test="${userType == 3}">${userInfo.userName}</c:if>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="loginOut" id="loginOut" style="color: darkgrey;" class="easyui-linkbutton"
               data-options="iconCls:'icon-exit',plain:true">
                [安全退出]
        	</a>
        </span>
    <h3 style="font-size:35px;font-weight: lighter; color: black; width: 550px; height: 60px; line-height: 60px; margin: 10px 0 0 30px; padding: 0;">
    Car Management System — SSM
    </h3>
</div>

<%--<!-- 页面底部-->--%>
<%--<div region="south" split="true" style="height: 30px;">--%>
    <%--<div class="footer">--%>
        <%--Copyright @ 2020 吃货智. All rights reserved--%>
    <%--</div>--%>
<%--</div>--%>

<!-- 导航菜单内容 -->
<div region="west" hide="true" split="true" title="[ 导航菜单 ]" style="width:180px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true">
        <!-- ······ -->
    </div>
</div>

<!-- 引入欢迎页面资源 -->
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs" fit="true">
        <jsp:include page="/WEB-INF/view/system/intro.jsp"/>
    </div>
</div>

</body>
</html>