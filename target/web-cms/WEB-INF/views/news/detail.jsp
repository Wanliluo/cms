<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>
    <title>详情页</title>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
      <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/common.css">
  </head>  
  <body>
  <%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div class="newsHead">
        <h3>${article.title}</h3>
        <span>${article.lastModifiedTime1}</span><span>${article.author}</span>
    </div>
    <div class="newsContent">
       <p>${article.content}</p>
    </div>
  <%@ include file="/WEB-INF/layouts/footer.jsp"%>
  </body>  
</html>
