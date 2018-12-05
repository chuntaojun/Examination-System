package com.tensor.org.web.handler.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import com.tensor.org.api.task.JobTaskService;
import com.tensor.org.web.utils.ResponseAdaperUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
@Component
public class JobTaskHandlerImpl implements JobTaskHandler {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.work}")
    private JobTaskService jobTaskService;

    @Override
    public Mono<ServerResponse> createJob(ServerRequest request) {
        return request.bodyToMono(JobEntityPO.class)
                .map(jobEntityPO -> jobTaskService.createJob(jobEntityPO))
                .map(Mono::just)
                .flatMap(ResponseAdaperUtils::render);
    }
}
