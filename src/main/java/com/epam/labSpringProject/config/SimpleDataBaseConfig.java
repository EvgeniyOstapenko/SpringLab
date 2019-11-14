package com.epam.labSpringProject.config;

import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "file:/Users/Evgeniy/Documents/GitHub/SpringLab/LabSpringProject/src/main/resources/db.properties")
//@ComponentScan("com.epam.labSpringProject")
public class SimpleDataBaseConfig {

    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("file:/Users/Evgeniy/Documents/GitHub/SpringLab/LabSpringProject/src/main/resources/schema.sql")
    private Resource schemaScript;
    @Value("file:/Users/Evgeniy/Documents/GitHub/SpringLab/LabSpringProject/src/main/resources/population_script.sql")
    private Resource population_script;
    @Value("file:/Users/Evgeniy/Documents/GitHub/SpringLab/LabSpringProject/src/main/resources/migration.sql")
    private Resource migration_script;

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
        populator.addScript(population_script);
        populator.addScript(migration_script);
        return populator;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
