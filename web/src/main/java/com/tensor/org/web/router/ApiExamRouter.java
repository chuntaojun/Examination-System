package com.tensor.org.web.router;

import com.tensor.org.web.handler.exam.ExamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author liaochuntao
 */
@Configuration
public class ApiExamRouter {

    @Autowired private ExamHandler examHandler;

    @Bean(value = "ExamApiRouter")
    public RouterFunction<?> examApiRouter() {
        return route(
                POST("/v1/api/exam/add/ques"), examHandler::addQues)
                .andRoute(POST("/v1/api/exam/search/ques").and(accept(MediaType.APPLICATION_JSON)), examHandler::search);
    }

}
