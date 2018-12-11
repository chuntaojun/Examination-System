package com.tensor.org.dao.mapper.exam;


import com.tensor.org.api.dao.enpity.exam.AnswerQuesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaochuntao
 */
@Mapper
public interface AnswerQuesVOMapper {

    int save(@Param(value = "answerQuesVO") AnswerQuesVO answerQuesVO);

}