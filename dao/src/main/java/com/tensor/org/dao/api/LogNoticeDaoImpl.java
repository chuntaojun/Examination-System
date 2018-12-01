package com.tensor.org.dao.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.dao.mapper.log.NoticeLogPOMapper;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.function.Consumer;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class LogNoticeDaoImpl implements NoticeDao {

    @Resource
    private NoticeLogPOMapper noticeLogPOMapper;

    @Override
    public ResultData<NoticePackage> save(NoticePackage noticePackage) {
        return noticeLogPOMapper.save(noticePackage)
                .map(noticePackage1 -> ResultData.builder()
                        .code(noticePackage1 == null ?
                                HttpResponseStatus.BAD_REQUEST.getCode() : HttpResponseStatus.OK.getCode())
                        .value(noticePackage)
                        .builded()).block();
    }

    @Override
    public ResultData<NoticePackage> findNoticeById(String s) {
        return null;
    }
}
