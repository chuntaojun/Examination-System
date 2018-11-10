package com.tensor.org.dao.enpity.organization;

import com.tensor.org.dao.enpity.user.StudentVO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liaochuntao
 */
@Data
@Builder
public class OrganizationVO {

    private int id;
    private String organizationName;
    private String organizationDoc;
    private List<StudentVO> studentVOS;

}
