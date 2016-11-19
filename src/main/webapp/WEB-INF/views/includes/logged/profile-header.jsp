<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="loggedUser"/>
	

<div class="text-center">
	<img class="img-circle center-block" src="http://placehold.it/200x200"  width="200px" alt="">
	<br />
	<h2>${ requestScope.user.name }</h2>
</div>

<c:if test="${ requestScope.user.idUser != loggedUser.idUser }">
<c:choose>
	    <c:when test="${ isFollowing == true }">
	    <form:form servletRelativeAction="/unfollow" modelAttribute="user">
				<input type="hidden" name="idUser" value="${requestScope.user.idUser }">
				<button type="submit" class="btn btn-danger btn-xs pull-right margin-bottom">Deixar de ver as receitas desse Chef!</button>
			</form:form>
	    </c:when>
	    <c:otherwise>
	    	<form:form servletRelativeAction="/follow" modelAttribute="user">
				<input type="hidden" name="idUser" value="${requestScope.user.idUser }">
				<button type="submit" class="btn btn-success btn-xs pull-right margin-bottom">Ver receitas desse Chef!</button>
			</form:form>
	    </c:otherwise>
	</c:choose>
</c:if>
	
<c:if test="${ requestScope.user.idUser == loggedUser.idUser }">
	<a class="btn btn-default btn-xs pull-right margin-bottom" href="/Foodbook/profile/edit">Editar Perfil</a>
</c:if>
	
<div class="btn-group btn-group-justified">
	<a href="/Foodbook/profile/${ user.idUser }" class="btn btn-default ${requestScope.active == 'profile' ? 'active' : ''}">Receitas</a>
	<a href="/Foodbook/followers/${ user.idUser }" class="btn btn-default ${requestScope.active == 'followers' ? 'active' : ''}">
		Seguidores <span class="badge">${ user.followers.size() }</span>
	</a>
	<a href="/Foodbook/following/${ user.idUser }" class="btn btn-default ${requestScope.active == 'following' ? 'active' : ''}">
		Seguindo <span class="badge">${ user.following.size() }</span>
	</a>
</div>				
	
<span class="clearfix"></span>
<hr />