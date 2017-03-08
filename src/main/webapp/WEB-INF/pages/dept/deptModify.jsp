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
<spring:url value="/resources/css/normalize.css" var="normalizeCss" 
/><spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<title>${title }</title>
</head>
<body>
	<spring:url var="actionUrl" value="/dept/modify" />
	<div class="container">
		<form:form action="${actionUrl }" method="post" modelAttribute="deptForm">
			<form:hidden path="deptno"/>
			<h3>部門 - 新增 / 修改</h3>
			<div class="form-group">
				<form:label path="dname">部門名稱</form:label>
				<form:input path="dname"/><br />
			</div>
			<div class="form-group">
				<form:label path="loc">部門地點</form:label>
				<form:input path="loc"/><br />
			</div>
			<button class="btn btn-primary">送出</button>
			<a href="<%=request.getContextPath() %>/welcome" class="btn btn-default">回首頁</a>
		</form:form>
	</div>
</body>
</html>