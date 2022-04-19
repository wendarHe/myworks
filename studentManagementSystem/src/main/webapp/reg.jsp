<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="initial.css">
    <link rel="stylesheet" href="s3.css">
</head>
<body>
<div class="container">
    <div class="d1">欢迎注册</div>
    <form action="/studentManagementSystem/reg" method="post">
        <div class="d2">
            <label for="name">姓名：</label>
            <input type="text"
                   id="name"
                   name="name"
                   placeholder="请输入姓名"/>
        </div>
        <div class="d2">
            <label for="username">账号：</label>
            <input type="text"
                   id="username"
                   name="username"
                   placeholder="请输入账号"/>
        </div>
        <div class="d2">
            <label for="password">密码：</label>
            <input type="password"
                   id="password"
                   name="password"
                   placeholder="请输入密码"/>
        </div>
        <div class="d2">
            <label for="passwordcon">确认密码：</label>
            <input type="password"
                   id="passwordcon"
                   name="passwordcon"
                   placeholder="请输入密码"/>
        </div>
        <div class="register">
            <input type="submit" value="登录"/>
        </div>
    </form>




</div>

</body>
</html>