<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Login Page</h2>

<font color="green">${msg}</font>

<form action="login" method="post">

    Email :
    <input type="email" name="email"/><br><br>

    Password :
    <input type="password" name="password"/><br><br>

    <input type="submit" value="Login"/>

</form>

<br>

<a href="register">New User ? Register Here</a>

</body>
</html>