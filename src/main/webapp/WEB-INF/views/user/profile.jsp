	<jsp:include page="../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Perfil"/>
	</jsp:include>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<sec:authentication property="principal" var="loggedUser"/>

	<div class="row">

    	<div class="col-md-8 col-md-offset-2">
    		
   			<div class="text-center">
				<img class="img-circle center-block" src="http://placehold.it/200x200"  width="200px" alt="">
				<br />
				<h2>${ user.name }</h2>
			</div>
			
			<c:if test="${ user.idUser != loggedUser.idUser }">
			<c:choose>
				    <c:when test="${ isFollowing == true }">
				    <form:form servletRelativeAction="/unfollow" modelAttribute="user">
							<input type="hidden" name="idUser" value="${user.idUser }">
							<button type="submit" class="btn btn-danger btn-xs pull-right">Deixar de ver as receitas desse Chef!</button>
						</form:form>
				    </c:when>
				    <c:otherwise>
				    	<form:form servletRelativeAction="/follow" modelAttribute="user">
							<input type="hidden" name="idUser" value="${user.idUser }">
							<button type="submit" class="btn btn-success btn-xs pull-right">Ver receitas desse Chef!</button>
						</form:form>
				    </c:otherwise>
				</c:choose>
    		</c:if>
				
				
			<span class="clearfix"></span>
			<hr />
    		    	
    		<c:if test="${ empty recipes }">   					
	    		<c:choose>
				     <c:when test="${ user.idUser == loggedUser.idUser }">
				        <p class="text-center">
	    					Poxa você ainda não tem nenhuma receita publicada :'(
	    					<br>
	    					<a class="text-center" href="Foodbook/recipe/add">Que tal publicar uma aqui?</a>
    					</p>
				    </c:when>
				    <c:otherwise>
				        <p class="text-center">Poxa esse Chef ainda não tem nenhuma receita publicada :'(</p>
				    </c:otherwise>
				</c:choose>
    		</c:if>
    		
   			<c:forEach items="${recipes}" var="recipe">
    			<c:set var="recipe" value="${recipe}" scope="request"/>
    			<c:import url="../includes/logged/recipe-preview.jsp" />
		  	</c:forEach>
    	
		</div>	              
			
	</div>
      
<jsp:include page="../includes/logged/footer.jsp" />

