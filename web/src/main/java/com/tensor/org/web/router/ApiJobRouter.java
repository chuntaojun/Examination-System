package com.tensor.org.web.router;

import com.tensor.org.web.handler.job.JobTaskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author liaochuntao
 */
@Configuration
public class ApiJobRouter {

    @Autowired private JobTaskHandler jobTaskHandler;

    @Bean(value = "jobApiRouter")
    public RouterFunction<?> jobApiRouter() {
        return route(
                POST("/v1/api/job/create").and(accept(MediaType.APPLICATION_JSON)), jobTaskHandler::createJob);
    }

}
