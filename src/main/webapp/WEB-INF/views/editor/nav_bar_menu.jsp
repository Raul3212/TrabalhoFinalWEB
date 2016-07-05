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
	  		<li><a href="gerenciarJornalistas">Gerenciar Jornalistas</a></li>
	      	<li><a href="removerNoticias">Remover Notícias</a></li>
	      	<li><a href="gerenciarSecoes">Gerenciar Seções</a></li>
	      	<li><a href="listarClassificados">Gerenciar Classificados</a></li>
	      	<li><a href="efetuarLogout">Sair</a></li>
	    </ul>
	</div>
</div>