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
    <%
        String error_name = (String)request.getAttribute("error_name");
        String error_phone = (String)request.getAttribute("error_phone");
    %>
  <form class="col-md-6 col-md-offset-3" action="register" method="post">
    <div class="form-group">
      <label>姓名</label>
      <input type="text" class="form-control" id="username" placeholder="Jane Doe" name="username">
        <p>${error_name}</p>
        <p id="name-mess"></p>
    </div>
    <div class="form-group">
      <label>手机号码</label>
      <input type="text" class="form-control" id="phone" placeholder="Phone Number" name="phone">
        <p>${error_phone}</p>
        <p id="phone-mess"></p>
    </div>
    <div class="form-group">
      <label>密码</label>
      <input type="password" class="form-control" id="password" placeholder="Password" name="password">
    </div>
    <div class="form-group">
      <label>确认密码</label>
      <input type="password" class="form-control" id="password2" placeholder="Password" name="password1" onkeyup="validate()">
    </div>
      <p id="message" style="color:red;"></p>
    <button type="submit" id="btn" class="btn btn-primary" disabled="true" onclick="check()">注册</button>
  </form>
</div>

<script>
  function validate() {
    var passwd1 = document.getElementById("password").value;
    var passwd2 = document.getElementById("password2").value;
    if(passwd1 != passwd2) {
        document.getElementById("message").innerHTML = "两次输入密码不一致";
    }
      else {
        document.getElementById("message").innerHTML = "";
    }
      if (passwd1 == passwd2) {
          document.getElementById("btn").disabled=false;
      }
  }
    function check() {
        var name = document.getElementById("username").value;
        var phone = document.getElementById("phone").value;
        if (name == null) {
            document.getElementById("name-mess").innerHTML = "请输入姓名";
        }
        if (phone == null) {
            document.getElementById("phone-mess").innerHTML = "请输入手机号";
        }
        if (phone.length != 11) {
            document.getElementById("phone-mess").innerHTML = "手机号是11位!"
        }
    }
</script>
</body>
</html>
