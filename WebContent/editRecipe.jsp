<%@page import="entities.Recipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Recipe Page</title>
</head>
<body>
	<%
		Recipe recipe = (Recipe) request.getAttribute("recipeToBeEdited");
		String recipeName = recipe.getRecipeName();
		String ingredients = recipe.getIngredients();
		String steps = recipe.getSteps();
	%>
	<form action="/RecipeSharing/EditController" method="post">
		<input type="hidden" name="jspname" value="edit" />
		<input type="hidden" name="myObjectId" value="<%=recipe.getRecipeId()%>" />
		<label>Recipe Name:</label> 
		<input type="text" name="recipeName" value="<%=recipeName%>">
		<label>Ingredients:</label>
		<textarea rows="4" cols="10" name="ingredients" ><%=ingredients%></textarea>
		<label>Steps:</label>
		<textarea rows="4" cols="10" name="steps"><%=steps%></textarea>
		<input type="submit" value="Edit">
	</form>
</body>
</html>