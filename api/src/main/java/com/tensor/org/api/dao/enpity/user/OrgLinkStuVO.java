package com.tensor.org.api.dao.enpity.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class OrgLinkStuVO implements Serializable {
    private Integer id;

    private String orgId;

    private String studentNo;

    private Date joinDate;

    private Date quitDate;

    private static final long serialVersionUID = -6302742534686155642L;

}