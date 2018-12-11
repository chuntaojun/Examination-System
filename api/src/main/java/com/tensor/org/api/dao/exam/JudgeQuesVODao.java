package com.tensor.org.api.dao.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.JudgeQuesVO;

import java.util.List;

public interface JudgeQuesVODao {

    /**
     * 根据问题编号查找对应的选择题
     * @param quesId
     * @return
     */
    ResultData<AnswerQuesVODao> findJudgeQuesVOById(String quesId);

    /**
     * 选择题的保存操作(根据curdType选择插入 or 更新)
     * @param judgeQuesVO
     * @param curdType
     * @return
     */
    ResultData save(JudgeQuesVO judgeQuesVO, int curdType);

    /**
     *
     * @param page
     * @return
     */
    ResultData<List<JudgeQuesVO>> findAllJudgeQuesVO(Page page);

    /**
     * 根据试题id编号列表批量删除
     * @param quesIds
     * @return
     */
    ResultData deleteQuesBatch(List<String> quesIds);

}
