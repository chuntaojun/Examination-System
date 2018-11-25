package com.tensor.org.api.dao.enpity.user;



import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = -6904906433410997835L;

    protected String userId;

    protected String nickName;

    protected String headImageUrl;

    protected String account;

    protected String email;

    protected String phone;

    protected String password;

    protected Date registerDate;

    private int roles;

    public UserVO() {
    }

    public UserVO(String userId, String nickName, String headImageUrl, String email, String phone, String password, Date registerDate, int roles) {
        this.userId = userId;
        this.nickName = nickName;
        this.headImageUrl = headImageUrl;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.registerDate = registerDate;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headImageUrl='" + headImageUrl + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", roles=" + roles +
                '}';
    }
}