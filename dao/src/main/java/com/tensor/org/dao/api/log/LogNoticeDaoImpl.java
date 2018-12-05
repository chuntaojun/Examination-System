package com.tensor.org.dao.api.log;

import com.alibaba.dubbo.config.annotation.Service;
import com.mongodb.client.result.UpdateResult;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.dao.mapper.log.NoticeLogPOMapper;
import com.tensor.org.dao.mongo.MongoQueryField;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    @Autowired private ReactiveMongoTemplate reactiveMongoTemplate;

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

    @Override
    public ResultData<Boolean> updateStatus(NoticePackage noticePackage) {
        Mono<UpdateResult> resultMono = reactiveMongoTemplate.updateFirst(
                new Query(Criteria
                        .where(MongoQueryField.NoticePackageDom.NOTICE_ID)
                        .is(noticePackage.getNoticeId())),
                new Update()
                        .set(MongoQueryField.NoticePackageDom.FINISH, noticePackage.isFinish()),
                "noticePackage");
        ResultData result = resultMono.map(UpdateResult::wasAcknowledged).map(b -> ResultData.builder().value(b).builded()).block();
        return result;
    }
}
