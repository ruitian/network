<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lib.Model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: baron
  Date: 15-9-16
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申请|网上招聘</title>
    <link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css"/>
    <link rel="stylesheet" href="static/css/flat-ui.min.css"/>
    <script src="static/js/juqery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>

<%
    User currentUser = (User)session.getAttribute("currentUser");
    if(currentUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<c:if test="${currentUser.role == 4}">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <%
          if (currentUser != null) { %>
          <li><a href="#">你好${currentUser.username}</a></li>
        <% } %>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    <div class="container">
        <h4>${currentUser.username}您好,您现在处于游客模式,要想体验更多的功能,请申请新的角色</h4>

        <form class="col-md-4 form-group" action="apply" method="post">
            <input type="hidden" name="dataid" id="dataid" value="${currentUser.dataid}"/>

            <input class="form-control" type="hidden" name="username" id="username" value="${currentUser.username}"/>

            <label class="control-label">想申请的角色</label>
            <select class="form-control" name="role" id="role">
                <option value="0">应聘者</option>
                <option value="1">公司管理者</option>
            </select>

            <label class="control-label">申请理由</label>
            <textarea class="form-control" name="reason" id="reason" cols="30" rows="10"></textarea>

            <button class="btn btn-primary" type="submit">点击申请</button>
        </form>
    </div>
</c:if>

<c:if test="${currentUser.role == 0}">
    <% response.sendRedirect("customer/index.jsp");%>
</c:if>
<c:if test="${currentUser.role == 1}">
    <% response.sendRedirect("company/index.jsp");%>
</c:if>
<c:if test="${currentUser.role == 2}">
    <% response.sendRedirect("admin/index.jsp");%>
</c:if>
</body>
</html>