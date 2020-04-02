<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fuwenben/themes/default/default.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fuwenben/plugins/code/prettify.css" />
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/static/fuwenben/kindeditor-all.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/static/fuwenben/lang/zh-CN.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/static/fuwenben/plugins/code/prettify.js"></script>

    <script type="text/javascript">
        KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="demandContent"]', {
                cssPath : '${pageContext.request.contextPath}/static/fuwenben/plugins/code/prettify.css',
                uploadJson : '../upload/fileUpload',
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                },
                afterBlur: function(){this.sync();}
            });
            prettyPrint();
        });
    </script>
    <script type="text/javascript">
        var url = "../demand/addDemand";
        var userId = 1;

        function saveShuju(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(result){
                }
            });
        }


    </script>
</head>
<body style="margin: 5px;">

<form id="fm" method="post">
    <table cellspacing="5px;">
        <%--<tr>--%>
            <%--<td>名称：</td>--%>
            <%--<td><input type="text" name="shujuName" id="shujuName" class="easyui-validatebox"/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>地点：</td>--%>
            <%--<td><input type="text" name="shujuMark1" id="shujuMark1" class="easyui-validatebox"/></td>--%>
            <%--<td>说明：</td>--%>
            <%--<td><input type="text" name="shujuMark2" id="shujuMark2" class="easyui-validatebox"/></td>--%>
        <%--</tr>--%>
        <tr>
            <td colspan="4"><textarea name="demandContent" id="shujuMark" cols="100" rows="12" style="width:700px;height:250px;visibility:hidden;"></textarea></td>
        </tr>
    </table>
</form>

<div id="dlg-buttons">
    <a href="javascript:saveShuju()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeShujuDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>