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
  			<br/>
  			<div class="callout clearfix">
			 	<center>
			 		<h2><b>${noticia.titulo}</b></h2>
			 		<i>${noticia.subtitulo}</i><br>
			 		<p style="font-size:12px;">${noticia.data}<p/>
			 	</center>
			 	
			 	<p align="justify">${noticia.texto}</p><br>
			 	<p align="right"><i>por ${noticia.usuario.nome}</i></p>
			 	<hr/>
			 	<c:forEach var = "comentario" items="${comentarios}">
			 		<b>${comentario.usuario.nome} - ${comentario.usuario.email}</b>
			 		<p>${comentario.texto}</p>	
			 	</c:forEach>
			 	<hr/>
			 	<p>Entre para comentar.</p>	
			</div>
		</div>
  	</div>
    
    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>