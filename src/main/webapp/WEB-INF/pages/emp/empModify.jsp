<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css/normalize.css" var="normalizeCss" 
/><spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" 
/><spring:url value="/resources/css/bootstrap-datepicker3.min.css" var="bootstrapDatepickerCss" 
/><spring:url value="/resources/js/jquery.min.js" var="jqueryJs" 
/><spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" 
/><spring:url value="/resources/js/bootstrap-datepicker.min.js" var="bootstrapDatepickerJs" 
/><spring:url value="/resources/locales/bootstrap-datepicker.zh-TW.min.js" var="bootstrapDatepickerLocaleJs" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<link rel="stylesheet" href="${bootstrapDatepickerCss }">
<title>${title }</title>
</head>
<body>
	<spring:url var="actionUrl" value="/emp/modify" />
	<div class="container">
		<!-- 'command' is default value for modelAttribute -->
		<form:form action="${actionUrl }" modelAttribute="empForm" mehtod="POST">
			<fmt:formatDate value="${empForm.hiredate }" var="fmtHiredate" pattern="yyyy/MM/dd" />
			<form:hidden path="empno" />
			<h3>員工 - 新增 / 修改</h3>
			<div class="form-group">
				<form:label path="ename">員工姓名:</form:label>
				<form:input path="ename" />
				<br />
			</div>
			<div class="form-group">
				<form:label path="job">職　　稱:</form:label>
				<form:input path="job" />
				<br />
			</div>
			<div class="form-group">
				<form:label path="hiredate">聘用日期:</form:label>
				<form:input path="hiredate" id="empModifyDatePicker" value="${fmtHiredate }" readonly="true" />
				<br />
			</div>
			<div class="form-group">
				<form:label path="sal">薪　　水:</form:label>
				<form:input type="number" path="sal" step="0.01" />
				<br />
			</div>
			<div class="form-group">
				<form:label path="comm">傭　　金:</form:label>
				<form:input type="number" path="comm" step="0.01" />
				<br />
			</div>
			<div class="form-group">
				<form:label path="dept.deptno">部門編號:</form:label>
				<form:select path="dept.deptno">
					<c:forEach items="${depts }" var="dept">
						<form:option value="${dept.deptno }">${dept.deptno }-${dept.dname }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<form:button class="btn btn-primary">送出</form:button>
			<a class="btn btn-default" href="<%=request.getContextPath() %>/welcome">回首頁</a>
		</form:form>
	</div>
	<script src="${jqueryJs }"></script>
	<script src="${bootstrapJs }"></script>
	<script src="${bootstrapDatepickerJs }"></script>
	<script src="${bootstrapDatepickerLocaleJs }"></script>
	<script type="text/javascript">
		$(function() {
			$('#empModifyDatePicker').datepicker({
				format : 'yyyy/mm/dd',
				language : 'zh-TW',
				autoclose : true
			});
		});
	</script>
</body>
</html>