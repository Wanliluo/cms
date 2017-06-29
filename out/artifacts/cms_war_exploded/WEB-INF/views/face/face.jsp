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
    <title>摄像头</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Stunning Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/css/pages/test.css" rel="stylesheet" type="text/css"/>
    <!--fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,800italic,800,700italic,700,600,600italic' rel='stylesheet' type='text/css'>
    <!--/fonts-->
    <!--script-->
    <script src="http://localhost:8080/js/common/jquery.min.js"> </script>
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
    <style>
        video {
            border: 1px solid #ccc;
            display: block;
            margin: 0 0 20px 0;
            float:left;
        }
        #canvas {
            margin-top: 20px;
            border: 1px solid #ccc;
            display: block;
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/layouts/header.jsp"%>
<input type="hidden" name="personId" value="2" class="hidden">
<p></p>
<video id="video" width="500" height="400" autoplay></video>
<canvas id="canvas" width="500" height="400"></canvas>
<button id="snap" class="btn btn-info">拍照</button>
<script type="text/javascript">

    var hide = $(".hidden").val();
    var context = canvas.getContext("2d");
    //当DOM树构建完成的时候就会执行DOMContentLoaded事件
    window.addEventListener("DOMContentLoaded", function() {
        //获得Canvas对象
        var canvas = document.getElementById("canvas");
        //获得video摄像头区域
        var video = document.getElementById("video");
        var videoObj = {
            "video" : true
        };
        var errBack = function(error) {
            console.log("Video capture error: ", error.code);
        };
        //获得摄像头并显示到video区域
        if (navigator.getUserMedia) { // Standard
            navigator.getUserMedia(videoObj, function(stream) {
                video.src = stream;
                video.play();
            }, errBack);
        } else if (navigator.webkitGetUserMedia) { // WebKit-prefixed
            navigator.webkitGetUserMedia(videoObj, function(stream) {
                video.src = window.webkitURL.createObjectURL(stream);
                video.play();
            }, errBack);
        } else if (navigator.mozGetUserMedia) { // Firefox-prefixed
            navigator.mozGetUserMedia(videoObj, function(stream) {
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
    }, false);


    // 触发拍照动作
    document.getElementById("snap").addEventListener("click", function(canvas) {
        var image = new Image();
        image.src = document.getElementById("canvas").toDataURL("image/png");
        context.drawImage(video, 0, 0, 640, 480);
        $.ajax({
            url: 'http://localhost:8080/person/ajax/face',
            type: 'GET',
            data: {
                address: image.src,
                personId: hide
            },
            success: function (data) {
                console.log("成功了");
            }
        })
        // window.location = document.getElementById("canvas").toDataURL("image/png");
    });
</script>


<%@ include file="/WEB-INF/layouts/footer.jsp"%>

</body>
</html>

