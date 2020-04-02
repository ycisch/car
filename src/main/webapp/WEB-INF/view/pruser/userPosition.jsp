<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/2
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <!-- 将百度地图API引入，设置好自己的key -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HMY85O77GTGIrGd1KMGsC6nUh5gUdyNB"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/addPosition" method="post">
    地址：<input id="site" style="width: 500px" /><br>
    经度：<input id="longitude" name="lng" /><br>
    纬度：<input id="latitude" name="lat" /><br>
    <input type="submit" value="提交">
</form>
<div id='allmap' style='width: 60%; height: 60%; position: absolute; '></div>
</body>
</html>

<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
    map.enableScrollWheelZoom(true);
    var geoc = new BMap.Geocoder();

    map.addEventListener("click", function(e){
        //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
        var pt = e.point;
        geoc.getLocation(pt, function(rs){
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;
            var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
            //将对应的HTML元素设置值
            $("#site").val(site);
            $("#longitude").val(pt.lng);
            $("#latitude").val(pt.lat);
        });
    });
</script>
