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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>精美js聊天窗口界面代码</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/chat/css/reset.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/chat/css/style.css">

</head>
<body>
<div class="wrapper">
    <div class="container">
        <div class="left">
            <div class="top">
                <input type="text" placeholder="搜索"/>
                <a href="javascript:;" class="search"></a>
            </div>
            <ul class="people">
                <c:forEach items="${chatList}" var="chatList" varStatus="status">
                    <li class="person" data-chat="person${status.index+1}">
                        <img src="${pageContext.request.contextPath}/static/chat/imgs/thomas${status.index%3}.jpg"
                             alt=""/>
                        <input type="hidden" value="${chatList.receive.userId}" class="userId">
                        <span class="name">${chatList.receive.userName}</span>
                            <%--<span class="time">--%>
                            <%--<fmt:formatDate value="${chatList.chatTime}" pattern="yyyy年MM月dd日" />--%>
                            <%--</span>--%>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="right">
            <div class="top"><span>To: <span class="name">在东北玩泥巴</span></span>
                <input type="hidden" id="receiveId" class="receiveId"></div>
            <c:forEach items="${chatList1}" var="chatList1" varStatus="status">
                <div class="chat" data-chat="person${status.index+1}">
                    <c:forEach items="${chatList1}" var="list">
                        <c:choose>
                            <c:when test="${userInfo.userId == list.send.userId}">
                                <div class="bubble me">
                                        ${list.chatContent}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="bubble you">
                                        ${list.chatContent}
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </c:forEach>
            <div class="write">

                <form action="${pageContext.request.contextPath}/chat/insertChat" method="post" id="search_form">
                    <a href="javascript:;" class="write-link attach"></a>
                    <input type="text" name="chatContent">
                    <input type="hidden" name="receiveIds" class="receiveIds"/>
                    <a href="javascript:;" class="write-link smiley"></a>
                    <a onclick="document:search_form.submit();" class="write-link send"></a>
                </form>

                <%--<input type="text"/>--%>
                <%--<--%>
                <%--<a onclick="addChat()" class="write-link send"></a>--%>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/chat/js/index.js"></script>

<!--这行代码可以去掉-->
<a href="http://www.bootstrapmb.com" style="display:none">bootstrapmb</a>

</body>
</html>
