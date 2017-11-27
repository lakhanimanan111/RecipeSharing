<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
		String user = (String) session.getAttribute("currentUser");
%>
Welcome <%= user %>


<a href = "login.jsp">Log Out</a> <br>
<a href = "intermediate.jsp">Approve Recipe</a>


</body>
</html>