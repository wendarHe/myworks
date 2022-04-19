<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="initial.css">
    <link rel="stylesheet" href="s2.css">
</head>
<body>
<div class="container">
    <div class="d1">欢迎登录</div>
    <form action="/studentManagementSystem/login" method="post">
        <div class="username">
            <label for="username">账号：</label>
            <input type="text"
                   id="username"
                   name="username"
                   placeholder="请输入账号"/>
        </div>
        <div class="password">
            <label for="password">密码：</label>
            <input type="text"
                   id="password"
                   name="password"
                   placeholder="请输入密码"/>
        </div>

        <div class="login">
            <input class="logininput" type="submit" value="登录"/>
        </div>
    </form>

</div>


</body>
</html>