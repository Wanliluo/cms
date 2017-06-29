<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>一体化软件工程实践-新闻列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/reset.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/list.css">
    <link rel="stylesheet" href="http://localhost:8080/css/pagination.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="http://localhost:8080/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://localhost:8080/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="http://localhost:8080/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="http://localhost:8080/js/list.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div class="container clearfix">
        <div class="sidebar">
            <h3>栏目列表</h3>
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <div class="content">
            <div class="tab">
                <span class="listTab current">文章列表</span>
                <span class="addTab">文章添加</span>
            </div>
            <div class="articleList">
	            <div class="search-box">
	                <span>栏目：</span>
	                <select  name="categoryId">
	                    <option value="">请选择</option>
	                    <c:forEach var="item" items="${categoryList}">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
	                </select>
	                <span>标题：</span>
	                <input type="text" name="title"/>
	                <input id="search" type="button" value="查询"/>
	                <span>状态：</span>
	                <input name="state" type="radio" id="publish" value="0" />
	                <label for="publish">发布</label>
	                <input name="state" type="radio" id="check" value="1" />
	                <label for="check">审核</label>
	                <input name="state" type="radio" id="delete" value="2" />
	                <label for="delete">删除</label>
	            </div>
                <input type="hidden" id="count" value="0"/>
	            <table>
	                <thead>
	                    <tr>
	                        <th>栏目</th>
	                        <th>标题</th>
	                        <th>权重</th>
	                        <th>点击数</th>
	                        <th>发布者</th>
	                        <th>更新时间</th>
	                        <th>操作</th>
	                    </tr>
	                </thead>
	                <tbody id="resText">
	                </tbody>
	            </table>
	            <div class="pageBox"><div id="Pagination" class="pagination"><!-- 这里显示分页 --></div></div>
            </div>
            <div class="articleAdd none">
                <form name="addForm" action="http://localhost:8080/article/add">
                    <div>
                        <span>栏目：</span>
                        <select  name="categoryId">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${categoryList}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <span>标题：</span>
                        <input name="title" type="text"/>
                    </div>
                    <div>
                        <span>内容：</span>
                        <textarea name="content" rows="11" cols="100"></textarea>
                    </div>
                    <div>
                        <input class="sub" type="submit" value="确认添加"/>
                    </div>
                </form>
            </div>
            <div class="articleAlter none">
                <form name="alterForm" action="http://localhost:8080/article/update">
                    <input type="hidden" name="articleId" value="id">
                    <div>
                        <span>栏目：</span>
                        <select  name="categoryId">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${categoryList}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <span>标题：</span>
                        <input name="title" type="text"/>
                    </div>
                    <div>
                        <span>内容：</span>
                        <textarea name="content" rows="11" cols="100"></textarea>
                    </div>
                    <div>
                        <input class="sub" type="submit" value="确认修改"/>
                    </div>
                </form>
            </div>
        </div>
        
    </div>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
</body>
</html>
