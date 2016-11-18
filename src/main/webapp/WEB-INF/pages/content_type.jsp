<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content type page</title>
</head>
<body>
	<label>Content-Type header: </label>
	<input id="contentTypeValue" type="text" value="text/json"><br>
	<label>Accept header: </label>
	<input id="acceptValue" type="text" value="application/json"><br>
	<button onclick="verifyContentType()">verifyContentType</button>

	<script type="text/javascript">
		function verifyContentType(){
			var contentTypeValue = document.getElementById('contentTypeValue').value;
			var acceptValue = document.getElementById('acceptValue').value;
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

		    xmlHttpRequest.open("POST", "<%=request.getContextPath() %>/requestmapping/contentType", true);
		    xmlHttpRequest.setRequestHeader("Content-Type", contentTypeValue);
		    xmlHttpRequest.setRequestHeader("Accept", acceptValue);
		    xmlHttpRequest.send();
		}
	</script>
</body>
</html>