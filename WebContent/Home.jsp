<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href = "\RecipeSharing\Login.jsp">Login</a>
<a href = "\RecipeSharing\SignUp.jsp">Sign Up</a> <br/>

<form>
	<b>Category:</b>
	<span>
	<select name="mood">
		<option value="0" selected disabled>Category1</option>
		<option value="happy">:)</option>
		<option value="neutral">:|</option>
		<option value="sad">:(</option>
	</select>	
	<select name="mood">
		<option value="0" selected disabled>Category2</option>
		<option value="happy">:)</option>
		<option value="neutral">:|</option>
		<option value="sad">:(</option>
	</select>	
	<select name="mood">
		<option value="0" selected disabled>Category3</option>
		<option value="happy">:)</option>
		<option value="neutral">:|</option>
		<option value="sad">:(</option>
	</select>	
	<select name="mood">
		<option value="0" selected disabled>Category4</option>
		<option value="happy">:)</option>
		<option value="neutral">:|</option>
		<option value="sad">:(</option>
	</select>
	<button type="submit">Go</button>
	</span>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
	<span>
  <label for="search">     <b>Search</b></label>
  <input type="search" name="search">
  <input type="submit">
</span>
</form>

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