package com.tensor.org.exam.dao;

import com.tensor.org.exam.bean.QuestionDom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liaochuntao
 */
@Component
public interface QuestionDomRepository extends ElasticsearchRepository<QuestionDom, String> {

}
