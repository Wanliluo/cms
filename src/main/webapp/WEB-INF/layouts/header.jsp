<%--
  Created by IntelliJ IDEA.
  User: 秦
  Date: 2016/12/22
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>common header</title>
    <meta charset="utf-8">
</head>
<body>
<div class="header" id="home">
    <nav class="navbar navbar-default">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><h1>Welcome</h1><br /><span>The friend of heart</span></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right margin-top cl-effect-2">
                    <li><a href="http://localhost:8080/person/toindex"><span data-hover="Home">首页</span></a></li>
                    <li><a href="http://localhost:8080/person/toface/1"><span data-hover="Test">测评</span></a></li>
                    <li><a href="http://localhost:8080/person/topersonal/1"><span data-hover="Personal ">个人中心</span></a></li>
                </ul>
                <div class="clearfix"></div>
            </div><!-- /.navbar-collapse -->
            <div class="clearfix"></div>
        </div><!-- /container-fluid -->
    </nav>
</div>
</body>
</html>

