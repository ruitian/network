<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lib.Model.User" %>
<%@ page import="lib.Dao.CompanyDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>首页|网上招聘系统</title>
    <link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css"/>
    <link rel="stylesheet" href="static/css/flat-ui.min.css"/>
    <script src="static/js/juqery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>
<%--<%--%>
  <%--if (session.getAttribute("currentUser") == null) {--%>
    <%--response.sendRedirect("login.jsp");--%>
    <%--session.setAttribute("error", "error");--%>
    <%--return;--%>
  <%--}--%>
<%--%>--%>
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
            <a class="navbar-brand" href="#">Brand</a>
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
                <% User currentUser = (User)session.getAttribute("currentUser");
                    if (currentUser != null) { %>

                <c:if test="${currentUser.role == 0}">
                    <li><a href="customer/index.jsp">欢迎${currentUser.username}</a></li>
                </c:if>
                <c:if test="${currentUser.role == 1}">
                    <li><a href="company/index.jsp">欢迎${currentUser.username}</a></li>
                </c:if>
                <c:if test="${currentUser.role == 2}">
                    <li><a href="admin/index.jsp">欢迎${currentUser.username}</a></li>
                </c:if>

                <li><a href="logout.jsp">注销</a></li>
                <% } %>
                <%
                    if (currentUser == null) {
                %>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.jsp">登陆</a></li>
                        <li><a href="register.jsp">注册</a></li>
                    </ul>
                </li>
                <% } %>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

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
<% CompanyDao companyDao = new CompanyDao();%>
<h2>
    <%=companyDao.companylist()%>
</h2>

</body>
</html>
