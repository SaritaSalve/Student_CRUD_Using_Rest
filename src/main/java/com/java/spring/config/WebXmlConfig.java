package com.java.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlConfig implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Spring container creation
		AnnotationConfigWebApplicationContext  applicationContext=new AnnotationConfigWebApplicationContext();
		
		applicationContext.register(SpringConfig.class);  	// Register Spring configuration with container
		applicationContext.setServletContext(servletContext); // set servlet context to the container
		
		DispatcherServlet dispatcherServlet= new DispatcherServlet(applicationContext);  //Dispatcher servlet object creation 
		
		ServletRegistration.Dynamic customServlet=servletContext.addServlet("myDispatcher", dispatcherServlet);   //assign dispatchr servlet name and class to DispatcherRegistration interface
		customServlet.setLoadOnStartup(1);
		customServlet.addMapping("/");
	}

}
