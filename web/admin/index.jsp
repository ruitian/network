<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lib.Model.User" %>
<%@ page import="lib.Dao.AdminDao" %>
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
<c:if test="${currentUser.role == 2}">
    <h3></h3>
    <div class="container">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">用户管理</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">个人资料</a></li>
                <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
                <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
                <li role="presentation"><a href="../index.jsp">返回首页</a></li>

            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <% AdminDao adminDao = new AdminDao();%>
                    <%=adminDao.getUser()%>
                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                    当前用户是${currentUser.username} 权限为${currentUser.role}
                </div>
                <div role="tabpanel" class="tab-pane" id="messages">...</div>
                <div role="tabpanel" class="tab-pane" id="settings">...</div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${currentUser.role == 0}">
    <% response.sendRedirect("../customer/index.jsp");%>
</c:if>
<c:if test="${currentUser.role == 1}">
    <% response.sendRedirect("../company/index.jsp");%>
</c:if>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">更改用户资料</h4>
            </div>
            <div class="modal-body">
                <form action="edit" method="post">
                    <input type="hidden" name="dataid" id="dataid" value=""/>
                    <div class="form-group">
                        <label for="username" class="control-label">用户名</label>
                        <input type="text" name="username" class="form-control" id="username">
                    </div>
                    <div class="form-group">
                        <label for="phone" class="control-label">手机</label>
                        <input name="phone" class="form-control" id="phone">
                    </div>
                    <div class="form-group">
                        <label for="password"  class="control-label">密码</label>
                        <input name="password" class="form-control" id="password">
                    </div>
                    <div class="form-group">
                        <label for="role" class="control-label">角色</label>
                        <select class="form-control" name="role" id="role">
                            <option value="0">普通会员</option>
                            <option value="1">公司会员</option>
                            <option value="2">管理员</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
function getDataid(e) {
    //console.log(e.target.parentNode.parentNode.getAttribute('data_id'));
    var username = e.target.parentNode.parentNode.childNodes.item(0).getAttribute("username");
    var phone = e.target.parentNode.parentNode.childNodes.item(1).getAttribute("phone");
    var password = e.target.parentNode.parentNode.childNodes.item(2).getAttribute("password");
    var role = e.target.parentNode.parentNode.childNodes.item(3).getAttribute("role");

    var dataid = e.target.parentNode.parentNode.getAttribute('data_id');

    document.getElementById("dataid").value = dataid;
    document.getElementById("username").value = username;
    document.getElementById("phone").value = phone;
    document.getElementById("password").value = password;
    document.getElementById("role").value = role;

}
var el = document.getElementById("outside");
el.addEventListener("click", getDataid.bind(this), false);
</script>

<%--删除用户的ajax--%>
<script>
    var dataid = null;
    function deleteData(e) {
        dataid = e.target.parentNode.parentNode.getAttribute('data_id');
    }
    var el = document.getElementById("outside");
el.addEventListener("click", deleteData.bind(this), false);
</script>
<%--end--%>
</body>
</html>
