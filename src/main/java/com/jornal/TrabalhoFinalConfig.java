package com.jornal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.jornal.interceptor.RootInterceptor;

public class TrabalhoFinalConfig extends WebMvcAutoConfigurationAdapter{

	@Autowired
	private RootInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
	
}
