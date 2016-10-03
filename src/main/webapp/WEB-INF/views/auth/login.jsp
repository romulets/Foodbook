<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" 
		   uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Foodbook - Login</title>
<link href="/Foodbook/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/Foodbook/resources/css/blog-home.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <div class="container-fluid">
	            <h4 class="text-center text-success">Seja bem vindo ao Foodbook!</h4>
	            <hr />
	            
	            <!--<form:errors path="*" />-->
	            <form:form servletRelativeAction="/">
	            	<div class="form-group">
	            		<label for="login">E-mail:</label>
	            		<input type="text" name="username" class="form-control input-sm" />
						<!--<form:errors path="login"/>-->
	            	</div>
	            	
	            	<div class="form-group">
	            		<label for="password">Senha:</label>
	            		<input type="password" name="password" class="form-control input-sm" />
						<!--<form:errors path="password"/>-->
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
</div>

<script src="/Foodbook/resources/js/jquery.js"></script>
<script src="/Foodbook/resources/js/bootstrap.min.js"></script>
</body>
</html>