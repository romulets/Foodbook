<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="loggedUser"/>

<div>

	<c:if test="${ requestScope.recipe.publishedBy.idUser == loggedUser.idUser}" >
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
     	<a href="/Foodbook/recipe/${ requestScope.recipe.idRecipe }">${ requestScope.recipe.name }</a>
 	</h2>
 	
	<h6>
	     <span class="glyphicon glyphicon-time"></span> Postado por <a href="/Foodbook/profile/${ requestScope.recipe.publishedBy.idUser }">
	     		${ requestScope.recipe.publishedBy.name }.
     		</a> em 
     		
     		<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${requestScope.recipe.publicationDate}" />	     	 
	</h6>

	<img class="img-responsive center-block" src="http://placehold.it/900x300" alt="">
	
	<p>${ requestScope.recipe.description }</p>
	<a class="btn btn-info btn-xs pull-right" href="/Foodbook/recipe/${ requestScope.recipe.idRecipe }">
		<span class="glyphicon glyphicon-ice-lolly-tasted"></span> Quero ver como faz
	</a>
	
	<span class="clearfix"></span>
</div>

<hr />