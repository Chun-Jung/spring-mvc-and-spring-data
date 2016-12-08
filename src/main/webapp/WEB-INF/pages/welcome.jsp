<%@page import="org.apache.commons.lang3.StringUtils"%>
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
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<title>Welcome!</title>
</head>
<body>
	<h1>Hello Spring MVC</h1>
	<div class="container">
		<c:if test="${not empty errorMsg }">
			<h3 style="color:red">${errorMsg }</h3>
		</c:if>
		<form action="<%=request.getContextPath() %>/dept/findOne" method="post">
			<label>部門編號:</label>
			<input type="text" name="deptno">
			<button class="btn btn-default">查詢</button>
		</form>
		<form action="<%=request.getContextPath() %>/dept/findOne" method="post">
			<form:label path="depts">部門編號</form:label>
			<form:select path="depts" name="deptno">
<%-- 				<form:options items="${depts }" itemLabel="dname" itemValue="deptno"/> --%>
				<c:forEach items="${depts }" var="item">
					<form:option value="${item.deptno }">${item.deptno }-${item.dname }</form:option>
				</c:forEach>
			</form:select>
			<button class="btn btn-default">查詢</button>
		</form>
		<a href="<%=request.getContextPath() %>/dept/registration">新增部門</a>
	</div>
	<script src="${jqueryJs }"></script>
	<script src="${bootstrapJs }"></script>
</body>
</html>