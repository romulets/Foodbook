<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
     	
     	<c:if test="${ !requestScope.recipe.status }">
     		<small class="text-mutted"><i>Não publicado</i></small>
		</c:if>	     	 
 	</h2>
 	 	
	<h6>
	     <span class="glyphicon glyphicon-time"></span> Postado por <a href="/Foodbook/profile/${ requestScope.recipe.publishedBy.idUser }">
	     		${ requestScope.recipe.publishedBy.name }.
     		</a> em 
     		
     		<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${requestScope.recipe.publicationDate}" />
	</h6>
	
	<div class="panel panel-default">
		<c:if test="${ requestScope.recipe.photo!= null }">
			<div class="panel-header">
				<img class="img-responsive center-block" src="${ requestScope.recipe.photo }" alt="">
			</div>
		</c:if>
	
		<div class="panel-body">
			<p>
				<c:if test="${ requestScope.recipe.likedBy.size() == 0 }">
					Nenhum chefe gostou dessa receita ainda :/
				</c:if>
				<c:if test="${ requestScope.recipe.likedBy.size() == 1 }">
					<span class="badge">${ requestScope.recipe.likedBy.size()  }</span> Chefe Gostou dessa receita!
				</c:if>
				<c:if test="${ requestScope.recipe.likedBy.size() > 1 }">
					<span class="badge">${ requestScope.recipe.likedBy.size()  }</span> Chefes Gostaram dessa receita!
				</c:if>
			</p>
			
			<p>${ requestScope.recipe.description }</p>
			
		</div>
		
		<div class="panel-footer">
			<c:choose>
			    <c:when test="${ !requestScope.recipe.isLikedBy(loggedUser) }">
				    	<form:form action="/Foodbook/like" class="form-inline form-inline-block">
							<input type="hidden" name="recipe.idRecipe" value="${requestScope.recipe.idRecipe}">
							<button type="submit" class="btn btn-success btn-xs">
								<span class="glyphicon glyphicon-thumbs-up"></span> Hmmm, Gostei!
							</button>
						</form:form>
			    </c:when>
			    <c:otherwise>
			    		<form:form action="/Foodbook/unlike" class="form-inline form-inline-block">
							<input type="hidden" name="recipe.idRecipe" value="${requestScope.recipe.idRecipe}">
							<button type="submit" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-thumbs-down"></span> Não sei se gostei tanto
							</button>
						</form:form>
			    </c:otherwise>
			</c:choose>
		
			<a class="btn btn-info btn-xs" href="/Foodbook/recipe/${ requestScope.recipe.idRecipe }">
				<span class="glyphicon glyphicon-ice-lolly-tasted"></span> Quero ver como faz
			</a>
		</div>
	</div>
	
	
	<span class="clearfix"></span>
</div>

<hr />