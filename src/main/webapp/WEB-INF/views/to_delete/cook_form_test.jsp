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

	<form:errors path="*" />
	<form:form servletRelativeAction="/comment" modelAttribute="commentForm">	
		<form:label path="comment.description">Comentário</form:label>
		<form:textarea path="comment.description" />
		<form:errors path="comment.description" />	
		
		<input type="hidden" name="idRecipe" id="idRecipe" value="${recipeCommented.idRecipe }">
		
		<button type="submit">Enviar</button>
	</form:form>

</body>
</html>