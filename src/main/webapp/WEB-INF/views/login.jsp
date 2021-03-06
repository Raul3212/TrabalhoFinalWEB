<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <%@include file="css_include.jsp" %>
</head>
<body>
	
	<%@include file="nav_bar_menu.jsp" %>
	
	<div class="row">
  		<div class="medium-4 column">
			<br/>
			<form method="post" action="efetuarLogin">
				<label>Tipo de usu�rio
				  <select name="tipo">
				    <option value="1">Leitor</option>
				    <option value="2">Jornalista</option>
				    <option value="3">Editor</option>
				  </select>
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
				<label>
					<input class="success buttom" type="submit" value="Entrar">
				</label>
			</form>
			<br/>
			<a href="cadastroLeitorFormulario">Ainda n�o possui login? Cadastre-se!</a>
			
		</div>
	</div>
	
	<script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
</body>
</html>