<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test for comments</title>
</head>
<body>
	<!-- Page just for tests purposes, delete after recipe pages get done. -->
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:errors path="*" />
	<form:form servletRelativeAction="/comment" modelAttribute="commentForm">
		<form:label path="comment.description">Comentário</form:label>
		<form:textarea path="comment.description" />
		<form:errors path="comment.description"/>
		
		<button type="submit">Enviar</button>
	</form:form>
</body>
</html>