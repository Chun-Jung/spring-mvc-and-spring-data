<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
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
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${emp.hiredate }"/></td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
					<td>${emp.dept.deptno }-${emp.dept.dname }</td>
					<td>
						<a class="btn btn-success" href="<%=request.getContextPath() %>/emp/modify/${emp.empno}">更新</a>
						<button class="btn btn-danger" onclick="deleteEmp(${emp.empno}, this)">刪除</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-default" href="<%=request.getContextPath() %>/welcome">回首頁</a>
	</div>
	<script type="text/javascript">
		function deleteEmp(empno, btn){
			var xmlHttpRequest = new XMLHttpRequest();
			
			xmlHttpRequest.onreadystatechange = function() {
		        if (xmlHttpRequest.readyState == XMLHttpRequest.DONE ) {
		           if (xmlHttpRequest.status != 204) {
		        	   alert('something else other than 204 was returned ' + xmlHttpRequest.status);
		           }
		           
		        }
		    };
		    
		    xmlHttpRequest.open('DELETE', '<%=request.getContextPath() %>/emp/deleteOne/' + empno, true);
		    xmlHttpRequest.send();
		    var tbodyNode = document.getElementsByTagName("tbody")[0];
			var childNode = btn.parentNode.parentNode;
			tbodyNode.removeChild(childNode);
		}
	</script>
</body>
</html>