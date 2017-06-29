<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/4/6
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--flexslider-css-->
    <!--bootstrap-->
    <link href="http://localhost:8080/css/common/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--coustom css-->
    <link href="http://localhost:8080/css/common/style.css" rel="stylesheet" type="text/css"/>
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
<input type="hidden" name="personId" value=${person.id}>
<div class="header" id="home">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>

    <div class="header-banner">
        <!-- Top Navigation -->
        <section class="bgi banner5"><h2>Personal</h2> </section>

        <!--about-starts-->
        <div class="about">
            <div class="container">
                <div class="about-top heading">
                    <h4>Personal Information</h4>
                    <div class="infomation">
                        <ul class="zhaopian">
                            <div class="photo">
                                <img src="http://localhost:8080/images/w32.jpg">
                            </div>
                        </ul>
                        <div class="info-right">
                            <div class="userName">
                                User Name:<span>${person.userName}</span>
                            </div>
                            <div class="birthday">
                                Birthday:<span>${person.birthday}</span>
                            </div>
                            <div class="sex">
                                Sex:<span>${person.sex}</span>
                            </div>
                            <div class="job">
                                Job:<span>${person.job}</span>
                            </div>
                            <div class="job-describe">
                                Job Description:<span>${person.jobDescribe}</span>
                            </div>
                            <div class="QQ">
                                QQ:<span>${person.qq}</span>
                            </div>
                            <div class="wechat">
                                WeChat:<span>${person.wechat}</span>
                            </div>
                            <div class="updata">
                                <a href="#">Change Info</a>
                            </div>
                        </div>
                    </div>
                    <h4>Recommending Items</h4>
                    <div class="about-bottom">

                        <table>
                            <thead>
                            <th>序号</th>
                            <th>anger</th>
                            <th>contempt</th>
                            <th>disgust</th>
                            <th>fear</th>
                            <th>happiness</th>
                            <th>neutral</th>
                            <th>sadness</th>
                            <th>surpise</th>
                            <th>推荐</th>
                            </thead>
                            <c:forEach var="face" items="${faceRectangleList}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${face.anger}</td>
                                    <td>${face.contempt}</td>
                                    <td>${face.disgust}</td>
                                    <td>${face.fear}</td>
                                    <td>${face.happiness}</td>
                                    <td>${face.neutral}</td>
                                    <td>${face.sadness}</td>
                                    <td>${face.surprise}</td>
                                    <td>
                                        <a href="http://localhost:8080/person/torecommend/${face.id}">查看</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--advantages-starts-->
        <div class="advantages">
            <div class="container">
                <div class="col-md-12 advantages-left heading">
                    <h3>Search Record</h3>
                    <div class="advn-one">
                        <div class="ad-mian">
                            <div class="ad-left">
                                <p>1</p>
                            </div>
                            <div class="ad-right">
                                <h4>抑郁症咨询</h4>
                                <p>问题详情：抑郁症又称抑郁障碍，以显著而持久的心境低落为主要临床特征，是心境障碍的主要类型。临床可见心境低落与其处境不相称，情绪的消沉可以从闷闷不乐到悲痛欲绝，自卑抑郁，甚至悲观厌世，可有自杀企图或行为；甚至发生木僵；部分病例有明显的焦虑和运动性激越；严重者可出现幻觉、妄想等精神病性症状。每次发作持续至少2周以上、长者甚或数年，多数病例有反复发作的倾向，每次发作大多数可以缓解，部分可有残留症状或转为慢性。</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="ad-mian">
                            <div class="ad-left">
                                <p>2</p>
                            </div>
                            <div class="ad-right">
                                <h4>其他心里问题</h4>
                                <p>问题详情：抑郁症又称抑郁障碍，以显著而持久的心境低落为主要临床特征，是心境障碍的主要类型。临床可见心境低落与其处境不相称，情绪的消沉可以从闷闷不乐到悲痛欲绝，自卑抑郁，甚至悲观厌世，可有自杀企图或行为；甚至发生木僵；部分病例有明显的焦虑和运动性激越；严重者可出现幻觉、妄想等精神病性症状。每次发作持续至少2周以上、长者甚或数年，多数病例有反复发作的倾向，每次发作大多数可以缓解，部分可有残留症状或转为慢性。 </p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="ad-mian">
                            <div class="ad-left">
                                <p>3</p>
                            </div>
                            <div class="ad-right">
                                <h4>抑郁症查询</h4>
                                <p>问题详情：抑郁症又称抑郁障碍，以显著而持久的心境低落为主要临床特征，是心境障碍的主要类型。临床可见心境低落与其处境不相称，情绪的消沉可以从闷闷不乐到悲痛欲绝，自卑抑郁，甚至悲观厌世，可有自杀企图或行为；甚至发生木僵；部分病例有明显的焦虑和运动性激越；严重者可出现幻觉、妄想等精神病性症状。每次发作持续至少2周以上、长者甚或数年，多数病例有反复发作的倾向，每次发作大多数可以缓解，部分可有残留症状或转为慢性。</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="team">
            <div class="container">
                <div class="team-top heading">
                    <h3>Psychological Expert</h3>
                </div>
                <div class="team-bottom">
                    <ul class="ch-grid">
                        <li>
                            <div class="ch-item ch-img-1">
                                <div class="ch-info-wrap">
                                    <div class="ch-info">
                                        <div class="ch-info-front ch-img-1"></div>
                                        <div class="ch-info-back">
                                            <h3>石勒志</h3>
                                            <p>主治：抑郁症,情绪不稳定</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="ch-item ch-img-2">
                                <div class="ch-info-wrap">
                                    <div class="ch-info">
                                        <div class="ch-info-front ch-img-2"></div>
                                        <div class="ch-info-back">
                                            <h3>辛德勒</h3>
                                            <p>主治：感情问题</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="ch-item ch-img-3">
                                <div class="ch-info-wrap">
                                    <div class="ch-info">
                                        <div class="ch-info-front ch-img-3"></div>
                                        <div class="ch-info-back">
                                            <h3>王医生</h3>
                                            <p>主治：家庭矛盾</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="ch-item ch-img-1">
                                <div class="ch-info-wrap">
                                    <div class="ch-info">
                                        <div class="ch-info-front ch-img-1"></div>
                                        <div class="ch-info-back">
                                            <h3>张医生</h3>
                                            <p>主治：各种极端情绪</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
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
</body>
</html>
