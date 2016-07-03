<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <%@include file="nav_bar_menu.jsp" %>
	
	<div class="row">
		<div class="medium-12 column">
			<form method="post" action="editarJornalista">
				<label>Nome
					<input type="text" name="nome" value="${jornalista.nome}">
				</label>
				<br/>
				<label>E-mail
					<input type="email" name="email" value="${jornalista.email}">
				</label>
				<br/>
				<label>Login
					<input type="text" name="login" value="${jornalista.login}">
				</label>
				<br/>
				<label>Senha
		  			<input type="password" aria-describedby="passwordHelpText" name="senha" value="${jornalista.senha}">
				</label>
				<br/>
				<input type="hidden" value="${jornalista.id}" name="id"/>
				<input type="hidden" value="2" name="tipo"/>
				<label>
					<input class="success buttom" type="submit" value="Salvar">
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