<div class="top-bar">
	<div class="top-bar-left">
		<ul class="dropdown menu" data-dropdown-menu>
			
			
	    	<li class="menu-text">
	    		<c:if test="${not empty usuario.imgPerfil}">
					<img class="imgPerfil" src="<c:url value='/resources/img/perfil/${usuario.imgPerfil}'></c:url>"/>
	    		</c:if>
	    		${usuario.nome}
	    	</li>
	      	<c:forEach var="secao" items="${secoes}">
	      		<li><a href="listarPorSecao?secaoId=${secao.id}" title="${secao.descricao}">${secao.titulo}</a></li>
	      	</c:forEach>
	    </ul>
	</div>
	<div class="top-bar-right">
	   	<ul class="menu">
	   		<li><a href="listarClassificados">Classificados</a></li>
	   		<li><a href="efetuarLogout">Sair</a></li>
	   	</ul>
	</div>
</div>