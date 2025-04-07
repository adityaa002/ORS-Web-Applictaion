<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>


	
	<%
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>



	<%@include file="Header.jsp"%>

	<div align="center">
		<h3>User list</h3>
		<form action="UserListCtl" method="post">
			<table border="1%" style="width: 100%">

				<tr align="center">
					<th>Select</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login Id</th>
					<th>Password</th>
					<th>Date of Birth</th>
					<th>Address</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getAddress()%></td>

					<td><a href="AddUserCtl">Edit</a></td>
					<td></td>


				</tr>
				<%
					}
				%>



			</table>
		</form>
	</div>

</body>
</html>