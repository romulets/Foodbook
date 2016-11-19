<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${ param.pageTitle }</title>
    <link href="/Foodbook/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/Foodbook/resources/css/blog-home.css" rel="stylesheet">

    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/Foodbook/timeline">Foodbook</a>
	    </div>
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="/Foodbook/timeline">Timeline</a></li>
	        <li><a href="/Foodbook/recipe/add">Nova Receita</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/Foodbook/logout">Sair</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>


    <!-- Page Content -->
    <div class="container">