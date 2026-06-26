package com.example.MultiDB.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.example.MultiDB.secondary",
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager"
		)
public class SecondaryDbConfig {

	@Bean(name="secondaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
		// Configure and return the primary DataSource
	}	
	
	@Bean(name="secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("secondaryDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.example.MultiDB.secondary")
				.persistenceUnit("secondary")
				.build();
		
	}
	
	@Bean(name="secondaryTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
}
