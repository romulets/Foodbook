	<jsp:include page="../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Seguidores"/>
	</jsp:include>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">

    	<div class="col-md-8 col-md-offset-2">
    		
    		<c:set var="user" value="${user}" scope="request"/>
    		<c:set var="active" value="followers" scope="request"/>
			<c:import url="../includes/logged/profile-header.jsp" />
    		    	
    		<c:forEach items="${user.followers}" var="follower">
    			<div class="col-md-6 margin-bottom">
	    			<img class="img-circle" src="http://placehold.it/50x50"  width="50px" alt="">
	    			<strong class="margin-left">
	    				<a href="/Foodbook/profile/${follower.idUser}">${ follower.name }</a>
	    			</strong>
    			</div>
		  	</c:forEach>
    		
		</div>	              
			
	</div>
      
<jsp:include page="../includes/logged/footer.jsp" />

