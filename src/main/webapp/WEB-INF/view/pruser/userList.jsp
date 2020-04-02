<%--
  Created by IntelliJ IDEA.
  Date: 6/16/2019
  Time: 8:11 AM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" content="#">
    <title>汽车管理页面</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/css/demo.css">
    <link href="${pageContext.request.contextPath}/static/h-ui/css/foundation-datepicker.css" rel="stylesheet"
          type="text/css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/easyui/js/validateExtends.js"></script>
    <script src="${pageContext.request.contextPath}/static/h-ui/js/foundation-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/static/h-ui/js/locales/foundation-datepicker.zh-CN.js"></script>

    <script type="text/javascript">
        //DOM加载完成后执行的回调函数
        $(function () {
            var table;

            //初始化datagrid
            $('#dataList').datagrid({
                iconCls: 'icon-edit',//图标
                border: true,
                collapsible: false,//是否可折叠
                fit: true,//自动大小
                height: 300,
                method: "post",
                url: "../user/findAllUser",
                idField: 'userId',
                singleSelect: false,//是否单选
                rownumbers: true,//行号
                pagination: true,//分页控件
                sortName: 'userId',
                sortOrder: 'DESC',
                remoteSort: false,
                columns: [[
                    {field: 'chk', checkbox: true, width: 50},
                    {
                        field: 'userId', title: 'ID', width: 50, sortable: true,
                        sorter: function (a, b) {
                            return (a > b ? -1 : 1)
                        }
                    },
                    {field: 'userFirstName', title: '名称', width: 150,hidden:true},
                    {field: 'userLastName', title: '名称', width: 150,hidden:true},
                    {field: 'userName', title: '名称', width: 150},
                    {field: 'userSex', title: '性别', width: 150},
                    {field: 'userPhone', title: '电话 ', width: 150},
                    {field: 'userPosition', title: '所在位置', width: 150}
                ]],
                toolbar: "#toolbar"//工具栏
            });

            //设置分页控件
            var p1 = $('#dataList').datagrid('getPager');
            $(p1).pagination({
                pageSize: 10,//设置每页显示的记录条数,默认为10
                pageList: [10, 20, 30, 50, 100],//设置每页记录的条数
                beforePageText: '第',
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            });

            //信息添加按钮事件
            $("#add").click(function () {
                table = $("#addTable");
                $("#addTable").form("clear");//清空表单数据
                $("#addDialog").dialog("open");//打开添加窗口
            });

            //信息修改按钮事件
            $("#edit").click(function () {
                table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择想要修改的数据哟!", "warning");
                } else {
                    $("#editDialog").dialog("open");
                }
            });

            //信息删除按钮事件
            $("#delete").click(function () {
                var selectRows = $("#dataList").datagrid("getSelections");//返回所有选中的行,当没有选中的记录时,将返回空数组
                var selectLength = selectRows.length;
                if (selectLength === 0) {
                    $.messager.alert("消息提醒", "请选择想要删除的数据哟!", "warning");
                } else {
                    var ids = [];
                    $(selectRows).each(function (i, row) {
                        ids[i] = row.carId;//将预删除行的id存储到数组中
                    });
                    $.messager.confirm("消息提醒", "删除后将无法恢复该客户信息! 确定继续?", function (r) {
                        if (r) {
                            $.ajax({
                                type: "post",
                                url: "../user/deleteUser",
                                data: {ids: ids},
                                dataType: 'json',
                                success: function (data) {
                                    if (data.success) {
                                        $.messager.alert("消息提醒", "删除成功啦!", "info");
                                        $("#dataList").datagrid("reload");//刷新表格
                                        $("#dataList").datagrid("uncheckAll");//取消勾选当前页所有的行
                                    } else {
                                        $.messager.alert("消息提醒", "服务器端发生异常! 删除失败!", "warning");
                                    }
                                }
                            });
                        }
                    });
                }
            });

            //设置添加汽车信息窗口
            $("#addDialog").dialog({
                title: "添加汽车信息窗口",
                width: 660,
                height: 500,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            var validate = $("#addForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#addForm").serialize();//序列化表单信息
                                $.ajax({
                                    type: "post",
                                    url: "../user/addUser",
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            $("#addDialog").dialog("close"); //关闭窗口
                                            $('#dataList').datagrid("reload");//重新刷新页面数据
                                            $.messager.alert("消息提醒", "添加成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#add_userFirstName").textbox('setValue', "");
                            $("#add_userLastName").textbox('setValue', "");
                            $("#add_userSex").textbox('setValue', "");
                            $("#add_userPhone").textbox('setValue', "");
                            $("#add_userPassword").textbox('setValue', "");
                        }
                    }
                ]
            });

            //设置编辑汽车信息窗口
            $("#editDialog").dialog({
                title: "修改汽车信息窗口",
                width: 660,
                height: 500,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '提交',
                        plain: true,
                        iconCls: 'icon-edit',
                        handler: function () {
                            var validate = $("#editForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#editForm").serialize();//序列化表单信息
                                debugger;
                                $.ajax({
                                    type: "post",
                                    url: "../user/editUser",
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            //关闭窗口
                                            $("#editDialog").dialog("close");
                                            //重新刷新页面数据
                                            $('#dataList').datagrid("reload");
                                            $('#dataList').datagrid("uncheckAll");
                                            //用户提示
                                            $.messager.alert("消息提醒", "修改成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#edit_userFirstName").textbox('setValue', "");
                            $("#edit_userLastName").textbox('setValue', "");
                            $("#edit_userSex").textbox('setValue', "");
                            $("#edit_userPhone").textbox('setValue', "");
                            $("#edit_userPassword").textbox('setValue', "");
                        }
                    }
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    $("#edit_id").val(selectRow.userId);//初始化id值,需根据id更新汽车信息
                    $("#edit_userFirstName").textbox('setValue', selectRow.userFirstName);
                    $("#edit_userLastName").textbox('setValue', selectRow.userLastName);
                    $("#edit_userSex").textbox('setValue', selectRow.userSex);
                    $("#edit_userPhone").textbox('setValue', selectRow.userPhone);
                    $("#edit_userPassword").textbox('setValue', selectRow.userPassword);
                }
            });

            //业主与班级名搜索按钮的监听事件(将其值返回给Controller)
            $("#search-btn").click(function () {
                $('#dataList').datagrid('load', {
                    userName: $('#search-userName').val(),//获取顾客名称
                });
            });

            //添加信息窗口中上传头像的按钮事件
            $("#add-upload-btn").click(function () {
                if ($("#choose-portrait").filebox("getValue") === '') {
                    $.messager.alert("提示", "请选择图片!", "warning");
                    return;
                }
                $("#add-uploadForm").submit();//提交表单

            });

            //修改信息窗口中上传头像的按钮事件
            $("#edit-upload-btn").click(function () {
                if ($("#edit-choose-portrait").filebox("getValue") === '') {
                    $.messager.alert("提示", "请选择图片!", "warning");
                    return;
                }
                $("#edit-uploadForm").submit();

            });

        });

        //上传头像按钮事件
        function uploaded() {
            var data = $(window.frames["photo_target"].document).find("body pre").text();
            data = JSON.parse(data);//将data装换为JSON对象
            if (data.success) {
                $.messager.alert("提示", "图片上传成功!", "info");
                //切换头像
                $("#add-portrait").attr("src", data.portrait_path);
                $("#edit-portrait").attr("src", data.portrait_path);
                //将头像路径存储到信息表单中(利用从用户信息中读取头像路径来显示头像)
                $("#add_portrait_path").val(data.portrait_path);
                $("#edit_portrait-path").val(data.portrait_path);
            } else {
                $.messager.alert("提示", data.msg, "warning");
            }
        }

    </script>
