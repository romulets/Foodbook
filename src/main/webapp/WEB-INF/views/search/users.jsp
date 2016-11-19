<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Buscar por usuários"/>
</jsp:include>

	<div class="row">
    	<div class="col-md-8 col-md-offset-2">
    		<h1>Buscando por Usuários</h1>
    		
			<c:set var="usersCount" value="${usersCount}" scope="request"/>
			<c:set var="recipesCount" value="${recipesCount}" scope="request"/>
			<c:set var="query" value="${query}" scope="request"/>
			<c:set var="searchType" value="users" scope="request"/>
			<c:set var="searchForm" value="${searchForm}" scope="request"/>
			<c:import url="../includes/logged/search-header.jsp" />
			
			<hr />
			
			<c:forEach items="${users}" var="user">
				<div class="col-md-6 margin-bottom">
		    			<img class="img-circle" src="http://placehold.it/50x50"  width="50px" alt="">
		    			<strong class="margin-left">
		    				<a href="/Foodbook/profile/${user.idUser}">${ user.name }</a>
		    			</strong>
		   			</div>
		  	</c:forEach>
			
			<c:if test="${ usersCount == 0}" >
				<p>Nenhum usuário foi encontrado pela busca "${ query }" :(</p>
			</c:if>
			
		</div>
	</div>	
	

<jsp:include page="../includes/logged/footer.jsp" />