package com.tensor.org.dao.enpity.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class UserVO {

    private String id;
    private String nickName;
    private String headImageUrl;
    private String account;
    private String password;
    private String email;
    private String phone;
    private List<RoleVO> roles;

}
