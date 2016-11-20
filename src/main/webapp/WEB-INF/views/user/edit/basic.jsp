
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="../../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Editar Usuário"/>
	</jsp:include>

       <div class="col-md-8">
       		<h1>Editar Dados básicos</h1>
       		
       		<form:errors path="*" />
            <form:form modelAttribute="editUserBasicForm">
            	<div class="form-group">
            		<form:label path="name">Nome:</form:label>
            		<form:input path="name" cssClass="form-control input-sm" />
					<form:errors path="name"/>
            	</div>
           
            	<div class="row">
            	
            		<div class="col-md-8">
            			<div class="form-group">
		            		<form:label path="address.city">Cidade:</form:label>
		            		<form:input path="address.city" cssClass="form-control input-sm" />
							<form:errors path="address.city"/>
		            	</div>
            		</div>
            		
            		<div class="col-md-4">
	            		<div class="form-group">
		            		<form:label path="address.state">Estado:</form:label>
		            		<form:input path="address.state" cssClass="form-control input-sm" />
							<form:errors path="address.state"/>
		            	</div>
            		</div>	            	
            	</div>
            	
            	<div class="form-group">
            		<form:label path="address.country">País:</form:label>
            		<form:input path="address.country" cssClass="form-control input-sm" />
					<form:errors path="address.country"/>
            	</div>
            	
            	<span class="group-btn">   
            		<input type="submit" value="Salvar" class="btn btn-success btn-md btn-block" />  
            	</span>
            </form:form>
       </div>

		<div class="col-md-4">
			<div class="well">
				<div class="btn-group-vertical btn-group-block">
					<a href="/Foodbook/profile/edit/basic" class="btn btn-default active"> Editar Dados básicos </a>
					<a href="/Foodbook/profile/edit/email" class="btn btn-default"> Editar E-mail </a>
					<a href="/Foodbook/profile/edit/password" class="btn btn-default"> Editar Senha </a>
				</div>	
            </div>
		</div>

	<span class="clearfix"></span>

	<jsp:include page="../../includes/logged/footer.jsp" />