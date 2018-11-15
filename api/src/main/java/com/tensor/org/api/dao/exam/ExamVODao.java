package com.tensor.org.api.dao.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.ExamVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface ExamVODao {

    /**
     * 根据试卷编号查找相应的试卷信息
     * @param examId
     * @return
     */
    ResultData<ExamVO> findExamById(String examId);

    /**
     * 试卷信息保存(根据curdType选择插入 or 更新)
     * @param examVO
     * @param curdType
     * @return
     */
    ResultData save(ExamVO examVO, int curdType);

    /**
     * 分页查询试卷列表信息
     * @param page
     * @return
     */
    ResultData<List<ExamVO>> findAllExamVO(Page page);

}
