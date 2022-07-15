package com.example.ch01_RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private MonitorInterceptor monitorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(monitorInterceptor).addPathPatterns("/**");
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
