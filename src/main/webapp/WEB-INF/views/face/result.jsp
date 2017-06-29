<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/4/7
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Stunning Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/base/reset.css" type="text/css" rel="stylesheet" />
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
    <!--fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,800italic,800,700italic,700,600,600italic' rel='stylesheet' type='text/css'>
    <!--/fonts-->
    <link href="http://localhost:8080/css/pages/test.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/css/pages/details.css" type="text/css" rel="stylesheet" />
    <!--script-->
    <script src="http://localhost:8080//js/common/jquery.min.js"> </script>
    <script src="http://localhost:8080/js/common/modernizr.custom.97074.js"></script>
    <!-- bootstrap-js -->
    <script src="http://localhost:8080/js/common/bootstrap.js"></script>
    <!-- bootstrap-js -->
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
    <script src="http://localhost:8080/js/common/jquery.chocolat.js"></script>
    <link rel="stylesheet" href="http://localhost:8080/css/common/chocolat.css" type="text/css" media="screen">
    <!--light-box-files -->
    <script type="text/javascript">
        $(function() {
            $('.gallery a').Chocolat();
        });
    </script>
</head>
<body>

<%@ include file="/WEB-INF/layouts/header.jsp"%>
<div class="page" style="width: 50%;">
    <div class="warpper" style="width: 100%;">
        <div class="histogram-container" id="histogram-container"></div>
        <div class="recommend">
            <h1>结果分析</h1>
            <c:if test = "${empty buf2}&&${empty buf3}">
                <p>您目前状态偏${buf1}</p>
            </c:if>
            <p>您目前状态偏${buf1}，${buf2}，${buf3}</p>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<script type="text/javascript">
    // 参数放到了jsp页面可以直接修改!
    $(function(){
        var dataArr={
            "data":[
                {"id":1,"name":"anger","per":"${faceRectangle.anger}"},
                {"id":2,"name":"contempt","per":"${faceRectangle.contempt}"},
                {"id":3,"name":"disgust","per":"${faceRectangle.disgust}"},
                {"id":4,"name":"fear","per":"2${faceRectangle.fear}"},
                {"id":5,"name":"happiness","per":"${faceRectangle.happiness}"},
                {"id":5,"name":"neutral","per":"${faceRectangle.neutral}"},
                {"id":5,"name":"sadness","per":"${faceRectangle.sadness}"},
                {"id":5,"name":"surprise","per":"${faceRectangle.surprise}"}
            ]
        };
        new histogram().init(dataArr.data);
    });
</script>
<script src="http://localhost:8080/js/pages/histogram.js" type="text/javascript"></script>
</body>
</html>