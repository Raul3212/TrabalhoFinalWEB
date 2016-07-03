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
	      	<li><a href="#" title="${secao.descricao}">${secao.titulo}</a></li>
	      </c:forEach>
	    </ul>
	  </div>
	  <div class="top-bar-right">
	    <ul class="menu">
	      <li><a href="#">Gerenciar Notícias</a></li>
	      <li><a href="efetuarLogout">Sair</a></li>
	    </ul>
	  </div>
	</div>
	
	<div class="row">
		<a class="succes button float-right" href="inserirNoticiaFormulario">Nova Notícia</a>
  		<div class="medium-12 column">
			<c:forEach var="noticia" items="${noticias}">
				<div class="callout clearfix">
			  		<a class="alert button float-right" href="removerNoticia?id=${noticia.id}">Remover</a>
					<a class="warning button float-right" href="editarNoticiaFormulario?id=${noticia.id}">Editar</a>
			  		<b>${noticia.titulo}</b>
					<br/>
					<i>${noticia.subtitulo}</i>
				</div>
			</c:forEach>
		</div>
	</div>
	
    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>