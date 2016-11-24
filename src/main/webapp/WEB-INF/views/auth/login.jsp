
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<fmt:setBundle basename="messages" />
	

	<jsp:include page="../includes/guest/header.jsp">
	    <jsp:param name="pageTitle" value="Foodbook - Login"/>
	</jsp:include>

        <div class="col-md-offset-4 col-md-4">
            <div class="container-fluid">
	            <h4 class="text-center text-success">Seja bem vindo ao Foodbook!</h4>
	            <hr />
	            
	            <c:if test="${param.error != null}">
				    <div class="alert alert-danger">
				        <spring:message code="message.badCredentials">   
				        </spring:message>
				    </div>
				</c:if>
				
				<c:if test="${param.logSucc == true}">
				    <div class="alert alert-success">
				    <spring:message code="message.logoutSucc">    
				        </spring:message>
				    </div>
				</c:if>
	            
	            <c:if test="${param.regSucc == true}">
				    <div class="alert alert-danger">
				    <spring:message code="message.regSucc">    
				        </spring:message>
				    </div>
				</c:if>
				
				<c:if test="${param.regError == true}">
				    <div class="alert alert-danger">
				        <spring:message code="message.regError">   
				        </spring:message>
				    </div>
				</c:if>
	            
	            <form:form servletRelativeAction="/">
	            	<div class="form-group">
	            		<label for="login">E-mail:</label>
	            		<input type="text" name="username" class="form-control input-sm" />
	            		<fmt:message key="message.username" var="noUser" />
	            	</div>
	            	
	            	<div class="form-group">
	            		<label for="password">Senha:</label>
	            		<input type="password" name="password" class="form-control input-sm" />
	            		<fmt:message key="message.password" var="noPass" />
	            	</div>
	            	
	            	<span class="group-btn">   
	            		<input type="submit" value="Entrar" class="btn btn-primary btn-md btn-block" />  
	            	</span>
	            </form:form>
	            	
	            <br />
	            <p class="text-warning text-center">
	            	Ainda não possui cadastro?
	            	<br>
	            	<a href="register">Cadastre-se aqui!</a>
	            </p>
            </div>
        </div>
	</div>
	
	<jsp:include page="../includes/guest/footer.jsp" />