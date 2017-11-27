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
<a href = "uploadRecipe.jsp">Upload Recipe</a>
<a href = "intermediate.jsp">View Recipe</a>
<a href="search.jsp">Search Recipe</a>
	
<div>
	<h2>Popular Recipes</h2>
<table border=1>
<tr>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
</tr>
<tr>
	<td>like?rating?</td>
	<td>like?rating?</td>
	<td>like?rating?</td>
</tr>
</table>
</div>

<div>
	<h2>Chef's Recommendation</h2>
	<table border=1>
<tr>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
	<td><img src="http://img4.wikia.nocookie.net/__cb20140328190757/pokemon/images/thumb/2/21/001Bulbasaur.png/200px-001Bulbasaur.png"></td>
</tr>
<tr>
	<td>text</td>
	<td>text</td>
	<td>text</td>
</tr>
</table>
</div>

</body>
</html>