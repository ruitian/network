<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lib.Model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: baron
  Date: 15-9-14
  Time: 下午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
    response.sendRedirect("../login.jsp");
    return;
  }
%>
<c:if test="${currentUser.level == 1}"><h3>当前用户是${currentUser.username} 权限为${currentUser.level}</h3></c:if>
<c:if test="${currentUser.level == 0}">
    <% response.sendRedirect("../customer/index.jsp");%>
</c:if>
<c:if test="${currentUser.level == 2}">
    <% response.sendRedirect("../admin/index.jsp");%>
</c:if>
</body>
</html>
