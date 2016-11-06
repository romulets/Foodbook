<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - ${ recipe.name }" />
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="loggedUser"/>

<div>

	<c:if test="${ recipe.publishedBy.idUser == loggedUser.idUser}" >
		<div class="dropdown pull-right">
		  <button class="btn btn-default dropdown-toggle btn-xs" type="button" data-toggle="dropdown">
		  <span class="glyphicon glyphicon-cog"></span>
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="/Foodbook/recipe/edit/${recipe.idRecipe}">
		    	<span class="glyphicon glyphicon-pencil"></span> Editar
		    </a></li>
		    <li><a href="#"><span class="glyphicon glyphicon-trash"></span> Deletar</a></li>
		  </ul>
		</div>
	</c:if> 

	
	<h2>
     	<a href="/Foodbook/recipe/${ recipe.idRecipe }">${ recipe.name }</a>
 	</h2>
 	
	<h6>
	     <span class="glyphicon glyphicon-time"></span> Postado por <a href="/Foodbook/profile/${ recipe.publishedBy.idUser }">
	     		${ recipe.publishedBy.name }.
     		</a> em 
     		
     		<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${recipe.publicationDate}" />	     	 
	</h6>

	<img class="img-responsive center" src="http://placehold.it/900x300" alt="">
	
	<p>${ recipe.description }</p>
	
	<hr />
	
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Comentários</h3>
	  </div>
	  <div class="panel-body">
			<c:forEach items="${comments}" var="comment">
				<div class="well well-sm">
				  <strong>${comment.description}</strong> <small class="really-small">comentado por: <a href="/Foodbook/profile/${ comment.user.idUser }">${ comment.user.name }</a></small>
				</div>
		    </c:forEach>
		    
		    <form:errors path="*" />
			<form:form servletRelativeAction="/comment" modelAttribute="commentForm">	
				<div class="form-group">
					<form:label path="comment.description">Comente algo sobre essa receita!</form:label>
					<form:textarea path="comment.description" cssClass="form-control" />
					<form:errors path="comment.description" />
				</div>	
				
				<input type="hidden" name="idRecipe" id="idRecipe" value="${recipe.idRecipe }">
				
				<button type="submit" class="btn btn-default">Comentar</button>
			</form:form>    
	  </div>
	</div>
	
	<span class="clearfix"></span>
</div>

	<jsp:include page="../includes/logged/footer.jsp" />