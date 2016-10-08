<jsp:include page="includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Timeline"/>
</jsp:include>

	<div class="row">

    	<div class="col-md-8">
			<jsp:include page="includes/logged/recipe-preview.jsp" />
			<jsp:include page="includes/logged/recipe-preview.jsp" />
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

