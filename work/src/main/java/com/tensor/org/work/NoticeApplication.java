package com.tensor.org.work;

import com.tensor.org.work.config.netty.TcpServerConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author liaochuntao
 */
@Slf4j
@SpringBootApplication
public class NoticeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NoticeApplication.class, args);
        TcpServerConfigure tcpServer = context.getBean(TcpServerConfigure.class);
        try {
            tcpServer.start();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
