package com.example.MultiDB.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.example.MultiDB.primary",
		entityManagerFactoryRef = "primaryEntityManagerFactory",
		transactionManagerRef = "primaryTransactionManager"
		)
public class SecondaryDbConfig {

	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
		// Configure and return the primary DataSource
	}	
}
