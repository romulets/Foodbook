package com.foodbook;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class PersistanceContext {
 
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setJpaVendorAdapter(jpaVendorAdapter);
      em.setPackagesToScan("com.foodbook.model");
 
      System.out.println("BBBBBBBBBBB" + em);
      
      return em;
   }
   
   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
       HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
       hibernateJpaVendorAdapter.setShowSql(false);
       hibernateJpaVendorAdapter.setGenerateDdl(true);
       hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
       return hibernateJpaVendorAdapter;
   }
   
/*	@Bean
	public EntityManager entityManager() {
		EntityManager test = entityManagerFactory().getObject().createEntityManager();
		
		System.out.println("AAAAAAAAAAA" + test);
		
	    return test;
	}*/
 
   @Bean
   public DataSource dataSource(){
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/cadastroCliente");
	  dataSource.setUsername("root");
	  dataSource.setPassword("root");
	  return dataSource;
   }
 
   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
 
      return transactionManager;
   } 
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties additionalProperties() {
      Properties properties = new Properties();
      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
      return properties;
   }
	
}
