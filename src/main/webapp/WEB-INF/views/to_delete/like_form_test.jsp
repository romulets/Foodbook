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
	<link href="/Foodbook/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/Foodbook/resources/css/blog-home.css" rel="stylesheet">	

	<form:errors path="*" />
	<form:form servletRelativeAction="/like" modelAttribute="likeForm">
		<input type="hidden" name="recipe.idRecipe" value="${recipe.idRecipe}">
		<button type="submit">
			<span class="glyphicon glyphicon-thumbs-up"></span>
		</button>
	</form:form>
	
	<!-- glyphicon glyphicon-cutlery -->
</body>
</html>