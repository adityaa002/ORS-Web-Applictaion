<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<form action="AddUserCtl" method="post">

		<div align="center">
			<table >
				<h3>Add User</h3>
				
				<tr>  
				<th>First Name:</th>
				<th><input type ="text" name = "firstName"> </th>
				</tr>
				
				<tr>
				<th>Last Name:</th>
				<th><input type = "text" name = "lastName"></th>
				</tr>

				
				<tr>
				<th>Login Id:</th>
				<th><input type = "text" name = "loginId"></th>
				</tr>

				
				<tr>
				<th>Password:</th>
				<th><input type = "text" name = "password"></th>
				</tr>

				
				<tr>
				<th>Date of Birth:</th>
				<th><input type = "Date" name = "dob" style="width: 98%" ></th>
				</tr>

				
				<tr>
				<th>Address:</th>
				<th><input type = "text" name = "address"></th>
				</tr>
				
				
				<tr>
				<th></th>
				<th><input type = "Submit" name ="operation" value = "save"></th>
				</tr>
				
				

			</table>


		</div>


	</form>


</body>
</html>