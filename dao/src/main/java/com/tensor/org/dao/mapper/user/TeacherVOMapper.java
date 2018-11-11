package com.tensor.org.dao.mapper.user;


import com.tensor.org.dao.enpity.user.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaochuntao
 */
@Mapper
public interface TeacherVOMapper {

    /**
     * 添加教师信息
     * @param teacherVO {@link TeacherVO}
     * @return
     */
    int saveTeacherVO(@Param(value = "teacherVO") TeacherVO teacherVO);

    /**
     * 更新教师信息
     * @param teacherVO {@link TeacherVO}
     * @return
     */
    int updateTeacherVO(@Param(value = "teacherVO") TeacherVO teacherVO);

    /**
     * 根据教师编号查找对应的教师
     * @param teacherNo {@link String}
     * @return
     */
    TeacherVO findOneTeacherVO(@Param(value = "teacherNo") String teacherNo);

    /**
     * 查找全部的教师账户
     * @return
     */
    List<TeacherVO> findAllTeacherVO();

}