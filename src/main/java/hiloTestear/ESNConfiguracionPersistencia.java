/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloTestear;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import es.dominion.ftw.util.constantes.ConstantesAplicacion;
//import liquibase.integration.spring.SpringLiquibase;

@Configuration
//@PropertySource(value = "classpath:application.properties")

@PropertySource("classpath:app.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="es.dominion.ftw.negocio.repositorios")
/**
 *
 * @author USER
 */
public class ESNConfiguracionPersistencia {
    
    /*eso iria a una clase de constantes al ser un ejemplo.... se emte aqui tal cual */
    //Ruta de paquetes a las entidades
    public static final String PROPERTY_PACKAGES_TO_SCAN = "com.javacodegeeks.examples.controller";

	//Propiedades para la configuración de la persistencia (FTWConfiguracionPersistencia)
    public static final String PROPERTY_NAME_APP_PROFILE = "app.profile";
    public static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driverClassName";
    public static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";
    public static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
    public static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";
    public static final String PROPERTY_NAME_DATABASE_JNDI = "jdbc.jndi";    
    public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    public static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    public static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    public static final String PROPERTY_NAME_HIBERNATE_ID_GENERATOR = "hibernate.id.new_generator_mappings";
    public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String PROPERTY_NAME_HIBERNATE_USE_SQL_COMMENTS = "hibernate.use_sql_comments";
    
    @Autowired
	private Environment environment;

    @Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource(environment.getProperty(PROPERTY_NAME_DATABASE_JNDI));
        return dataSource;
    }
    
    @Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
    
    @Bean
    //@DependsOn("liquibase")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_PACKAGES_TO_SCAN);

        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_USE_SQL_COMMENTS, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_USE_SQL_COMMENTS));        
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_ID_GENERATOR, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_ID_GENERATOR));        

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
    
    /*@Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }*/

    /*@Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();
                
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:liquibase/ftw-"+environment.getRequiredProperty(ConstantesAplicacion.PROPERTY_NAME_APP_PROFILE)+".changelog-master.xml");

        return liquibase;
    }*/
    
}
