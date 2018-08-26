<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In!</title>
<style type="text/css">
body {
	text-align: center;
}

form {
	display: inline-block;
	background: #afafaf;
	font-size: 14pt;
	font-family: fantasy;
	border: 3px red solid;
	padding: 0.5rem;
}
</style>
</head>

<body>

	<form method="post" action="LoginRegister">
		
		<h3 style="color: red;">${message}</h3>
		<h3 style="color: green;">${successMessage}</h3>
		
		<h3>Login Page</h3>

		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td><a href="register.jsp">Registration</a></td>
				<td><input type="submit" name="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>