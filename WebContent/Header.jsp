<%@page import="in.co.rays.adv.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		Hi, Mr.
		<%=user.getFirstName()%></h3>

	<a href="AddUserCtl"><b>Add User</b></a>
	<th>|</th>
	<a href="UserListCtl"><b>User List</b></a>
	<th>|</th>
	<a href="LoginCtl?operation=logout"><b>LogOut</b></a>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<a href="WelcomeCtl"><b>Welcome</b></a>
	<th>|</th>
	<a href="LoginCtl"><b>Login</b></a>
	<%
		}
	%>
	<hr>



</body>
</html>