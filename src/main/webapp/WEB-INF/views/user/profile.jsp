	<jsp:include page="../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Perfil"/>
	</jsp:include>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">

    	<div class="col-md-8 col-md-offset-2">
    		
    		<c:set var="user" value="${user}" scope="request"/>
    		<c:set var="active" value="profile" scope="request"/>
			<c:import url="../includes/logged/profile-header.jsp" />
    		    	
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

