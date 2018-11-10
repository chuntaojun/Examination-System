package com.tensor.org.dao.enpity.user;

import lombok.Builder;
import lombok.Data;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class RoleVO {

    private int id;
    private String roleDoc;
    private int roleType;

}
