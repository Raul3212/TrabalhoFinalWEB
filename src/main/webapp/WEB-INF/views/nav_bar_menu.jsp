<div class="top-bar">
	<div class="top-bar-left">
		<ul class="dropdown menu" data-dropdown-menu>
	    	<li class="menu-text">QNews</li>
	      	<li><a href="/" title="Home">Home</a></li>
	      	<c:forEach var="secao" items="${secoes}">
	      		<li><a href="listarPorSecao?secaoId=${secao.id}" title="${secao.descricao}">${secao.titulo}</a></li>
	      	</c:forEach>
	    </ul>
	</div>
	<div class="top-bar-right">
		<ul class="menu">
	    	<li><a href="loginFormulario">Entrar</a></li>
	    </ul>
	</div>
</div>