
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="../../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Editar Usuário"/>
	</jsp:include>

       <div class="col-md-8">
       		<h1>Editar E-mail</h1>
       		
       		<form:errors path="*" />
            <form:form modelAttribute="editUserEmailForm">
            	<div class="form-group">
            		<form:label path="email">E-mail:</form:label>
            		<form:input path="email" cssClass="form-control input-sm" />
					<form:errors path="email"/>
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
					<a href="/Foodbook/profile/edit/email" class="btn btn-default active"> Editar E-mail </a>
					<a href="/Foodbook/profile/edit/password" class="btn btn-default"> Editar Senha </a>
				</div>	
            </div>
		</div>

	<span class="clearfix"></span>

	<jsp:include page="../../includes/logged/footer.jsp" />