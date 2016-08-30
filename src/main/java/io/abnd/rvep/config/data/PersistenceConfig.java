package io.abnd.rvep.config.data;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
// @EnableJpaRepositories({
// 		"io.abnd.rvep.event.dao",
// 		"io.abnd.rvep.security.dao",
// 		"io.abnd.rvep.user.dao"
// })
// @EnableTransactionManagement
// public class PersistenceConfig {
//
// 	/**
// 	 *
// 	 * @return dataSource
// 	 */
// 	@Bean
// 	public DataSource dataSource() {
// 		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
// 		dataSource.setUrl("jdbc:mysql://mariadb:3306/rvep");
// 		dataSource.setUsername("rvep");
// 		dataSource.setPassword("password");
// 		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//
// 		return dataSource;
// 	}
//
// 	/**
// 	 *
// 	 * @return factory
// 	 */
// 	@Bean
// 	public EntityManagerFactory entityManagerFactory() {
// 		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
// 		vendorAdapter.setGenerateDdl(true);
//
// 		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
// 		factory.setJpaVendorAdapter(vendorAdapter);
// 		factory.setPackagesToScan(new String [] {
// 				"io.abnd.rvep.event.model",
// 				"io.abnd.rvep.security.model",
// 				"io.abnd.rvep.user.model"
// 		});
// 		factory.setDataSource(dataSource());
// 		factory.afterPropertiesSet();
//
// 		return factory.getObject();
// 	}
//
// 	/**
// 	 *
// 	 * @return txManager
// 	 */
// 	@Bean
// 	public PlatformTransactionManager transactionManager() {
// 		JpaTransactionManager txManager = new JpaTransactionManager();
// 		txManager.setEntityManagerFactory(entityManagerFactory());
//
// 		return txManager;
// 	}
//
//}
