<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="mvc.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User validated</title>
</head>
<body>
<%
UserBean bean=(UserBean)request.getAttribute("mvcbean");
out.print("<h1>User Validated!</h1><br>Welcome, "+bean.getEmail());
%>
</body>
</html>
