<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
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
					<th>地點</th>
					<th></th></tr>
			</thead>
			<tbody>
				<c:forEach items="${depts }" var="dept">
					<tr>
						<td>${dept.dname }</td>
						<td>${dept.loc }</td>
						<td>
							<a class="btn btn-success" href="<%=request.getContextPath() %>/dept/modify/${dept.deptno}">更新</a>
							<button class="btn btn-danger" onclick="deleteDept(${dept.deptno}, '${dept.dname }', this)">刪除</button></td></tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-default" href="<%=request.getContextPath()%>/welcome">回首頁</a>
	</div>
	<script type="text/javascript">
		function deleteDept(deptno, dname, btn){
			var confirmMsg = 'You\'re deleting department : ' + deptno + '-' + dname + ', are you sure you want to do it?';
			if(window.confirm(confirmMsg) != true){
				return;
			}
			
			var xmlHttpRequest = new XMLHttpRequest();
			
			xmlHttpRequest.onreadystatechange = function() {
		        if (xmlHttpRequest.readyState == XMLHttpRequest.DONE ) {
		           if (xmlHttpRequest.status != 204) {
		        	   alert('something else other than 204 was returned ' + xmlHttpRequest.status);
		        	   return;
		           }
		           var tbodyNode = document.getElementsByTagName("tbody")[0];
				   var childNode = btn.parentNode.parentNode;
				   tbodyNode.removeChild(childNode);
		        }
		    };
		    
		    xmlHttpRequest.open('DELETE', '<%=request.getContextPath()%>/dept/deleteOne/' + deptno, true);
		    xmlHttpRequest.send();
		}
		
	</script>
</body>
</html>