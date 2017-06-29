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
    <title>修改个人资料</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/pages/updata.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/pages/personal.css">
    <!--fonts-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,800italic,800,700italic,700,600,600italic" rel="stylesheet" type="text/css">
    <!--/fonts-->
    <!--script-->
    <script src="http://localhost:8080/js/common/jquery.min.js"> </script>
    <!-- js -->
    <script src="http://localhost:8080/js/common/bootstrap.js"></script>
    <script type="text/javascript" src="http://localhost:8080/js/common/move-top.js"></script>
    <script type="text/javascript" src="http://localhost:8080/js/common/easing.js"></script>
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
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/common/common.css" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/common/style4.css" />
</head>
<body>
<div class="header" id="home">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>

    <div class="header-banner">
        <!-- Top Navigation -->
        <section class="bgi banner5"><h2>Personal Updata</h2> </section>

        <!--about-starts-->
        <div class="about">
            <div class="container">
                <div class="about-top heading">
                    <h4>Personal Information</h4>
                    <div class="infomation">
                        <ul class="zhaopian">
                            <div class="photo">
                                <img src="http://localhost:8080/img/w32.jpg">
                            </div>
                        </ul>
                        <form class="info-right">
                            <div>
                                <label>User Name:</label>
                                <input type="text" name="user-name" class="user-name" value="">
                            </div>
                            <div>
                                <label>birthday:</label>
                                <input type="text" name="birthday" class="birthday" value="">
                            </div>
                            <div class="sex">
                                <label>Sex:</label>
                                <input type="text" name="sex" class="sex" value="">
                            </div>
                            <div class="job">
                                <label>Job:</label>
                                <input type="text" name="job" class="job" value="">
                            </div>
                            <div class="job-describe">
                                <label>Job Description:</label>
                                <textarea></textarea>
                            </div>
                            <div class="QQ">
                                <label>QQ:</label>
                                <input type="text" name="QQ" class="QQ" value="">
                            </div>
                            <div class="wechat">
                                <label>WeChat:</label>
                                <input type="text" name="wechat" class="wechat" value="">
                            </div>
                            <div class="updata">
                                <input type="submit" name="sub" value="Send">
                            </div>

                        </form>

                    </div>


                    <!--team-end-->
                    <!--about-end-->
                </div>
            </div>
            <!--footer-starts-->
            <%@ include file="/WEB-INF/layouts/footer.jsp"%>
            <!---->
            <script type="text/javascript">
                $(document).ready(function() {

                    var defaults = {
                        containerID: 'toTop', // fading element id
                        containerHoverID: 'toTopHover', // fading element hover id
                        scrollSpeed: 1200,
                        easingType: 'linear'
                    };

                    $().UItoTop({ easingType: 'easeOutQuart' });
                });
            </script>
            <a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
            <!---->
        </div>
    </div>
</div>
</body>
</html>

