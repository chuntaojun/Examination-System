package com.tensor.org.api.dao.user;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.StudentVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface StudentVODao {

    /**
     * 学生对象的保存操作(根据curdType选择插入 or 更新)
     * @param studentVO
     * @param curdType
     * @return
     */
    ResultData save(StudentVO studentVO, int curdType);

    /**
     * 根据学生编号查找学生信息
     * @param stuNo
     * @return
     */
    ResultData<StudentVO> findStuVOByStuNo(String stuNo);

    /**
     * 查找某组织下的全部学生
     * @param orgId
     * @return
     */
    ResultData<List<StudentVO>> findAllStuVOByOrgId(String orgId);

}
