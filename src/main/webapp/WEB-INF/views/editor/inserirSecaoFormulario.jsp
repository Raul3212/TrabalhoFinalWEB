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
			<form method="post" action="inserirSecao">
				<label>Titulo
					<input type="text" name="titulo">
				</label>
				<br/>
				<label>Descrição
					<input type="text" name="descricao">
				</label>
				<br/>
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