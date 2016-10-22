<jsp:include page="includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Timeline"/>
</jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal" var="currentUser"/>

	<div class="row">

    	<div class="col-md-8">
    		<c:if test="${ empty recipes }">
    			<p class="text-center">
					Poxa, nem você nem outro chef de sua rede tem alguma receita publicada :'(
					<br>
					<a class="text-center" href="Foodbook/recipe/add">Que tal publicar uma aqui?</a>
				</p>
    		</c:if>
    	
			<c:forEach items="${recipes}" var="recipe">
    			<c:set var="recipe" value="${recipe}" scope="request"/>
    			<c:import url="includes/logged/recipe-preview.jsp" />
		  	</c:forEach>
		</div>	              
			
		
        <div class="col-md-4">
			<div class="well">
				<div class="text-center">
					<img class="img-circle center-block" src="http://placehold.it/200x200"  width="100px" alt="">
					<br />
					<p><a href="/Foodbook/profile">${ currentUser.name }</a></p>
				</div>	
            </div>
		</div>
	</div>
      
<jsp:include page="includes/logged/footer.jsp" />

