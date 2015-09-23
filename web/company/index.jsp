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
    <title>${currentUser.username}|个人中心</title>
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
<c:if test="${currentUser.role == 1}">
    <div class="container">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">添加公司信息</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">个人资料</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
            <li role="presentation"><a href="../index.jsp"sss>返回首页</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <div class="modal-body">
                    <form class="col-md-6" action="companyinfo" method="post">
                        <input type="hidden" value="${currentUser.dataid}" name="dataid"/>
                        <div class="form-group">
                            <label for="comname" class="control-label">公司名称</label>
                            <input type="text" name="comname" class="form-control" id="comname">
                        </div>
                        <div class="form-group">
                            <label for="comdesc" class="control-label">公司简介</label>
                            <textarea name="comdesc" id="comdesc" cols="30" rows="10"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </form>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">
                <table class="table table-hover">
                    <tr><td>用户名:</td><td>${currentUser.username}</td></tr>
                    <tr><td>密码:</td><td>${currentUser.password}</td></tr>
                    <tr><td>用户角色:</td><td>应聘者</td></tr>
                </table>
                <%
                    String message = (String)request.getAttribute("message");
                    if(message != null) {
                %>
                <div class="alert alert-messages alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${message}
                </div>
                <% } %>

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">点击编辑我的资料</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="exampleModalLabel">我的资料</h4>
                            </div>
                            <div class="modal-body">
                                <form action="../modifyprofile" method="post">
                                    <input type="hidden" name="dataid" value="${currentUser.dataid}"/>
                                    <input type="hidden" name="phone" value="${currentUser.phone}"/>
                                    <div class="form-group">
                                        <label for="recipient-name" class="control-label">用户名</label>
                                        <input type="text" class="form-control" name="username" id="recipient-name" value="${currentUser.username}">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="control-label">密码</label>
                                        <input class="form-control" id="message-text" name="password" type="password" value="${currentUser.password}">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                        <button type="submit" class="btn btn-primary">更新</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="messages">...</div>
        </div>

    </div>
</c:if>
<c:if test="${currentUser.role == 0}">
    <% response.sendRedirect("../customer/index.jsp");%>
</c:if>
<c:if test="${currentUser.role == 2}">
    <% response.sendRedirect("../admin/index.jsp");%>
</c:if>
</body>
</html>
