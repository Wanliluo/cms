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
    <title>注册</title>
    <meta charset="utf-8">
    <script type="application/x-javascript"> addEventListener("load", function() {  setTimeout  (hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0    ,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/css/pages/register.css" rel="stylesheet" type="text/css"/>
    <!--fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic       ,800italic,800,700italic,700,600,600italic' rel='stylesheet' type='text/css'>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
<div class="header-banner">
    <!-- Top Navigation -->
    <div class="container page-seperator">
        <section class="color bgi">
            <div class="container">
                <div class="banner-forms" id="banner-forms">

                    <form action="http://localhost:8080/person/register" id="form" class="block" method="GET">
                        <h3>注册信息</h3>
                        <div>
                            <label>注册账号：</label>
                            <input type="text" class="username name" name="userName"  />
                        </div>

                        <div>
                            <label>注册密码：</label>
                            <input class="nuber psw1" type="password" name="password" />
                        </div>

                        <div>
                            <label>确认密码：</label>
                            <input class="nuber psw2" type="password" name="psw2" />
                        </div>

                        <div>
                            <label>电话：</label>
                            <input class="nuber phone1" type="text" name="phone" />
                        </div>

                        <div>
                            <label>单位：</label>
                            <input class="nuber company" type="text" name="company"  required="required"/>
                        </div>

                        <div>
                            <label>家庭住址或单位地址：</label>
                            <input class="nuber address" type="text" name="address"  required="required"/>
                        </div>

                        <div>
                            <label>微信：</label>
                            <input class="nuber wechat" type="text" name="wechat"  required="required"/>
                        </div>

                        <div>
                            <label>QQ：</label>
                            <input class="nuber qq" type="text" name="qq"   />
                        </div>

                        <div>
                            <label>生日：</label><span>例如：1997-01-01</span>
                            <input class="nuber birthday" type="text" name="birthday"  />
                        </div>


                        <label>性别：</label>
                        <br>
                        <span class="sexname">男</span><input type="radio" name="sex" class="sex" checked="checked">
                        <span class="sexname">女</span><input type="radio" name="sex" class="sex">

                        <div>
                            <label>职业</label>
                            <input class="nuber job" type="text" name="job"  required="required" />
                        </div>

                        <div>
                            <label>职业描述</label>
                            <input class="nuber job_describe" type="text" name="job_describe" required="required" />
                        </div>

                        <div id="v_container" style="width: 200px;height: 50px;"></div>
                        <input type="text" id="code_input" class="name" value="" placeholder="请输入验证码"/>

                        <button type="submit" id="my_button" class="btn btn-info mrgn-can">注册</button>

                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </section>
    </div>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
<!--script-->
<script src="http://localhost:8080/js/pages/jquery.min.js"> </script>
<script src="http://localhost:8080/js/base/jquery-1.8.3.min.js"> </script>
<script src="http://localhost:8080/js/pages/login.js"> </script>
<!-- js -->
<script src="http://localhost:8080/js/pages/bootstrap.js"></script>
<!-- js -->
<!-- js -->
<script type="text/javascript" src="http://localhost:8080/js/pages/move-top.js"></script>
<script type="text/javascript" src="http://localhost:8080/js/pages/easing.js"></script>
<script src="http://localhost:8080/js/pages/gVerify.js"></script>
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
    $(document).ready(function() {
        $("form input").blur(function() {
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            // 用户名验证
            if ($(this).is('.username')) {
                var name=$(".username").val();
                reg=/^([\u4e00-\u9fa5]){2,7}$/;
                if (!reg.test(name)) {
                    var errorMsg = "请输入正确至少2位的用户名";
                    $parent.append("<div class='wrongname formtips'>" + errorMsg + "</div>");
                    $('.wrongname').css('color', '#F8143D');
                }
                else{
                    var rightMsg = "输入正确";
                    $parent.append("<div class='rightname formtips'>" + rightMsg + "</div>");
                    $('.rightname').css('color', '#10F65A');
                }
            }
            // 密码验证
            if ($(this).is('.psw1')) {
                var pasw = $(".psw1").val();
                reg= /^[0-9A-Za-z]{6,}$/;
                if (!reg.test(pasw)) {
                    var errorMsg = "请输入且6位以上的密码";
                    $parent.append("<div class='wrongname formtips'>" + errorMsg + "</div>");
                    $('.wrongname').css('color', '#F8143D');
                }
                else{
                    var rightMsg = "输入正确";
                    $parent.append("<div class='rightname formtips'>" + rightMsg + "</div>");
                    $('.rightname').css('color', '#10F65A');
                }
            }

            //验证手机
            if ($(this).is('.phone1')) {
                var phone = $(".phone1").val()
                reg=/^((\(\d{2,3}\))|(\d{3}\-))?1[3,8,5]{1}\d{9}$/;
                if(!reg.test(phone) ) {
                    var errorMsg = "您输入的不是大陆手机号！";
                    $parent.append("<div class='wrongname formtips'>" + errorMsg + "</div>");
                    $('.wrongname').css('color', '#F8143D');
                }
                else{
                    var rightMsg = "输入正确";
                    $parent.append("<div class='rightname formtips'>" + rightMsg + "</div>");
                    $('.rightname').css('color', '#10F65A');
                }
            }
            // 验证生日
            if ($(this).is('.birthday')) {
                var birthday = $(".birthday").val()
                reg=/^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
                if(!reg.test(birthday) ) {
                    var errorMsg = "您输入的不是正确生日格式";
                    $parent.append("<div class='wrongname formtips'>" + errorMsg + "</div>");
                    $('.wrongname').css('color', '#F8143D');
                }
                else{
                    var rightMsg = "输入正确";
                    $parent.append("<div class='rightname formtips'>" + rightMsg + "</div>");
                    $('.rightname').css('color', '#10F65A');
                }
            }


        });
        $('#my_button').click(function(){
            $("form :input.need").trigger('blur');
            var numError = $('form .wrongname').length;
            if(numError){
                alert("注册失败.");
                return false;
            }
            alert("注册成功.");
        });
    });
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
