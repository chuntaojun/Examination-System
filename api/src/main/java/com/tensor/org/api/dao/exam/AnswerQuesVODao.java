package com.tensor.org.api.dao.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.AnswerQuesVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface AnswerQuesVODao {

    /**
     * 根据问题编号查找对应的选择题
     * @param quesId
     * @return
     */
    ResultData<AnswerQuesVO> findAnswerQuesVOById(String quesId);

    /**
     * 选择题的保存操作(根据curdType选择插入 or 更新)
     * @param answerQuesVO
     * @param curdType
     * @return
     */
    ResultData save(AnswerQuesVO answerQuesVO, int curdType);

    /**
     *
     * @param page
     * @return
     */
    ResultData<List<AnswerQuesVO>> findAllAnswerQuesVO(Page page);

    /**
     * 根据试题id编号列表批量删除
     * @param quesIds
     * @return
     */
    ResultData deleteQuesBatch(List<String> quesIds);

}
