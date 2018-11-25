package com.tensor.org.api.dao.enpity.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class StudentVO extends UserVO implements Serializable {

    private static final long serialVersionUID = -1717920161233721216L;

    private String studentNo;

    private String studentRealName;

    public StudentVO() {
    }

    public StudentVO(String studentNo, String studentRealName) {
        this.studentNo = studentNo;
        this.studentRealName = studentRealName;
    }

    public StudentVO(String userId, String nickName, String headImageUrl, String email, String phone, String password, Date registerDate, int roles, String studentNo, String studentRealName) {
        super(userId, nickName, headImageUrl, email, phone, password, registerDate, roles);
        this.studentNo = studentNo;
        this.studentRealName = studentRealName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentRealName() {
        return studentRealName;
    }

    public void setStudentRealName(String studentRealName) {
        this.studentRealName = studentRealName;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "studentNo='" + studentNo + '\'' +
                ", studentRealName='" + studentRealName + '\'' +
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