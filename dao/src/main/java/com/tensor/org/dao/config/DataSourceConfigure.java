package com.tensor.org.dao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaochuntao
 */
@Slf4j
@Configuration
public class DataSourceConfigure {

    @Bean(value = "masterDataSource")
    @ConfigurationProperties(prefix="spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(value = "slaveDataSource")
    @ConfigurationProperties(prefix="spring.datasource.slave")
    public DataSource salveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(value = "dynamicDataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        DataSource master = masterDataSource();
        DataSource slave = salveDataSource();
        dynamicDataSource.setDefaultTargetDataSource(master);
        Map<Object, Object> datasource = new HashMap<>();
        datasource.put(DataSourceType.MASTER_DB.getType(), master);
        datasource.put(DataSourceType.SALVE_ONE.getType(), slave);
        dynamicDataSource.setTargetDataSources(datasource);
        return dynamicDataSource;
    }

}
