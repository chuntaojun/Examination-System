package com.tensor.org.web.router;

import com.tensor.org.web.handler.file.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 文件相关操作路由
 * @author liaochuntao
 */
@Configuration
public class ApiFileRouter {

    @Autowired private FileHandler fileHandler;

    @Bean(value = "fileApiRouter")
    public RouterFunction<?> fileApiRouter() {
        return route(
                GET("/v1/api/file/upload/chunk"), fileHandler::chunkCheck)
                .andRoute(POST("/v1/api/file/upload/chunk"), fileHandler::chunkSave)
                .andRoute(POST("/v1/api/file/upload/merge"), fileHandler::merge);
    }

}
