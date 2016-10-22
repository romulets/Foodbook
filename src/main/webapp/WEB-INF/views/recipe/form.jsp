
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="../includes/logged/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Formulário de Receita"/>
	</jsp:include>

    <div class="row">
        <div class="col-md-offset-2 col-md-8">
            <div class="container-fluid">
	            <h4 class="text-success">Formulário de Receita</h4>
	            <hr />
	            
	            <form:errors path="*" />
	            <form:form modelAttribute="recipe">
	            	<div class="form-group">
	            		<form:label path="name">Nome:</form:label>
	            		<form:input path="name" cssClass="form-control input-sm" />
						<form:errors path="name"/>
	            	</div>
	            	
	            	<div class="form-group">
	            		<form:label path="description">Descrição:</form:label>
	            		<form:textarea path="description" cssClass="form-control input-sm" />
						<form:errors path="description"/>
	            	</div>
	            	
	            	<div class="checkbox">
	            		<form:label path="status">
	            			<form:checkbox path="status"/> Publicada
	            		</form:label>
						<form:errors path="status"/>
	            	</div>	
	            	        	
	            	<span class="group-btn">   
	            		<input type="submit" value="Salvar" class="btn btn-primary btn-md btn-block" />  
	            	</span>
	            </form:form>
            </div>
        </div>
	</div>

	<jsp:include page="../includes/logged/footer.jsp" />