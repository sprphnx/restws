package com.sprphnx.restws.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "hrEntityManagerFactory", transactionManagerRef = "hrTransactionManager", basePackages = {
		"com.sprphnx.restws.repository.hr" })
public class HRDSConfiguration {

	@Bean(name = "hrDataSource")
	@ConfigurationProperties(prefix = "hr.datasource")
	public DataSource hrDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "hrEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean hrEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("hrDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.sprphnx.restws.entity.hr").persistenceUnit("hr").build();
	}

	@Bean(name = "hrTransactionManager")
	public PlatformTransactionManager hrTransactionManager(
			@Qualifier("hrEntityManagerFactory") EntityManagerFactory hrEntityManagerFactory) {
		return new JpaTransactionManager(hrEntityManagerFactory);
	}

}
