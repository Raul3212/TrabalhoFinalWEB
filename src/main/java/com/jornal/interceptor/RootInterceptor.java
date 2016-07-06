package com.jornal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jornal.model.Usuario;

@Component
public class RootInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.equals("/") ||
		   uri.endsWith("loginFormulario") ||
		   uri.endsWith("cadastrarLeitor") ||
		   uri.endsWith("cadastroLeitorFormulario") ||
		   uri.endsWith("listarClassificados") ||
		   uri.endsWith("verClassificado") ||
		   uri.endsWith("efetuarLogin") ||
		   uri.endsWith("mostraNoticia") ||
		   uri.endsWith("listarPorSecao") ||
		   uri.endsWith("home")){
			return true;
		}
		else{
			
			if(request.getSession().getAttribute("usuario") != null){
				
				Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
				
				if(uri.endsWith("gerenciarJornalistas") ||
						   uri.endsWith("editarJornalistaFormulario") ||
						   uri.endsWith("editarJornalista") ||
						   uri.endsWith("inserirJornalistaFormulario") ||
						   uri.endsWith("inserirJornalista") ||
						   uri.endsWith("removerJornalista") ||
						   uri.endsWith("gerenciarSecoes") ||
						   uri.endsWith("editarSecaoFormulario") ||
						   uri.endsWith("inserirSecaoFormulario") ||
						   uri.endsWith("inserirSecao") ||
						   uri.endsWith("removerSecao") ||
						   uri.endsWith("removerNoticias") ||
						   uri.endsWith("mostraNoticia") ||
						   uri.endsWith("removerNoticia")||
						   uri.endsWith("gerenciarClassificados") ||
						   uri.endsWith("inserirClassificadoFormulario") ||
						   uri.endsWith("inserirClassificado") ||
						   uri.endsWith("removerClassificado")||
						   uri.endsWith("venderClassificado") ||
						   uri.endsWith("efetuarLogout") ||
						   uri.endsWith("listarPorSecao")){
							if(usuario.getTipo() == Usuario.EDITOR){
								return true;
							}
				}
				
				if(uri.endsWith("gerenciarNoticias") ||
						uri.endsWith("mostraNoticia") ||
						   uri.endsWith("removerNoticia") ||
						   uri.endsWith("listarPorSecao") ||
						   uri.endsWith("editarNoticia") ||
						   uri.endsWith("inserirNoticiaFormulario") ||
						   uri.endsWith("cadastrarNoticia") ||
						   uri.endsWith("editarNoticiaFormulario") ||
						   uri.endsWith("mostraNoticia") ||
						   uri.endsWith("editarNoticia") ||
						   uri.endsWith("efetuarLogout")){
						   	if(usuario.getTipo() == Usuario.JORNALISTA){
								return true;
							}
				}
				
				if(uri.endsWith("cadastroLeitorFormulario") ||
						   uri.endsWith("cadastrarLeitor") ||
						   uri.endsWith("listarPorSecao") ||
						   uri.endsWith("mostraNoticia") ||
						   uri.endsWith("publicarComentario") ||
						   uri.endsWith("realizarOferta") ||
						   uri.endsWith("efetuarLogout")){
							if(usuario.getTipo() == Usuario.LEITOR){
								return true;
							}
				}
			}
			
		}
		
		request.getSession().invalidate();
		response.sendRedirect("/");
		return false;
		
	}
	
}
