<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<h1>RequestMethod.GET</h1>
	<form action="<%=request.getContextPath() %>/requestmapping/login" method="post">
		<label>Name: </label>
		<input type="text" name="name"><br>
		<button>Submit</button>
	</form>
</body>
</html>