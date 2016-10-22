<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
	<form:errors path="*" />
	<form:form servletRelativeAction="/accept" modelAttribute="notification">
		<input type="hidden" name="idNotification" value="${idNotification }">
		<button type="submit">Aceitar</button>
	</form:form>
	
	<form:errors path="*" />
	<form:form servletRelativeAction="/refuse" modelAttribute="notification">
	<input type="hidden" name="idNotification" value="${idNotification }">
		<button type="submit">Recusar</button>
	</form:form>

</body>
</html>