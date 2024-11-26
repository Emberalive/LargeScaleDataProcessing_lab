<html>
<head>
<title>JSP Form Results</title>
</head>
<body>
<h1>JSP Form Results</h1>
Hello <%= request.getParameter("firstName") %>
<%= request.getParameter("lastName") %>
</body>
</html>
