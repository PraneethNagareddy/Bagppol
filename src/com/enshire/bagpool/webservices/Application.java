package com.enshire.bagpool.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		
        SpringApplication.run(Application.class, args);
    }
	@Bean
    public FilterRegistrationBean contextFilterRegistrationBean() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new com.enshire.bagpool.filters.CORSFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        return filterRegBean;
    }
	@Bean
    public FilterRegistrationBean authorizationBean() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new com.enshire.bagpool.filters.AuthorizationFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/secure/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        return filterRegBean;
    }
}
