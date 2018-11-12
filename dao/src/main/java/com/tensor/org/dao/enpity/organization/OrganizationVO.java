package com.tensor.org.dao.enpity.organization;

import com.tensor.org.dao.enpity.user.StudentVO;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
@Data
public class OrganizationVO implements Serializable {

    private String orgId;

    @NonNull
    private String orgName;

    @NonNull
    private String orgDoc;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String orgLogo;

    private String teacherNo;

    private List<StudentVO> studentVOS;

    private static final long serialVersionUID = -6411614573805541566L;

}