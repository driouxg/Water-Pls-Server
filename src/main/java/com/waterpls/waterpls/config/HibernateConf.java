package com.waterpls.waterpls.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * Hibernate Info https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConf {

  @Value("${jdbc.driverClassName}")
  private String datasourceDriver;

  @Value("${jdbc.url}")
  private String datasourceUrl;

  @Value("${jdbc.user}")
  private String datasourceUser;

  @Value("${jdbc.password}")
  private String datasourcePassword;

  @Value("${hibernate.dialect}")
  private String hibernateDialect;

  @Value("${hibernate.show_sql}")
  private String hibernateShowSQL;

  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateAuto;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("com.waterpls.waterpls.domain.entity");
    sessionFactory.setHibernateProperties(hibernateProperties());

    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(datasourceDriver);
    dataSource.setUrl(datasourceUrl);
    dataSource.setUsername(datasourceUser);
    dataSource.setPassword(datasourcePassword);

    return dataSource;
  }

  @Bean
  public PlatformTransactionManager hibernateTransactionManager() {
    HibernateTransactionManager transactionManager
        = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

  @Bean
  public Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty(
        "hibernate.hbm2ddl.auto", hibernateAuto);
    //hibernateProperties.setProperty("hibernate.show_sql", hibernateShowSQL);
    //hibernateProperties.setProperty("hibernate.id.new_generator_mappings", "true");
    //hibernateProperties.setProperty("org.hibernate", "TRACE");
    //hibernateProperties.setProperty("bollucks", "sadfsdf");
    hibernateProperties.setProperty(
        "hibernate.dialect", hibernateDialect);

    return hibernateProperties;
  }
}
