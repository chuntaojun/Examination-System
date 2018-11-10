package com.tensor.org.dao.enpity.user;

import com.tensor.org.dao.enpity.organization.OrganizationVO;
import lombok.Data;

import java.util.List;

/**
 * @author liaochuntao
 */
@Data
public class TeacherVO extends UserVO {

    private String teacherNo;
    private String teacherRealName;
    private List<OrganizationVO> organizationVOS;

    public TeacherVO(String id, String nickName, String headImageUrl, String account, String password, String email, String phone, List<RoleVO> roles) {
        super(id, nickName, headImageUrl, account, password, email, phone, roles);
    }
}
