package com.tensor.org.api.dao.enpity.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class OrgLinkStuVO implements Serializable {
    private Integer id;

    private String orgId;

    private String studentNo;

    private Date joinDate;

    private Date quitDate;

    private static final long serialVersionUID = -6302742534686155642L;

    public OrgLinkStuVO() {
    }

    public OrgLinkStuVO(Integer id, String orgId, String studentNo, Date joinDate, Date quitDate) {
        this.id = id;
        this.orgId = orgId;
        this.studentNo = studentNo;
        this.joinDate = joinDate;
        this.quitDate = quitDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "OrgLinkStuVO{" +
                "id=" + id +
                ", orgId='" + orgId + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", joinDate=" + joinDate +
                ", quitDate=" + quitDate +
                '}';
    }
}