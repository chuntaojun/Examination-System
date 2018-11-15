package com.tensor.org.api.dao.enpity.user;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -6904906433410997835L;

    protected String userId;

    protected String nickName;

    protected String headImageUrl;

    protected String email;

    protected String phone;

    protected String password;

    protected Date registerDate;

    private int roles;

}