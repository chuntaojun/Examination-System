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
     * 根据教师编号查找对应的教师
     * @param teacherNo
     * @return
     */
    TeacherVO findOneTeacherVO(@Param(value = "teacherNo") String teacherNo);

    /**
     * 查找全部的教师账户
     * @return
     */
    List<TeacherVO> findAllTeacherVO();

}