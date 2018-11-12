package com.tensor.org.api.dao.user;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.user.TeacherVO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface TeacherVODao {

    /**
     * 教师的保存操作(根据curdType选择插入 or 更新)
     * @param teacherVO
     * @param curdType
     * @return
     */
    ResultData save(TeacherVO teacherVO, int curdType);

    /**
     * 根据教师编号查找该教师信息
     * @param teacherNo
     * @return
     */
    ResultData<TeacherVO> findTeachVOByTeaNo(String teacherNo);

    /**
     * 查找全部教师
     * @return
     */
    ResultData<List<TeacherVO>> findAllTeacherVO();

}
