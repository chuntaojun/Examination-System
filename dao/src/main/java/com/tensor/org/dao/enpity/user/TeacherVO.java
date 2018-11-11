package com.tensor.org.dao.enpity.user;

import com.tensor.org.dao.enpity.organization.OrganizationVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
@Data
public class TeacherVO extends UserVO implements Serializable {

    private static final long serialVersionUID = 4446722425643978922L;

    private String teacherNo;

    private String teacherRealName;

    private List<OrganizationVO> organizationVOS;


}