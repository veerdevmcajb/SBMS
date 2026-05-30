<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Register Page</h2>

<form action="saveUser" method="post">

    Name :
    <input type="text" name="name"/><br><br>

    Email :
    <input type="email" name="email"/><br><br>

    Password :
    <input type="password" name="password"/><br><br>

    Phone :
    <input type="text" name="phono"/><br><br>

    <input type="submit" value="Register"/>

</form>

</body>
</html>