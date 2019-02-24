package com.tensor.org.exam.service.elastic.impl;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.SearchConditionPO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.exam.bean.QuestionDom;
import com.tensor.org.exam.dao.QuestionDomRepository;
import com.tensor.org.exam.service.elastic.ExamQuesSearchService;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service
public class ExamQuesSearchServiceImpl implements ExamQuesSearchService {

    @Resource private QuestionDomRepository questionDomRepository;

    @Override
    public ResultData save(QuestionPackage questionPackage) {
        QuestionDom questionDom = QuestionDom.builder()
                .quesId(questionPackage.getQuesId())
                .quesBody(JsonUtils.toJson(questionPackage.getQuesBody()))
                .build();
        QuestionDom result = questionDomRepository.save(questionDom);
        return ResultData.builder()
                .code(result == null ? HttpResponseStatus.INTERNAL_SERVER_ERROR.code() : HttpResponseStatus.OK.code())
                .value(result)
                .builded();
    }

    @Override
    public ResultData<List> findQuesFuzzy(SearchConditionPO searchConditionPO) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders
                        .functionScoreQuery(QueryBuilders
                                .matchQuery(QuestionDom.SEARCH_FIELD_QUES_BODY, searchConditionPO.getQueryBody())))
                .build();
        List doms = questionDomRepository.search(searchQuery).getContent();
        return ResultData.builder()
                .code((doms != null && !doms.isEmpty()) ? HttpResponseStatus.OK.code() : HttpResponseStatus.BAD_REQUEST.code())
                .value(doms)
                .builded();
    }

}
