package com.example.demo.configure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory", 
						transactionManagerRef = "productTransactionManager", basePackages = {
		"com.example.demo.product.repo" })
public class DBTwoConfiguration {
	@Bean(name = "productDataSource")
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource productDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("productDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.example.demo.product.model").build();
	}

	@Bean(name = "productTransactionManager")
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManager) {
		return new JpaTransactionManager(productEntityManager);
	}
}
