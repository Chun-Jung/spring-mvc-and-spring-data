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
<title>Dept find one page</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>部門名稱</th>
					<th>地點</th></tr>
			</thead>
			<tbody>
				<tr>
					<td>${dept.dname }</td>
					<td>${dept.loc }</td></tr>
			</tbody>
		</table>
		<a class="btn btn-default" href="<%=request.getContextPath() %>/welcome">回首頁</a>
		<a class="btn btn-info" href="<%=request.getContextPath() %>/dept/findAllDepts">查看所有部門</a>
		<a class="btn btn-success" href="<%=request.getContextPath() %>/dept/modify/${dept.deptno}">更新</a>
	</div>
</body>
</html>