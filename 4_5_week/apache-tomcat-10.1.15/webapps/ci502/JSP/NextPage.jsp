<jsp:useBean id="user" class="user.UserData" scope="session"/>
<html>
	<body>
		You entered <br>
		
		Name: <%= user.getUsername() %><br>
		Email: <%= user.getEmail() %><br>
		Age: <%= user.getAge() %><br>
	</body>
</html>
