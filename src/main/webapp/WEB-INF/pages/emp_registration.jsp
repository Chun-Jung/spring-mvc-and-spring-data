<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emp registration page</title>
</head>
<body>
	<!-- 'command' is default value for modelAttribute -->
	<form:form mehtod="POST" modelAttribute="empForm">
		<form:label path="ename">員工姓名:</form:label>
		<form:input path="ename" /><br />
		<form:label path="job">職　　稱:</form:label>
		<form:input path="job" /><br />
		<form:label path="hiredate">聘用日期:</form:label>
		<form:input path="hiredate" /><br />
		<form:label path="sal">薪　　水:</form:label>
		<form:input type="number" path="sal" step="0.01"/><br />
		<form:label path="comm">傭　　金:</form:label>
		<form:input type="number" path="comm" step="0.01"/><br />
		<form:label path="deptno">部門編號:</form:label>
		<form:select path="deptno">
			<c:forEach items="${depts }" var="dept">
				<form:option value="${dept.deptno }">${dept.deptno }-${dept.dname }</form:option>
			</c:forEach>
		</form:select><br>
		<button>Submit</button>
	</form:form>
</body>
</html>