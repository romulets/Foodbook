<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Buscar"/>
</jsp:include>

	<div class="row">
    	<div class="col-md-8 col-md-offset-2">
    		<h1>Buscar</h1>
    	
			<c:set var="usersCount" value="${usersCount}" scope="request"/>
			<c:set var="recipesCount" value="${recipesCount}" scope="request"/>
			<c:set var="query" value="${query}" scope="request"/>
			<c:set var="searchType" value="recipes" scope="request"/>
			<c:set var="searchForm" value="${searchForm}" scope="request"/>
			<c:import url="../includes/logged/search-header.jsp" />
		</div>
	</div>

<jsp:include page="../includes/logged/footer.jsp" />