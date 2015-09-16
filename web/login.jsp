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
      <div class="col-md-12 head">
        <div class="logo col-md-2 col-md-offset-1">
          <a href="index.jsp"><img src="static/image/logo.png" width="170px" height="75px" alt=""/></a>
        </div>
      </div>
      <div class="row">
        <div class="jumbotron col-md-6">
          <h1 align="center">Welcome your coming</h1>
          <p>在这里寻找想要的它,分享拥有的它</p>
        </div>
        <div class="well col-md-4 col-md-offset-1">
          <div class="login_title">登陆网上招聘</div>
          <form action="login" class="form-horizontal" method="post">
            <div class="login_out">
              <p class="member_icon1"></p>
              <input type='text' id='phone' name='phone' placeholder='手机号'/>
            </div>
            <div class="login_out">
              <p class="member_icon2"></p>
              <input type="password" id="password" name="password" placeholder="密码" required=""/>
            </div>
            <div class="clearfix">
              <span class="fl"><label><input type="checkbox" name="remember" value="remember_me"/>记住我</label></span>
              <span class="fr"><label><a href="#">忘记密码</a></label></span>
            </div>
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
            <p class="form-actions">
              <button class="btn btn-primary btn-block" type="submit">登录</button>
            </p>
            <div class=" login_bottom" >
              <div class="container">
                <p>
                  马上注册,即将寻找你需要的它!
                  <a href="register.jsp">马上注册>>></a>
                </p>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
