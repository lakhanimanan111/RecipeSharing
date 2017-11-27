<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Recipe Page</title>
</head>
<body>

	<form action="/RecipeSharing/UploadController" method="post">
		<input type="hidden" name="jspname" value="upload" />
		<label>Recipe Name:</label> 
		<input type="text" name="recipeName">
		<label>Ingredients:</label>
		<textarea rows="4" cols="10" name="ingredients"></textarea>
		<label>Steps:</label>
		<textarea rows="4" cols="10" name="steps"></textarea>
		<input type="submit" value="Upload">
	</form>
</body>
</html>