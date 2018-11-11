package com.tensor.org.dao.enpity.user;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class StudentVO extends UserVO implements Serializable {

    private static final long serialVersionUID = -1717920161233721216L;

    @NonNull
    private String studentNo;

    @NonNull
    private String studentRealName;
}