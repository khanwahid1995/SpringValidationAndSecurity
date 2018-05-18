<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="logout"  method="POST">
	<input type="submit" value="logout"/>
	<input type="hidden" name="${_csrf.parameterName}" id='token' value="${_csrf.token}"/>
</form>
</body>
<script>
	alert(document.getElementById('token').value)
	if(location.href.split('/')[4]==""){
		alert('d')
		location.href=location.href+"registration.html?token="+document.getElementById('token').value;
		}
</script>
</html>
