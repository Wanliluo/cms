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
    <title>登录</title>
    <meta charset="utf-8">
    <script type="application/x-javascript"> addEventListener("load", function() { 	setTimeout	(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0	,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080//css/common/style.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080//css/pages/login.css" rel="stylesheet" type="text/css"/>
    <!--fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic		,800italic,800,700italic,700,600,600italic' rel='stylesheet' type='text/css'>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
<div class="header-banner">
    <!-- Top Navigation -->
    <div class="container page-seperator">
        <section class="color bgi">
            <div class="container">
                <div class="banneer-text">
                    <h3>Natural redirects here.</h3>
                    <h4>See Nature disambiguation !</h4>
                    <button type="button" class="btn btn-warning but1">Exceptional</button>
                    <p>Lorem ipsum simply a dummy text to format fonts and 	paragraphs,consectetuer adipiscing elit, sed diam </p>
                </div>
                <div class="banner-forms">

                    <form action="http://localhost:8080/person/login" method="get">
                        <a href="javascript:;" class="account pitch">账号登录</a>
                        <label>账号：</label>
                        <input type="text" class="name" name="useName" required="required" />
                        <label>密码：</label>
                        <input class="nuber" type="password" name="password"  required="required" />
                        <div id="v_container" style="width: 200px;height: 50px;"></div>
                        <input type="text" id="code_input" class="name" value="" placeholder="请输入验证码"/>
                        <button type="submit" id="my_button" class="btn btn-info mrgn-can">登录</button>
                        <p>${msg}</p>
                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </section>
    </div>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
<!--script-->
<script src="http://localhost:8080//js/pages/jquery.min.js"> </script>
<script src="http://localhost:8080//js/base/jquery-1.8.3.min.js"> </script>
<script src="http://localhost:8080//js/pages/login.js"> </script>
<!-- js -->
<script src="http://localhost:8080//js/pages/bootstrap.js"></script>
<!-- js -->
<!-- js -->
<script type="text/javascript" src="http://localhost:8080//js/pages/move-top.js"></script>
<script type="text/javascript" src="http://localhost:8080//js/pages/easing.js"></script>
<script src="http://localhost:8080//js/pages/gVerify.js"></script>
<script>
    var verifyCode = new GVerify("v_container");

    document.getElementById("my_button").onclick = function(){
        var res = verifyCode.validate(document.getElementById("code_input").value);
        if(res){

        }else{
            alert("验证码错误");
            return false;
        }
    }
</script>
<!--/script-->
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},900);
        });
    });
</script>
<!--/script-->
</body>
</html>
