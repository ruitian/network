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
    <title>后台管理</title>
    <link href="../static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="../static/css/style.css"/>
    <link rel="stylesheet" href="../static/css/flat-ui.min.css"/>
    <script src="../static/js/juqery.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
</head>
<body>
<%
  User currentUser = (User)session.getAttribute("currentUser");
  if(currentUser == null) {
    response.sendRedirect("../login.jsp");
    return;
  }
%>
<h3></h3>
<div class="container">
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人资料</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">用户管理</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
            <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                当前用户是${currentUser.username} 权限为${currentUser.level}
            </div>
            <div role="tabpanel" class="tab-pane" id="profile"></div>
            <div role="tabpanel" class="tab-pane" id="messages">...</div>
            <div role="tabpanel" class="tab-pane" id="settings">...</div>
        </div>
    </div>
</div>
</body>
</html>
