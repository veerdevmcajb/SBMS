<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page Title</title>
</head>
<body>
	
	<font color ="green">${msg}</font>
    <h3>User Form</h3>
	
	<form action="user" method="post">
		
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"/></td>
			</tr>
						
			<tr>
				<td>PhoNo :</td>
				<td><input type="text" name="phono"/></td>
			</tr>
			
			<tr>
				<td> :</td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>
