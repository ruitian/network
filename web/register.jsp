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
    <div class="row">
        <div class="col-md-12">
            <div class="logo col-md-2 col-md-offset-1" >
                <a href="index.jsp"><img src="static/image/logo.png" width="170px" height="75px" alt=""/></a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="reg_main col-md-8 col-md-offset-2">
            <div class="reg_form">
                <form action="register" class="form-group" method="post">
                    <div>
                        <span>用户名:</span>
                        <div class="reg_out">
                            <p class="member_icon3"></p>
                            <input type="text" id="username" name="username" placeholder="用户名" require=""/>
                        </div>
                        <p id="name-mess"></p>
                    </div>
                    <div>
                        <span>手机:</span>
                        <div class="reg_out">
                            <p class="member_icon4"></p>
                            <input type="text" id="phone" name="phone" placeholder="手机号" require=""/>
                        </div>
                        <p id="phone-mess"></p>
                    </div>
                    <div>
                        <span>密码:</span>
                        <div class="reg_out">
                            <p class="member_icon5"></p>
                            <input type="password" id="password" name="password" placeholder="密码" require=""/>
                        </div>
                    </div>
                    <div>
                        <span>确认密码:</span>
                        <div class="reg_out">
                            <p class="member_icon6"></p>
                            <input type="password" id="password2" name="password1" placeholder="确认密码" require="" onkeyup="validate()"/>
                        </div>
                        <p id="message" style="color:red;"></p>
                    </div>
                    <div>
                        <span></span>
                        <button type="submit" id="btn" class="btn col-md-6 col-md-offset-2" disabled="true"  onclick="check()">注册</button>
                    </div>
                </form>
            </div>
            <div class="reg_login">
                <h1>已有登陆账号?</h1>
                <p><a href="login.jsp">立即登陆>>></a></p>
            </div>
        </div>
    </div>
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
