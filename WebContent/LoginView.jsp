<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
</head>
<body>
<%@include file = "Header.jsp" %>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<h1>Welcome to login page</h1>

		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<td>LoginId :</td>
					<td><input type="text" name="loginId"></td>

				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="SignIn">
					<input type="submit" name="operation" value="SignUp"></td>

				</tr>

			</table>


		</form>

	</div>
	
</body>

</html>