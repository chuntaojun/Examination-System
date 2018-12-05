package com.tensor.org.api.dao.enpity.organization;

import com.tensor.org.api.dao.enpity.user.StudentVO;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class OrganizationVO implements Serializable {

    private String orgId;

    private String orgName;

    private String orgDoc;

    private Date createDate;

    private String orgLogo;

    private String teacherNo;

    private List<StudentVO> studentVOS;

    private static final long serialVersionUID = -6411614573805541566L;

    public OrganizationVO() {
    }

    public OrganizationVO(String orgId, String orgName, String orgDoc, Date createDate, String orgLogo, String teacherNo, List<StudentVO> studentVOS) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgDoc = orgDoc;
        this.createDate = createDate;
        this.orgLogo = orgLogo;
        this.teacherNo = teacherNo;
        this.studentVOS = studentVOS;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDoc() {
        return orgDoc;
    }

    public void setOrgDoc(String orgDoc) {
        this.orgDoc = orgDoc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public List<StudentVO> getStudentVOS() {
        return studentVOS;
    }

    public void setStudentVOS(List<StudentVO> studentVOS) {
        this.studentVOS = studentVOS;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "OrganizationVO{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgDoc='" + orgDoc + '\'' +
                ", createDate=" + createDate +
                ", orgLogo='" + orgLogo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", studentVOS=" + studentVOS +
                '}';
    }
}