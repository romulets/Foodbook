	<jsp:include page="../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Seguidores"/>
	</jsp:include>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">

    	<div class="col-md-8 col-md-offset-2">
    		<c:set var="user" value="${user}" scope="request"/>
    		<c:set var="active" value="following" scope="request"/>
			<c:import url="../includes/logged/profile-header.jsp" />
    		    	
    		<c:forEach items="${user.following}" var="following">
    			<div class="col-md-6 margin-bottom">
	    			<img class="img-circle" src="${ following.getPhotoPath() }"  width="50px" alt="">
	    			<strong class="margin-left">
	    				<a href="/Foodbook/profile/${following.idUser}">${ following.name }</a>
	    			</strong>
    			</div>
		  	</c:forEach>
    		
		</div>	              
			
	</div>
      
<jsp:include page="../includes/logged/footer.jsp" />

