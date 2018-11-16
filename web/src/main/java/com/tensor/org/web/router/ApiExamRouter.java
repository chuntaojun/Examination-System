package com.tensor.org.web.router;

import com.tensor.org.web.handler.exam.ExamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
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
                GET("/api/exam"), examHandler::addQues);
    }

}
