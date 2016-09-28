<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Foodbook</title>
</head>
<body>

	<h1>Login</h1>

	<form action="/Foodbook/teste" method="POST">
		<input type="text" value="Nome">
		<input type="password" value="Senha">
		
		<input type="submit" value="Enviar">
	</form>

</body>
</html>