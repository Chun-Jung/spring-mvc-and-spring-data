<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parameters page</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/requestmapping/parameters" method="post">
		<label>Username: </label>
		<input type="text" name="username"><br>
		<label>Password: </label>
		<input type="password" name="password"><br>
		<button>Submit</button>
	</form>
</body>
</html>