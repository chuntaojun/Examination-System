package com.tensor.org.dao.mapper.user;


import com.tensor.org.dao.enpity.user.OrgLinkStuVO;
import com.tensor.org.dao.enpity.user.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaochuntao
 */
@Mapper
public interface StudentVOMapper {

    /**
     * 根据学生编号查找对应的学生账户
     * @param studentNo {@link String}
     * @return
     */
    StudentVO findOneStudentVO(@Param(value = "studentNo") String studentNo);

    /**
     * 查找全部的学生账户
     * @param orgId {@link String}
     * @return
     */
    List<StudentVO> findAllByOrgId(@Param(value = "orgId") String orgId);

    /**
     * 新建立学生与组织的关系
     * @param orgLinkStuVO {@link OrgLinkStuVO}
     * @return
     */
    int saveStuBelongOrg(@Param(value = "orgLinkStu")OrgLinkStuVO orgLinkStuVO);

    /**
     * 根据 {@link String orgId} 组织编号以及 {@link String studentNo} 学生编号退出该组织
     * @param orgId {@link String}
     * @param studentNo {@link String}
     * @return
     */
    int deleteStuBelongOrg(@Param(value = "orgId") String orgId, @Param(value = "studentNo") String studentNo);

}