</head>
<body>

<!-- 顾客列表信息 -->
<table id="dataList" cellspacing="0" cellpadding="0"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="float: left;"><a id="add" href="javascript:" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <%-- 通过JSTL设置用户操作权限: 将修改和删除按钮设置为仅管理员可见	 --%>
    <c:if test="${userType==1 || userType== 3 }">
        <div style="float: left;"><a id="edit" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-edit',plain:true">修改</a></div>
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <div style="float: left;"><a id="delete" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-some-delete',plain:true">删除</a></div>
    </c:if>

    <div style="margin-left: 10px;">
        <div style="float: left;" class="datagrid-btn-separator"></div>

        <a href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-user-student',plain:true">顾客名称</a>
        <input id="search-userName" class="easyui-textbox" name="userName"/>
        <!-- 搜索按钮 -->
        <a id="search-btn" href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>
</div>

<!-- 添加信息窗口 -->
<div id="addDialog" style="padding: 15px 0 0 55px;">
    <form id="addForm" method="post" action="#">
        <table id="addTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <!-- 存储所上传的头像路径 -->
            <tr>
                <td>姓：</td>
                <td colspan="1">
                    <input id="add_userFirstName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userFirstName" data-options="required:true, missingMessage:'请填写姓~'"/>
                </td>
            </tr>
            <tr>
                <td>名：</td>
                <td>
                    <input id="add_userLastName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userLastName" data-options="required:true, missingMessage:'请填写名~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td colspan="1">
                    <select id="add_userSex" class="easyui-combobox"
                            data-options="editable: false, panelHeight: 50, width: 60, height: 30,
                                required:true, missingMessage:'请选择状态哟~'" name="userSex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="1">
                    <input id="add_userPhone" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userPhone" data-options="required:true, missingMessage:'请填写电话哟~'"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input id="add_userPassword" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userPassword" data-options="required:true, missingMessage:'请填写密码哟~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <form id="editForm" method="post" action="#">
        <input type="hidden" id="edit_id" name="userId"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>姓：</td>
                <td colspan="1">
                    <input id="edit_userFirstName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userFirstName" data-options="required:true, missingMessage:'请填写姓~'"/>
                </td>
            </tr>
            <tr>
                <td>名：</td>
                <td>
                    <input id="edit_userLastName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userLastName" data-options="required:true, missingMessage:'请填写名~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td colspan="1">
                    <select id="edit_userSex" class="easyui-combobox"
                            data-options="editable: false, panelHeight: 50, width: 60, height: 30,
                                required:true, missingMessage:'请选择状态哟~'" name="userSex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="1">
                    <input id="edit_userPhone" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userPhone" data-options="required:true, missingMessage:'请填写电话哟~'"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input id="edit_userPassword" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="userPassword" data-options="required:true, missingMessage:'请填写密码哟~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- 表单处理 -->
<%----%>
<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>
<script>
    $('#demo-1').fdatepicker();
    $('#demo-2').fdatepicker({
        format: 'yyyy-mm-dd',
        pickTime: true
    });
    $('#demo-3').fdatepicker();

    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
    var checkin = $('#dpd1').fdatepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.update(newDate);
        }
        checkin.hide();
        $('#dpd2')[0].focus();
    }).data('datepicker');
    var checkout = $('#dpd2').fdatepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
    }).data('datepicker');
</script>

</body>
</html>