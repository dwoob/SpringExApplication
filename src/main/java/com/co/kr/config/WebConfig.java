package com.co.kr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration	
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @Description("Thymeleaf template resolver serving HTML")
    ClassLoaderTemplateResolver templateResolver() {
		
		var templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(true);
		templateResolver.setTemplateMode("html");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}

    @Bean
    @Description("Thymeleaf template engine with Spring integration")
    SpringTemplateEngine templateEngine() {
		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

    @Bean
    @Description("Thymeleaf view resolver")
    ViewResolver viewResolver() {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/upload/**").addResourceLocations("file:///C:/upload/");
	}
}