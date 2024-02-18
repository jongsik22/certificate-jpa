package com.nhnacademy.springjpa.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.springjpa.Base;
import com.nhnacademy.springjpa.properties.DatabaseProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
@RequiredArgsConstructor
public class RootConfig {
    private final DatabaseProperties databaseProperties;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(databaseProperties.getDriverClassName());
        basicDataSource.setUrl(databaseProperties.getUrl());
        basicDataSource.setUsername(databaseProperties.getUsername());
        basicDataSource.setPassword(databaseProperties.getPassword());
        basicDataSource.setInitialSize(databaseProperties.getInitialSize());
        basicDataSource.setMaxTotal(databaseProperties.getMaxTotal());
        basicDataSource.setMinIdle(databaseProperties.getMinIdle());
        basicDataSource.setMaxIdle(databaseProperties.getMaxIdle());
        basicDataSource.setTestOnBorrow(databaseProperties.isTestOnBorrow());
        if (databaseProperties.isTestOnBorrow()) {
            basicDataSource.setValidationQuery(basicDataSource.getValidationQuery());
        }
        return basicDataSource;
    }

    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    @Bean(name = "xmlMapper")
    public XmlMapper xmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return xmlMapper;
    }
}
