<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<a href="signUp.jsp">Sign Up</a>
<form action="/RecipeSharing/LoginController">
  
    <label><b>User name</b></label>
    <input type="text" name="uname" required>

	<br>
	
    <label><b>Password</b></label>
    <input type="password" name="psw" required>
    
    <br>
    
	<input type="submit" value="Login">
	
</form>

</body>
</html>