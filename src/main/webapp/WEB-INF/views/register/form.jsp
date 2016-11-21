
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="../includes/guest/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Novo Registro"/>
	</jsp:include>

    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="container-fluid">
	            <h4 class="text-center text-success">Cadastro Foodbook</h4>
	            <hr />
	            
	            <form:errors path="*" />
	            <form:form modelAttribute="register" enctype="multipart/form-data">
	            	<div class="form-group">
	            		<form:label path="user.name">Nome:</form:label>
	            		<form:input path="user.name" cssClass="form-control input-sm" />
						<form:errors path="user.name"/>
	            	</div>
	            
	            	<div class="form-group">
	            		<form:label path="user.login">E-mail:</form:label>
	            		<form:input path="user.login" cssClass="form-control input-sm" />
						<form:errors path="user.login"/>
	            	</div>
	            	
	            	<div class="form-group">
	            		<label for="photo">Imagem de usuário</label>
	            		<input type="file" name="photo">
	            	</div>
	            	
	            	<div class="row">
	            		<div class="col-md-6">
	            			<div class="form-group">
			            		<form:label path="user.password">Senha:</form:label>
			            		<form:password path="user.password" cssClass="form-control input-sm" />
								<form:errors path="user.password"/>
			            	</div>
	            		</div>
	            		
	            		<div class="col-md-6">
	            			<div class="form-group">
			            		<form:label path="passwordConfirmation">Confirmação da Senha:</form:label>
			            		<form:password path="passwordConfirmation" cssClass="form-control input-sm" />
								<form:errors path="passwordConfirmation"/>
		            		</div>
	            		</div>
	            	</div>
	            	
	            	<div class="row">
	            	
	            		<div class="col-md-8">
	            			<div class="form-group">
			            		<form:label path="user.address.city">Cidade:</form:label>
			            		<form:input path="user.address.city" cssClass="form-control input-sm" />
								<form:errors path="user.address.city"/>
			            	</div>
	            		</div>
	            		
	            		<div class="col-md-4">
		            		<div class="form-group">
			            		<form:label path="user.address.state">Estado:</form:label>
			            		<form:input path="user.address.state" cssClass="form-control input-sm" />
								<form:errors path="user.address.state"/>
			            	</div>
	            		</div>	            	
	            	</div>
	            	
	            	<div class="form-group">
	            		<form:label path="user.address.country">País:</form:label>
	            		<form:input path="user.address.country" cssClass="form-control input-sm" />
						<form:errors path="user.address.country"/>
	            	</div>
	            	
	            	<span class="group-btn">   
	            		<input type="submit" value="Registrar!" class="btn btn-primary btn-md btn-block" />  
	            	</span>
	            </form:form>
	            	
	            <br />
	            <p class="text-warning text-center">
	            	Já possui cadastro?
	            	<br>
	            	<a href="/Foodbook">Faça login aqui!</a>
	            </p>
            </div>
        </div>
	</div>

	<jsp:include page="../includes/guest/footer.jsp" />