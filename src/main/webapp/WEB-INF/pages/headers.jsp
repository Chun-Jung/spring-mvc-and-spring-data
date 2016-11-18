<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header page</title>
</head>
<body>
	<label>customer-header header: </label>
	<input id="customer-header" type="text" value="spring-mvc"><br>
	<label>content-type header: text/</label>
	<input id="content-type" type="text" value="json"><br>
	<button onclick="verifyHeaders()">verifyHeaders</button>

	<script type="text/javascript">
		function verifyHeaders(){
			var customer_header = document.getElementById('customer-header').value;
			var content_type = document.getElementById('content-type').value;
			var xmlHttpRequest = new XMLHttpRequest();
			
			xmlHttpRequest.onreadystatechange = function() {
		        if (xmlHttpRequest.readyState == XMLHttpRequest.DONE ) {
		           if (xmlHttpRequest.status == 200) {
		        	   alert(xmlHttpRequest.responseText);
		           } else if (xmlHttpRequest.status == 400) {
		               alert('There was an error 400');
		           } else if(xmlHttpRequest.status == 404){
		        	   alert('There was an error 404');
		           } else {
		               alert('something else other than 200 was returned ' + xmlHttpRequest.status);
		           }
		        }
		    };

		    xmlHttpRequest.open("POST", "<%=request.getContextPath() %>/requestmapping/headers", true);
		    xmlHttpRequest.setRequestHeader("test-header", "nothing");
		    xmlHttpRequest.setRequestHeader("customer-header", customer_header);
		    xmlHttpRequest.setRequestHeader("content-type", 'text/' + content_type);
		    xmlHttpRequest.send();
		}
	</script>
</body>
</html>