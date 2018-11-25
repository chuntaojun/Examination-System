package com.tensor.org.api.dao.enpity.user;

import com.tensor.org.api.dao.enpity.organization.OrganizationVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class TeacherVO extends UserVO implements Serializable {

    private static final long serialVersionUID = 4446722425643978922L;

    private String teacherNo;

    private String teacherRealName;

    private List<OrganizationVO> organizationVOS;

    public TeacherVO() {
    }

    public TeacherVO(String teacherNo, String teacherRealName, List<OrganizationVO> organizationVOS) {
        this.teacherNo = teacherNo;
        this.teacherRealName = teacherRealName;
        this.organizationVOS = organizationVOS;
    }

    public TeacherVO(String userId, String nickName, String headImageUrl, String email, String phone, String password, Date registerDate, int roles, String teacherNo, String teacherRealName, List<OrganizationVO> organizationVOS) {
        super(userId, nickName, headImageUrl, email, phone, password, registerDate, roles);
        this.teacherNo = teacherNo;
        this.teacherRealName = teacherRealName;
        this.organizationVOS = organizationVOS;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherRealName() {
        return teacherRealName;
    }

    public void setTeacherRealName(String teacherRealName) {
        this.teacherRealName = teacherRealName;
    }

    public List<OrganizationVO> getOrganizationVOS() {
        return organizationVOS;
    }

    public void setOrganizationVOS(List<OrganizationVO> organizationVOS) {
        this.organizationVOS = organizationVOS;
    }

    @Override
    public String toString() {
        return "TeacherVO{" +
                "teacherNo='" + teacherNo + '\'' +
                ", teacherRealName='" + teacherRealName + '\'' +
                ", organizationVOS=" + organizationVOS +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headImageUrl='" + headImageUrl + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}