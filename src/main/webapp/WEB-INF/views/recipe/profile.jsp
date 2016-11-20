<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - ${ recipe.name }" />
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="loggedUser"/>

<div class="col-md-8 col-md-offset-2">

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
     	
     	<c:if test="${ !recipe.status }">
     		<small class="text-mutted"><i>Não publicado</i></small>
		</c:if>	     	
 	</h2>
 	
	<h6>
	     <span class="glyphicon glyphicon-time"></span> Postado por <a href="/Foodbook/profile/${ recipe.publishedBy.idUser }">
	     		${ recipe.publishedBy.name }.
     		</a> em 
     		
     		<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${recipe.publicationDate}" />	     	 
	</h6>

	<img class="img-responsive center-block" src="http://placehold.it/900x300" alt="">
	
	<div class="row">
		<div class="panel">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
						<p>
							<c:if test="${ recipe.likedBy.size() == 0 }">
								Nenhum chefe gostou dessa receita ainda :/
							</c:if>
							<c:if test="${ recipe.likedBy.size() == 1 }">
								<span class="badge">${ recipe.likedBy.size()  }</span> Chefe Gostou dessa receita!
							</c:if>
							<c:if test="${ recipe.likedBy.size() > 1 }">
								<span class="badge">${ recipe.likedBy.size()  }</span> Chefes Gostaram dessa receita!
							</c:if>
						</p>
					</div>
				
					<div class="col-md-6 text-right">
						<c:choose>
						    <c:when test="${ !recipe.isLikedBy(loggedUser) }">
							    	<form:form action="/Foodbook/like" class="form-inline form-inline-block">
										<input type="hidden" name="recipe.idRecipe" value="${recipe.idRecipe}">
										<button type="submit" class="btn btn-success btn-xs">
											<span class="glyphicon glyphicon-thumbs-up"></span> Hmmm, Gostei!
										</button>
									</form:form>
						    </c:when>
						    <c:otherwise>
						    		<form:form action="/Foodbook/unlike" class="form-inline form-inline-block">
										<input type="hidden" name="recipe.idRecipe" value="${recipe.idRecipe}">
										<button type="submit" class="btn btn-danger btn-xs">
											<span class="glyphicon glyphicon-thumbs-down"></span> Não sei se gostei tanto
										</button>
									</form:form>
						    </c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	
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