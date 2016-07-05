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
		   uri.endsWith("cadastroLeitorFormulario") ||
		   uri.endsWith("home")){
			return true;
		}
		else{
			if(request.getSession().getAttribute("usuario") != null){
				return true;
			}
			
		}
		return false;
		
	}
	
}
