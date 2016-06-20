<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <link rel="stylesheet" href="css/foundation.css">
    <link rel="stylesheet" href="css/app.css">
</head>
<body>
	
	<div class="top-bar">
	  <div class="top-bar-left">
	    <ul class="dropdown menu" data-dropdown-menu>
	      <li class="menu-text">QNews</li>
	      <li><a href="/">Home</a></li>
	    </ul>
	  </div>
	  <div class="top-bar-right">
	    <ul class="menu">
	      <li><input type="search" placeholder="Buscar"></li>
	      <li><button type="button" class="button">Buscar</button></li>
	      <li><a href="loginFormulario">Entrar</a></li>
	    </ul>
	  </div>
	</div>
	
	<div class="row">
  		<div class="medium-4 column">
			<form method="post" action="cadastrarLeitor">
				<label>Nome
					<input type="text" name="nome">
				</label>
				<br/>
				<label>E-mail
					<input type="email" name="email">
				</label>
				<br/>
				<label>Login
					<input type="text" name="login">
				</label>
				<br/>
				<label>Senha
		  			<input type="password" aria-describedby="passwordHelpText" name="senha">
				</label>
				<br/>
				<input type="hidden" value="1" name="tipo"/>
				<label>
					<input class="success buttom" type="submit" value="Cadastrar">
				</label>
			</form>
			
		</div>
	</div>
	
	<script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
</body>
</html>