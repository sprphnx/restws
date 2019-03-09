package com.sprphnx.restws.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(

		entityManagerFactoryRef = "vybhaEntityManagerFactory", transactionManagerRef = "vybhaTransactionManager", basePackages = {
				"com.sprphnx.restws.repository.vybha" }

)
public class VybhaDSConfiguration {

	 @Primary
	 @Bean(name = "vybhaDataSource")
	 @ConfigurationProperties(prefix = "spring.datasource")
	 public HikariDataSource vybhaDataSource() {
	  return DataSourceBuilder.create().type(HikariDataSource.class).build();
	 }
	 
	 @Primary
	 @Bean(name = "vybhaEntityManagerFactory")
	 public LocalContainerEntityManagerFactoryBean
	 vybhaEntityManagerFactory(
	  EntityManagerFactoryBuilder builder,
	  @Qualifier("vybhaDataSource") DataSource vybhaDataSource
	 ) {
	  return builder
	   .dataSource(vybhaDataSource)
	   .packages("com.sprphnx.restws.entity.vybha")
	   .persistenceUnit("vybha")
	   .build();
	 }
	 
	 @Bean(name = "vybhaTransactionManager")
	 public PlatformTransactionManager vybhaTransactionManager(
	  @Qualifier("vybhaEntityManagerFactory") EntityManagerFactory vybhaEntityManagerFactory
	 ) {
	  return new JpaTransactionManager(vybhaEntityManagerFactory);
	 }

	
}
