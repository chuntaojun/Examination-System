package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.api.user.NoticeService;
import com.tensor.org.work.service.socket.NoticeChannelHandler;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发布接口
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class NoticePublishServiceImpl implements NoticeService {

    @Autowired
    private NoticeChannelHandler noticeChannelHandler;

    @Override
    public ResultData publish(NoticePackage noticePackage) {
        try {
            noticeChannelHandler.publishMsg(noticePackage);
            return ResultData.builder().code(HttpResponseStatus.OK.code()).builded();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultData.builder()
                    .code(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
                    .errMsg(e.getMessage())
                    .builded();
        }
    }
}
