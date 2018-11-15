package com.tensor.org.api.dao.enpity.user;

import lombok.Builder;
import lombok.Data;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class JwtUser {

    private String userId;
    private String role;

}
