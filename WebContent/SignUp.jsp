<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>

<h1>Sign Up</h1>
	
<form action="/RecipeSharing/SignUpController" method="post">

	<label><b>Name</b></label>
	<input type="text" name="name" required><br><br>

    <label><b>Email</b></label>
    <input type="text" name="email" required><br><br>
    
    <label><b>User Name</b></label>
    <input type="text" name="uname" required><br><br>
    
    <label><b>Password</b></label>
    <input type="password" name="psw" required><br><br>
    
    <input type="submit" value="Sign Up"/>
    
 </form>
</body>
</html>