
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="../../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Editar Usuário"/>
	</jsp:include>

       <div class="col-md-8">
       		<h1>Editar Senha</h1>
       		
       		<form:errors path="*" />
            <form:form modelAttribute="editUserPasswordForm">
            	<div class="form-group">
            		<form:label path="password">Senha:</form:label>
            		<form:password path="password" cssClass="form-control input-sm" />
					<form:errors path="password"/>
            	</div>
           
            	<div class="form-group">
            		<form:label path="passwordConfirmation">Confirmação da Senha:</form:label>
            		<form:password path="passwordConfirmation" cssClass="form-control input-sm" />
					<form:errors path="passwordConfirmation"/>
            	</div>
            	
            	<span class="group-btn">   
            		<input type="submit" value="Salvar" class="btn btn-success btn-md btn-block" />  
            	</span>
            </form:form>
       </div>

		<div class="col-md-4">
			<div class="well">
				<div class="btn-group-vertical btn-group-block">
					<a href="/Foodbook/profile/edit/basic" class="btn btn-default"> Editar Dados básicos </a>
					<a href="/Foodbook/profile/edit/email" class="btn btn-default"> Editar E-mail </a>
					<a href="/Foodbook/profile/edit/password" class="btn btn-default active"> Editar Senha </a>
				</div>	
            </div>
		</div>

	<span class="clearfix"></span>

	<jsp:include page="../../includes/logged/footer.jsp" />