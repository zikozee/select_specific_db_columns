package com.nativequery.mysqlnativequery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatasourceConfiguration {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;


    @Bean(name = "mysql_db")
    @Primary
    public DataSource getDataBaseOneTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Value("${mssql.driverClassName}")
    private String mssqlDriverClassName;

    @Value("${mssql.url}")
    private String mssqlDbUrl;

    @Value("${mssql.username}")
    private String mssqlUserName;

    @Value("${mssql.password}")
    private String mssqlPassword;

    @Value("${mssql.hibernate.dialect}")
    private String mssqlDialect;


    //TODO use ms sql-server to configure another database with another bean name and try connect likewise
    // remember extractor is the best
    @Bean(name = "mssqlServer_db")
    public DataSource getSqlServerTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(mssqlDriverClassName);
        dataSource.setUrl(mssqlDbUrl);
        dataSource.setUsername(mssqlUserName);
        dataSource.setPassword(mssqlPassword);

        Properties props = new Properties();
        props.setProperty("hibernate.dialect", mssqlDialect);

        dataSource.setConnectionProperties(props);

        return dataSource;
    }

    @Bean
    public JdbcTemplate getTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
