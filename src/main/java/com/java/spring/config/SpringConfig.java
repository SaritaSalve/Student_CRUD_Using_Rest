package com.java.spring.config;


import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.java.spring.Entities.ProductInfo;
import com.java.spring.Entities.Student_Info;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.java.spring.*")
public class SpringConfig {
	static {
		System.out.println("Config class loaded.....");
	}
  @Bean
  public BasicDataSource getDataSource() {
	  BasicDataSource dataSource= new BasicDataSource();
	  dataSource.setUsername("root");
	  dataSource.setPassword("root");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/spring_student_data");
	  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean getFactoryBean() {
	  LocalSessionFactoryBean factoryBean= new LocalSessionFactoryBean();
	  factoryBean.setDataSource(getDataSource());
	  factoryBean.setAnnotatedClasses(Student_Info.class);
	  
	  Properties props= new Properties();
	  props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	  props.put(Environment.HBM2DDL_AUTO, "update");
	  props.put(Environment.SHOW_SQL, true);
	  factoryBean.setHibernateProperties(props);
return factoryBean;
  }
  
  @Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/pages/");	//add_employee.jsp
	    bean.setSuffix(".jsp");
	    return bean;
	}
}
