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
<title>Emp find one page</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>員工姓名</th>
					<th>職稱</th>
					<th>聘用日期</th>
					<th>薪水</th>
					<th>傭金</th>
					<th>部門</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
					<td>${emp.dept.deptno }-${emp.dept.dname }</td>
				</tr>
			</tbody>
		</table>
		<a class="btn btn-default" href="<%=request.getContextPath() %>/welcome">回首頁</a>
	</div>
</body>
</html>