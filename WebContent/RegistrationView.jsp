<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<%@ include file ="Header.jsp" %>
<br>

	<div align="center">
		<h1>User Registration</h1>
		<form action = "RegistrationCtl" method = "post">
			<table >

				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><input type="text" name=lastName></td>
				</tr>

				<tr>
					<td>Login Id:</td>
					<td><input type="text" name="loginId"></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td>Date of birth:</td>
					<td><input type="date" name="dob" style="width: 98%"></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
				<th></th>
				<th><input type = "submit"></th>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>