package com.tensor.org.dao.mapper.organization;


import com.tensor.org.api.dao.enpity.organization.OrganizationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaochuntao
 */
@Mapper
public interface OrganizationVOMapper {

    /**
     * 根据教师编号查找该教师所拥有的组织
     * @param teacherNo
     * @return
     */
    List<OutOfMemoryError> findAllByTeacherNo(@Param(value = "teacherNo") String teacherNo);

    /**
     * 新增组织信息
     * @param organizationVO {@link OrganizationVO}
     * @return
     */
    int saveOrganizationVO(@Param(value = "organizationVO") OrganizationVO organizationVO);

    /**
     * 更新组织信息
     * @param organizationVO {@link OrganizationVO}
     * @return
     */
    int updateOrganizationVO(@Param(value = "organizationVO") OrganizationVO organizationVO);

}