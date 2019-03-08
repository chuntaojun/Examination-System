package com.tensor.org.web.handler.exam;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.dao.enpity.SearchConditionPO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;
import com.tensor.org.api.exam.QuestionManagerService;
import com.tensor.org.api.exam.QuestionSearchService;
import com.tensor.org.web.utils.ResponseAdaperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class ExamHandlerImpl implements ExamHandler {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.exam}", timeout = 5000)
    private QuestionSearchService questionSearchService;

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.exam}", timeout = 5000)
    private QuestionManagerService questionManagerService;

    @Override
    public Mono<ServerResponse> addQues(ServerRequest request) {
        return request.bodyToMono(QuestionPackage.class)
                .map(questionPackage -> {
                    log.info("QuestionPackage : {}", questionPackage);
                    return questionPackage;
                })
                .map(questionPackage -> Mono.justOrEmpty(questionManagerService.saveQuesCurd(questionPackage)))
                .flatMap(ResponseAdaperUtils::render);
    }

    @Override
    public Mono<ServerResponse> search(ServerRequest request) {
        return request.bodyToMono(SearchConditionPO.class)
                .map(searchConditionPO -> questionSearchService.findQuesFuzz(searchConditionPO))
                .map(ResponseAdaperUtils::change)
                .map(Mono::justOrEmpty)
                .flatMap(ResponseAdaperUtils::render);

    }
}
