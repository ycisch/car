<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/1/2020
  Time: 11:38 AM
--%>
<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success</title>
    <link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="page-404 text-c">
    <p class="success-description">成功</p>
</div>
</body>

<script language="javascript">
    var i = 3;
    function clock(){
        i = i - 1;
        document.title="本窗口将在" + i + "秒后自动关闭!";
        if (i > 0) {
            setTimeout("clock();",1000);
        } else {
            self.close();
        }
    }
    clock();
</script>


</html>