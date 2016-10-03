<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" 
		   uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Foodbook - Cadastro</title>
<link href="/Foodbook/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/Foodbook/resources/css/blog-home.css" rel="stylesheet">
 
<script src="/Foodbook/resources/js/jquery.js"></script>
<script src="/Foodbook/resources/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="container-fluid">
	            <h4 class="text-center text-success">Cadastro Foodbook</h4>
	            <hr />
	            
	            <form:errors path="*" />
	            <form:form modelAttribute="register">
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
</div>
</body>
</html>