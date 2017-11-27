<%@page import="entities.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Recipe Page</title>
</head>
<body>
<%String userName = (String) session.getAttribute("currentUser"); %>

<%
	if( !("admin".equalsIgnoreCase(userName)) ) {
%>
		<a href="home.jsp">Home</a>
		<a href="uploadRecipe.jsp">Upload Recipe</a>
<%
	} else {
%>
		<a href="adminHome.jsp">Home</a>
<%
	}
%>
	<h1>List of Recipes</h1>
	
		<table style="width:100%" border = "1">
	
	   	<tr> 
	        <td>Recipe Name</td>
	        <td>Ingredients</td>
	        <td>Steps</td>
	   	</tr>
		<%
		try {
			
			List<Recipe> recipeList = (List<Recipe>) request.getAttribute("RecipeList");
			for(Recipe recipe : recipeList) {
					
		%>
			<tr>  
				<td><%out.print(recipe.getRecipeName()); %></td>
		      	<td><%out.print(recipe.getIngredients()); %></td>
				<td><%out.print(recipe.getSteps());%></td>
		<%
			if( !("admin".equalsIgnoreCase(userName)) ) {
		%>
				<td>
					<a href="/RecipeSharing/EditController?recipeId=<%=recipe.getRecipeId()%>">Edit</a>
				</td>
				<td>
					<a href="/RecipeSharing/DeleteController?recipeId=<%=recipe.getRecipeId()%>">Delete</a>
				</td>
		<%   
			} else {
		%>
			<td>
					<a href="/RecipeSharing/ApproveController?recipeId=<%=recipe.getRecipeId()%>">Approve</a>
					<a href="/RecipeSharing/RejectController?recipeId=<%=recipe.getRecipeId()%>">Reject</a>
			</td>
		<%
			}
		%>
			</tr>	       	
		<%
			}
		%>
	   	</table>
	
   <%
   	}
   catch(Exception e)
   {
       e.printStackTrace();
   }
   %>
</body>
</html>