<%@page import="entities.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Recipe</title>
</head>
<body>
<a href="home.jsp">Home</a>
<h1>List of Recipes</h1>
	
		<table style="width:100%" border = "1">
	
	   	<tr> 
	   		<td>User ID</td>
	        <td>Recipe Name</td>
	        <td>Ingredients</td>
	        <td>Steps</td>
	   	</tr>
		<%
		try {
			
			List<Recipe> recipeList = (List<Recipe>) request.getAttribute("searchedRecipe");
			for(Recipe recipe : recipeList) {
					
		%>
			<tr>  
				<td><%out.print(recipe.getUserId()); %></td>
				<td><%out.print(recipe.getRecipeName()); %></td>
		      	<td><%out.print(recipe.getIngredients()); %></td>
				<td><%out.print(recipe.getSteps());%></td>
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