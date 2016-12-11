<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css/normalize.css" var="normalizeCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<title>Data binding</title>
</head>
<body>
	<!-- 'command' is default value for modelAttribute -->
	<form:form mehtod="POST" modelAttribute="uploadForm" enctype="multipart/form-data">
		<form:label path="username">username:</form:label>
		<form:input path="username"/><br />
		<form:label path="date">date:</form:label>
		<form:input path="date"/><br />
		<form:label path="file">uploads:</form:label>
		<input type="file" name="file" /><br />
		<form:label path="file">uploads:</form:label>
		<input type="file" name="file" /><br />
		<button>Submit</button>
	</form:form>
</body>
</html>