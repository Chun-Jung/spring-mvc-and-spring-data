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
<spring:url value="/resources/css/normalize.css" var="normalizeCss" 
/><spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" 
/><spring:url value="/resources/js/jquery.min.js" var="jqueryJs" 
/><spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<style type="text/css">
	.margin-top{
		margin-top: 20px;
	}
</style>
<title>Welcome!</title>
</head>
<body>
	<h1>Hello Spring MVC</h1>
	<div class="container">
		<c:if test="${not empty errorMsg }">
			<h3 style="color:red">${errorMsg }</h3>
		</c:if>
		<div class="margin-top">
			<h3>部門查詢</h3>
			<form class="form-inline" action="<%=request.getContextPath() %>/dept/findOne" method="post">
				<label for="deptno1" >部門編號:</label>
				<input id="deptno1" class="form-control" type="text" name="deptno" />
				<button class="btn btn-default">查詢</button>
			</form>
			<form class="form-inline" action="<%=request.getContextPath() %>/dept/findOne" method="post">
				<form:label for="deptno2" path="depts">部門編號:</form:label>
				<form:select id="deptno2" class="form-control"  path="depts" name="deptno">
	<%-- 				<form:options items="${depts }" itemLabel="dname" itemValue="deptno"/> --%>
					<c:forEach items="${depts }" var="item">
						<form:option value="${item.deptno }">${item.deptno }-${item.dname }</form:option>
					</c:forEach>
				</form:select>
				<button class="btn btn-default">查詢</button>
			</form>
			<a href="<%=request.getContextPath() %>/dept/add">新增部門</a>
			<a href="<%=request.getContextPath() %>/dept/findAllDepts">查看全部</a>
		</div>
		<hr />
		<div class="margin-top">
			<h3>員工查詢</h3>
			<form class="form-inline" action="<%=request.getContextPath() %>/emp/findOne" method="post">
				<label for="empno1">員工編號</label>
				<input id="empno1" class="form-control" type="text" name="empno"/>
				<button class="btn btn-default">查詢</button>
			</form>
			<form class="form-inline" action="<%=request.getContextPath() %>/emp/findOne" method="post">
				<label for="empno2">員工編號:</label>
				<form:select id="empno2" class="form-control" path="emps" name="empno">
					<form:options items="${emps }" itemLabel="ename" itemValue="empno" />
				</form:select>
				<button class="btn btn-default">查詢</button>
			</form>
			<a href="<%=request.getContextPath() %>/emp/add">新增員工</a>
			<a href="<%=request.getContextPath() %>/emp/findAllEmps">查看全部</a>
		</div>
	</div>
	
	<script src="${jqueryJs }"></script>
	<script src="${bootstrapJs }"></script>
</body>
</html>