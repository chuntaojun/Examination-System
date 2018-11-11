package com.tensor.org.dao.mapper.exam;

import com.tensor.org.dao.enpity.exam.ExamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaochuntao
 */
@Mapper
public interface ExamVOMapper {

    /**
     * 创建试卷
     * @param examVO {@link ExamVO}
     * @return
     */
    int saveExamVO(@Param(value = "examVO") ExamVO examVO);

    /**
     * 更新试卷信息，如果试卷为发布成功则无法修改
     * @param examVO
     * @return
     */
    int updateExamVO(@Param(value = "examVO") ExamVO examVO);

}