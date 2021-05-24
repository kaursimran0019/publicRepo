package org.dt.perf.adapter.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.dt",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "userTransactionManager"
)
public class dbconfig {
    private String dbPasskey;
    private String dbUrl;
    private String dbUsername;

    @PostConstruct
    public void init() {
        dbUrl = "jdbc:mysql://localhost:3306/db_example";
        dbUsername = "springuser";
        dbPasskey = "Today@0987";
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.dt");
        Properties hibernateProperties = new Properties();
        sessionFactory.setHibernateProperties(setHibernateProperties(hibernateProperties));
        return sessionFactory;
    }
    private Properties setHibernateProperties(Properties jpaHibernateProperties) {
        jpaHibernateProperties.put("hibernate.show_sql", "true");
        jpaHibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaHibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
        return jpaHibernateProperties;
    }
    @Primary
    @Bean
    @Qualifier("entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("org.dt");
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaHibernateProperties = new Properties();
        em.setJpaProperties(setHibernateProperties(jpaHibernateProperties));
        return em;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPasskey);
        return dataSource;
    }

    //Added Name
//    @Bean
    @Bean(name = "userTransactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
}
