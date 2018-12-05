package com.tensor.org.web.router;

import com.tensor.org.web.handler.notice.NoticeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author liaochuntao
 */
@Configuration
public class ApiNoticeRouter {

    @Autowired private NoticeHandler noticeHandler;

    @Bean(value = "NoticeApiRouter")
    public RouterFunction<?> userApiRouter() {
        return route(
                POST("/api/notice/publish"), noticeHandler::publish);
    }

}
