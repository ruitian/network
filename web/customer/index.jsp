<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baron
  Date: 15-9-14
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="lib.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
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
  <c:if test="${currentUser.role == 0}">
    <div class="container">
      <div>
          <!-- Nav tabs -->
          <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人资料</a></li>
              <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">我的简历</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
              <li role="presentation"><a href="../index.jsp">返回首页</a></li>

          </ul>

          <!-- Tab panes -->
          <div class="tab-content">
              <div role="tabpanel" class="tab-pane active col-md-6" id="home">
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
              <div role="tabpanel" class="tab-pane" id="messages">
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1">编写我的简历</button>
                  <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2">查看修改简历</button>
                  <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                      <div class="modal-dialog" role="document">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                  <h4 class="modal-title" id="exampleModalLabel">My Resume</h4>
                              </div>
                              <div class="modal-body">
                                  <form action="resume" method="post">
                                      <input type="hidden" name="dataid" value="${currentUser.dataid}"/>
                                      <div class="form-group">
                                          <label for="message-text" class="control-label">简历内容:</label>
                                          <textarea class="form-control" id="message-text" rows="20" name="resume"></textarea>
                                      </div>
                                      <div class="modal-footer">
                                          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                          <button type="submit" class="btn btn-primary">保存</button>
                                      </div>
                                  </form>
                              </div>
                          </div>
                      </div>
                  </div>
                  <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                      <div class="modal-dialog" role="document">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                  <h4 class="modal-title" id="exampleModalLabel">My Resume</h4>
                              </div>
                              <div class="modal-body">
                                  <form action="customer/resume" method="post">
                                      <input type="hidden" name="dataid" value="${currentUser.dataid}"/>
                                      <div class="form-group">
                                          <label for="message-text" class="control-label">简历内容:</label>
                                          <textarea class="form-control" id="message-text" rows="20" name="resume">${resume.resume}</textarea>
                                      </div>
                                      <div class="modal-footer">
                                          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                          <button type="submit" class="btn btn-primary">保存修改</button>
                                      </div>
                                  </form>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <div role="tabpanel" class="tab-pane" id="settings">...</div>
          </div>
      </div>
    </div>
  </c:if>



  <c:if test="${currentUser.role == 1}">
      <% response.sendRedirect("../company/index.jsp");%>
  </c:if>
  <c:if test="${currentUser.role == 2}">
      <% response.sendRedirect("../admin/index.jsp");%>
  </c:if>
</body>
</html>
