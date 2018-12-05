package com.tensor.org.exam.dao;

import com.tensor.org.exam.bean.QuestionDom;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Component
public interface QuestionDomRepository extends ElasticsearchRepository<QuestionDom, String> {
}
