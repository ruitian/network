<%--
  Created by IntelliJ IDEA.
  User: baron
  Date: 15-9-11
  Time: 上午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register|网上招聘</title>
    <link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css"/>
    <script src="static/js/juqery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form class="col-md-6 col-md-offset-3" action="register" method="post">
    <div class="form-group">
      <label for="exampleInputName2">Name</label>
      <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail2">Phone Number</label>
      <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Phone Number">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail2">Password</label>
      <input type="password" class="form-control" id="exampleInputEmail2" placeholder="Password">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail2">Varify Password</label>
      <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-default">注册</button>
  </form>
</div>
</body>
</html>
