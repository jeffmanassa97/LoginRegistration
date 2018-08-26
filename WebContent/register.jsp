<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register!</title>
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
		<h3>Registration Page</h3>

		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td>Re-Type Password :</td>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit" value="Register"></td>
			</tr>
		</table>
	</form>

</body>
</html>