<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="searchForm" method="GET" action="/Foodbook/search/${ requestScope.searchType }">
       	
       	<div class="row">
       		<div class="col-md-9">
	       		<div class="form-group">
		       		<form:input path="query" cssClass="form-control" placeholder="Digite sua busca aqui.."/>
					<form:errors path="query"/>
		       	</div>
	       	</div>
	       	
	       	<div class="col-md-3">
	       		<input type="submit" value="Buscar" class="btn btn-success btn-block" />
	       	</div>
       	</div>
       	
</form:form>

<c:if test="${ requestScope.recipesCount > 0 || requestScope.usersCount > 0 }" >
	<div class="btn-group btn-group-justified">
	
	<c:if test="${requestScope.recipesCount > 0 }" >	
		<a href="/Foodbook/search/recipes?query=${ requestScope.query }" class="btn btn-default ${requestScope.searchType == 'recipes' ? 'active' : ''}">
			Receitas <span class="badge">${ requestScope.recipesCount }</span>
		</a>
	</c:if>
	
	<c:if test="${requestScope.usersCount > 0 }" >	
		<a href="/Foodbook/search/users?query=${ requestScope.query }" class="btn btn-default ${requestScope.searchType == 'users' ? 'active' : ''}">
			Usuários <span class="badge">${ requestScope.usersCount }</span>
		</a>
	</c:if>
	
</div>
</c:if> 