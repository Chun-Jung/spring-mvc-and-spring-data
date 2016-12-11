<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multipart upload</title>
</head>
<body>
	<h3>single upload file</h3>
	<form action="<%=request.getContextPath() %>/multipart/upload" method="post" enctype="multipart/form-data">
		<label>username: </label>
		<input type="text" name="username" /><br />
		<label>upload file: </label>
		<input type="file" name="upload" /><br />
		<button>submit</button>
	</form>
	
	<h3>multiple upload files</h3>
	<form action="<%=request.getContextPath() %>/multipart/uploads" method="post" enctype="multipart/form-data">
		<label>username: </label>
		<input type="text" name="username" /><br />
		<label>upload file: </label>
		<input type="file" name="upload" /><br />
		<label>upload file: </label>
		<input type="file" name="upload" /><br />
		<label>upload file: </label>
		<input type="file" name="upload" /><br />
		<button>submit</button>
	</form>
</body>
</html>