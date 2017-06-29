<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/4/6
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>首页</title>
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/css/pages/login.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
   <div style=" height: 400px; width:auto;background:url(http://localhost:8080/images/us48-jwi3935.jpg) no-repeat 10px center">

   </div>
    <div class="updata" style="position: fixed; top:40px;right:45px;font-size: 1em">
        <a href="http://localhost:8080/person/tologin">登录</a>
    </div>
<div class="updata" style="position: fixed; top:40px;right:80px;font-size: 1em">
    <a href="http://localhost:8080/person/toregister">注册</a>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
</body>
</html>
