package com.tensor.org.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author liaochuntao
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class DaoApplication {

    @PostConstruct
    public void timeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

}
