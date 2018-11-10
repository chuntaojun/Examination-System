package com.tensor.org.dao.enpity.user;

import lombok.Data;

import java.util.List;

/**
 * @author liaochuntao
 */
@Data
public class StudentVO extends UserVO {

    private String studentNo;

    StudentVO(String id, String nickName, String headImageUrl, String account, String password, String email, String phone, List<RoleVO> roles) {
        super(id, nickName, headImageUrl, account, password, email, phone, roles);
    }
}
