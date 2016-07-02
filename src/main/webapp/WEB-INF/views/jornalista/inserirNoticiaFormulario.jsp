<%@page import="java.time.LocalDate"%>
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
	      <li><a href="gerenciarNoticias">Gerenciar Notícias</a></li>
	      <li><a href="efetuarLogout">Sair</a></li>
	    </ul>
	  </div>
	</div>
	
	<div class="row">
  		<div class="medium-12 column">
			<form method="post" action="cadastrarNoticia">
				<label>Seção
					<select name="secaoId">
						<c:forEach var="secao" items="${secoes}">
							<option value="${secao.id}">${secao.titulo}</option>
						</c:forEach>
					</select>
				</label>
				<label>Título
					<input type="text" name="titulo" />
				</label>
				<br/>
				<label>Subtítulo
					<input type="text" name="subtitulo" />
				</label>
				<br/>
				<label>Texto
					<textarea name="texto" rows="15"></textarea>
				</label>
				<br/>
				<input type="hidden" value="<%=LocalDate.now().toString()%>" name="data" />
				<input type="hidden" value="${usuario.id}" name="usuarioId"/>
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