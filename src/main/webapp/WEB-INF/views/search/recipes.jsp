<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Buscar por Receitas"/>
</jsp:include>

	<div class="row">
    	<div class="col-md-8 col-md-offset-2">
    		<h1>Buscando por Receitas</h1>
    	
			<c:set var="usersCount" value="${usersCount}" scope="request"/>
			<c:set var="recipesCount" value="${recipesCount}" scope="request"/>
			<c:set var="query" value="${query}" scope="request"/>
			<c:set var="searchType" value="recipes" scope="request"/>
			<c:set var="searchForm" value="${searchForm}" scope="request"/>
			<c:import url="../includes/logged/search-header.jsp" />
			
			<hr />
			
			<c:forEach items="${recipes}" var="recipe">
				<c:set var="recipe" value="${recipe}" scope="request"/>
				<c:import url="../includes/logged/recipe-preview.jsp" />
  			</c:forEach>
  			
  			<c:if test="${ recipesCount == 0}" >
				<p>Nenhuma receita foi encontrada pela busca "${ query }" :(</p>
			</c:if>
			
		</div>
	</div>

<jsp:include page="../includes/logged/footer.jsp" />