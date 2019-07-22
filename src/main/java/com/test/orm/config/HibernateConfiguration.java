package com.test.orm.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	
	private static LocalSessionFactoryBean sessionFactory = null;
	
	
	@Value(value = "${db.driver}")
	private String driver;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	
	@Value("${spring.jpa.properties.hibernate.show-sql}")
	private String showsql;
	
	@Value("${spring.jpa.properties.hibernate.ddl-auto}")
	private String ddlAuto;
	
	@Value("${db.entity.basePackages}")
	private String entityPackages;
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		if(sessionFactory == null) {
			sessionFactory =new LocalSessionFactoryBean();
			sessionFactory.setDataSource(getDataSource());
			sessionFactory.setPackagesToScan(entityPackages);
			
			Properties properties = new Properties();
			properties.setProperty("hibernate.dialect", dialect);
			properties.setProperty("hibernate.show_sql", showsql);
			properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
			properties.setProperty("spring.jpa.hibernate.naming.physical-strategy","org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
			properties.setProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", "false");
			sessionFactory.setHibernateProperties(properties);
		}
		
		
		return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
	
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager txnManager = new HibernateTransactionManager();
		
		txnManager.setSessionFactory(getSessionFactory().getObject());
		
		return txnManager;
	}
	
	
	

}
