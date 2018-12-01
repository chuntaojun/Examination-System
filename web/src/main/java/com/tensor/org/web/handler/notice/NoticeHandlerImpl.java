package com.tensor.org.web.handler.notice;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.api.user.NoticeService;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.web.utils.ResponseAdaperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class NoticeHandlerImpl implements NoticeHandler {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.work}")
    private NoticeService noticeService;

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private NoticeDao noticeDao;

    @Override
    public Mono<ServerResponse> publish(ServerRequest request) {
        return request.bodyToMono(String.class)
                .map(s -> (NoticePackage) JsonUtils.toObj(s, NoticePackage.class))
                .map(noticePackage -> noticeDao.save(noticePackage))
                .map(resultData -> {
                    if (resultData.getCode() == HttpStatus.OK.value()) {
                        return noticeService.publish(resultData.getValue());
                    }
                    return resultData;
                })
                .map(Mono::justOrEmpty)
                .flatMap(dataMono -> ResponseAdaperUtils.render(dataMono, HttpStatus.OK));
    }
}
