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
	
	<form:form servletRelativeAction="/comment" method="POST">
		<label for="comment">Comentário</label>
		<textarea rows="4" cols="50" name="description" id="description"></textarea>
		<input type="hidden" id="recipeCommented" name="recipeCommented" value="${recipe.idRecipe }" />
		<input type="hidden" id="user" name="user" value="${currentUser.id }" />
		
		<button type="submit">Enviar</button>
	</form:form>

</body>
</html>