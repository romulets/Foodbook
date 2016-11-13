<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Page just for tests purposes, delete after recipe pages get done. -->
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form action="search/test" method="GET" >	
		<input type="text" id="name" />		
		<button type="submit">Enviar</button>
	</form>

</body>
</html>