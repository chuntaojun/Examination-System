package com.tensor.org.api.dao.enpity.exam;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class SelectQuesVO implements Serializable {

    private static final long serialVersionUID = 875453298275031139L;

    private Integer id;

    private String quesDoc;

    private String quesChoice;

    private Float quesScore;

    private Date createTime;

    private Date updateTime;

    private String teacherNo;

}