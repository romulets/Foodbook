<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Foodbook - Timeline</title>
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
	      <a class="navbar-brand" href="#">Foodbook</a>
	    </div>
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Timeline</a></li>
	        <li><a href="#">Recomendações</a></li>
	        <li><a href="#">Nova Receita</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/Foodbook/logout">Sair</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>


    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <!-- Blog Entries Column -->
            <div class="col-md-8">

                
                <div>
                	<h2>
	                    <a href="#">Atum com Frango Assado</a>
	                </h2>
	                <p class="lead">
	                    por <a href="/user/">Felipe Pereira</a>
	                </p>
	                <p><span class="glyphicon glyphicon-time"></span> Postado em 26/05/2016 às 18:30</p>
	                <hr>
	                <img class="img-responsive" src="http://placehold.it/900x300" alt="">
	                <hr>
	                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore, veritatis, tempora, necessitatibus inventore nisi quam quia repellat ut tempore laborum possimus eum dicta id animi corrupti debitis ipsum officiis rerum.</p>
	                <a class="btn btn-primary" href="#">Leia Mais <span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>

				<hr />

				<div>
                	<h2>
	                    <a href="#">Atum com Frango Assado</a>
	                </h2>
	                <p class="lead">
	                    por <a href="/user/">Felipe Pereira</a>
	                </p>
	                <p><span class="glyphicon glyphicon-time"></span> Postado em 26/05/2016 às 18:30</p>
	                <hr>
	                <img class="img-responsive" src="http://placehold.it/900x300" alt="">
	                <hr>
	                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore, veritatis, tempora, necessitatibus inventore nisi quam quia repellat ut tempore laborum possimus eum dicta id animi corrupti debitis ipsum officiis rerum.</p>
	                <a class="btn btn-primary" href="#">Leia Mais <span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>

                <hr>

                <!-- Pager -->
                <ul class="pager">
                    <li class="previous">
                        <a href="#">&larr; Antigas</a>
                    </li>
                    <li class="next">
                        <a href="#">Novas &rarr;</a>
                    </li>
                </ul>

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">

                <!-- Blog Search Well -->
                <div class="well">
					
					<div class="text-center">
						<img class="img-circle center-block" src="http://placehold.it/200x200"  width="100px" alt="">
						<br />
						<p>${ currentUser.name }</p>
					</div>	
	

                    <!-- <h4>Buscar Receitas</h4>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">
                                <span class="glyphicon glyphicon-search"></span>
                        </button>
                        </span>
                    </div> -->
                    <!-- /.input-group -->
                </div>

            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Foodbook</p>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="/Foodbook/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/Foodbook/resources/js/bootstrap.min.js"></script>

</body>

</html>
