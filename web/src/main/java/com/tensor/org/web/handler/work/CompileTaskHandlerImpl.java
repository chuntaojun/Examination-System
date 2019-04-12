package com.tensor.org.web.handler.work;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.dao.enpity.job.CompilerTaskPO;
import com.tensor.org.api.work.CompilerTaskService;
import com.tensor.org.web.utils.ResponseAdaperUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
@Component
public class CompileTaskHandlerImpl implements CompileTaskHandler {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.work}")
    private CompilerTaskService compilerTaskService;

    @Override
    public Mono<ServerResponse> compileWork(ServerRequest request) {
        return request.bodyToMono(CompilerTaskPO.class)
                .map(taskPO -> compilerTaskService.createCompilerTask(taskPO))
                .map(Mono::just)
                .flatMap(ResponseAdaperUtils::render);
    }
}
