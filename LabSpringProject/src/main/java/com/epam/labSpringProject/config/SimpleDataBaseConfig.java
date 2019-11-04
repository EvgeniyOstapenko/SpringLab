package com.epam.labSpringProject.config;

import org.h2.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.jdbc.datasource.init.*;

import javax.sql.*;

@Configuration
@PropertySource("db.properties")
@ComponentScan("com.epam.labSpringProject")
public class SimpleDataBaseConfig {

    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("schema.sql")
    private Resource schemaScript;

    @Bean
    DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new Driver());
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        return populator;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
