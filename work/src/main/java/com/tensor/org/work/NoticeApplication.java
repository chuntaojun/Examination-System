package com.tensor.org.work;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liaochuntao
 */
@SpringBootApplication
@EnableDubboConfiguration
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }

}
