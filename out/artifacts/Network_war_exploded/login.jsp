<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css"/>
    <script src="static/js/juqery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container">
      <%
        String error = (String)request.getAttribute("error");
        if(error != null) {
      %>
      <div class="alert alert-messages alert-success alert-dismissible" role="alert" >
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        ${error}
      </div>
      <% } %>
      <div class="row">
        <h1 class="col-md-4 col-md-offset-4">网上招聘登陆</h1>
      </div>
      <div class="row">
        <form class="col-md-6 col-md-offset-3" action="login" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Phone Number</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Phone" name="phone" value="${phone}">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value="${passwords}">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
      </div>
    </div>
  </body>
</html>
