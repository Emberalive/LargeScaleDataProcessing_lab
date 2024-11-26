<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC</title>
</head>
<body>
<form action="usrsrv">
Email: <input type="text" name="email">
<br />
Password: <input type="password" id="pass" name="password" minlength="8" required/>
<input type="submit" value="Submit" />
</form>
<p> Password must be at list 8 characters long</p>
</body>
</html>
