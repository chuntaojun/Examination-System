package com.tensor.org.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author liaochuntao
 */
@SpringBootApplication
public class ExamApplication {

    @PostConstruct
    public void timeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

}
