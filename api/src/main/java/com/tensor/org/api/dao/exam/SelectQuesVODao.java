package com.tensor.org.api.dao.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.SelectQuesVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface SelectQuesVODao {

    /**
     * 根据问题编号查找对应的选择题
     * @param quesId
     * @return
     */
    ResultData<SelectQuesVO> findSelectQuesVOById(String quesId);

    /**
     * 选择题的保存操作(根据curdType选择插入 or 更新)
     * @param selectQuesVO
     * @param curdType
     * @return
     */
    ResultData save(SelectQuesVO selectQuesVO, int curdType);

    /**
     *
     * @param page
     * @return
     */
    ResultData<List<SelectQuesVO>> findAllSelectQues(Page page);

    /**
     * 根据试题id编号列表批量删除
     * @param quesIds
     * @return
     */
    ResultData deleteQuesBatch(List<String> quesIds);

}
