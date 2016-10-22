<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test for comments</title>
</head>
<body>
	<!-- Page just for tests purposes -->
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:errors path="*" />
	<form:form servletRelativeAction="/send" modelAttribute="notification">
		<input type="hidden" name="notificationTo.idUser" value="${userTo.idUser }">
		<button type="submit">Enviar notificação</button>
	</form:form>
</body>
</html>