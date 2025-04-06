<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form details</title>
</head>
<body>
<h1>Data Submitted Success..!!</h1>

	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>
	<%=request.getParameter("loginId")%>
	<%=request.getParameter("password")%>
	<%=request.getParameter("dob")%>
	<%=request.getParameter("address")%>
</body>
</html>