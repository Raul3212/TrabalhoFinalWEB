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
    
    <div class="top-bar">
	  <div class="top-bar-left">
	    <ul class="dropdown menu" data-dropdown-menu>
	      <li class="menu-text">${usuario.nome}</li>
	      <c:forEach var="secao" items="${secoes}">
	      	<li><a href="listarPorSecao?secaoId=${secao.id}" title="${secao.descricao}">${secao.titulo}</a></li>
	      </c:forEach>
	    </ul>
	  </div>
	  <div class="top-bar-right">
	    <ul class="menu">
	      <li><a href="efetuarLogout">Sair</a></li>
	    </ul>
	  </div>
	</div>
    
    <div class="row">
  		<div class="medium-12 column">
  			<div class="callout clearfix">
			 	<h2><b>${noticia.titulo}</b></h2><br/>
			 	<i>${noticia.subtitulo}</i><br/>
			 	<i>${noticia.data}</i><br>
			 	<p>${noticia.texto}</p><br>
			 	<hr/>
			 	<c:forEach var = "comentario" items="${comentarios}">
			 		<b>${comentario.usuario.nome} - ${comentario.usuario.email}</b>
			 		<p>${comentario.texto}</p>	
			 	</c:forEach>
			 	<hr/>
			 	<form method="post" action="publicarComentario">
			 		<b>Comente:</b>
			 		<br/>
			 		<textarea name="texto" rows="5" cols="10"></textarea>
			 		<input type="hidden" name="noticiaId" value="${noticia.id}"/>
			 		<input type="hidden" name="usuarioId" value="${usuario.id}"> 
			 		<input type="submit" value="Enviar">
			 	</form>
			 		
			</div>
		</div>
  	</div>
    
    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>