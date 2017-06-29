<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/4/6
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div class="updata">
        <a href="http://localhost:8080/person/tologin">登录</a>
    </div>
<div class="updata">
    <a href="http://localhost:8080/person/toregister">注册</a>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
</body>
</html>
