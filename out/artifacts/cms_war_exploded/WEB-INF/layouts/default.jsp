<%--
  Created by IntelliJ IDEA.
  User: 秦
  Date: 2016/12/22
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<c:set var="ctx" value="${pageContext.request.contextPath}" />--%>

<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/reset.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/common.css">
    <sitemesh:head/>
</head>

<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
<sitemesh:body/>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
</body>
</html>
