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

            // $.ajax({
            //     type: 'POST',
            //     dataType : 'json',
            //     url: url,
            //     data: param,
            //     success: function(json){
            //         ajaxLoadEnd();
            //         createAll(json.Data);
            //     }
            // });

            $("#editDialog").dialog("open");//打开添加窗口


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

            //设置编辑司机信息窗口
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
                                    url: "editDriver",
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            //关闭窗口
                                            $("#editDialog").dialog("close");
                                            //重新刷新页面数据
                                            $('#editDialog').datagrid("reload");
                                            $('#editDialog').datagrid("uncheckAll");
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
                            $("#edit_driverFirstName").textbox('setValue', "");
                            $("#edit_driverLastName").textbox('setValue', "");
                            $("#edit_driverSex").textbox('setValue', "");
                            $("#edit_driverPhone").textbox('setValue', "");
                            $("#edit_driverPassword").textbox('setValue', "");
                            $("#edit_driverCardid").textbox('setValue', "");
                         }
                    }
                ]
            });


        });


    </script>
</head>
<body>


<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <form id="editForm" method="post" action="${pageContext.request.contextPath}/driver/editDriver">
        <input type="hidden" id="edit_id" name="driverId" value="${userInfo.driverId}"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>姓：</td>
                <td colspan="1">
                    <input value="${userInfo.driverFirstName}" id="edit_driverFirstName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverFirstName" data-options="required:true, missingMessage:'请填写姓~'"/>
                </td>
            </tr>
            <tr>
                <td>名：</td>
                <td>
                    <input value="${userInfo.driverLastName}" id="edit_driverLastName" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverLastName" data-options="required:true, missingMessage:'请填写名~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td colspan="1">
                    <select id="edit_driverSex" class="easyui-combobox"
                            data-options="editable: false, panelHeight: 50, width: 60, height: 30,
                                required:true, missingMessage:'请选择状性别哟~'" name="driverSex">
                        <option value="男" <c:if test="${userInfo.driverSex == '男'}">selected</c:if> >男</option>
                        <option value="女" <c:if test="${userInfo.driverSex == '女'}">selected</c:if> >女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="1">
                    <input value="${userInfo.driverPhone}" id="edit_driverPhone" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverPhone" data-options="required:true, missingMessage:'请填写电话哟~'"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input value="${userInfo.driverPassword}" id="edit_driverPassword" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverPassword" data-options="required:true, missingMessage:'请填写密码哟~'"/>
                </td>
            </tr>
            <tr>
                <td>牌照</td>
                <td colspan="1">
                    <input value="${userInfo.driverCardid}" id="edit_driverCardid" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverPassword" data-options="required:true, missingMessage:'请填写牌照哟~'"/>
                </td>
            </tr>
            <tr>
                <td>类型</td>
                <td colspan="1">
                    <input value="${userInfo.carType}" id="edit_carType" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverPassword" data-options="required:true, missingMessage:'请填写类型哟~'"/>
                </td>
            </tr>
            <tr>
                <td>颜色</td>
                <td colspan="1">
                    <input value="${userInfo.carColor}" id="edit_carColor" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="driverPassword" data-options="required:true, missingMessage:'请填写颜色哟~'"/>
                </td>
            </tr>

            <tr>
                <td colspan="1">
                    <input value="修改" type="submit"/>
                </td>
            </tr>
        </table>
    </form>
</div>

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