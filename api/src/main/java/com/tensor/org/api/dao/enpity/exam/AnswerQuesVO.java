package com.tensor.org.api.dao.enpity.exam;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class AnswerQuesVO implements Serializable {

    private Integer id;

    private String quesDoc;

    private Float quesScore;

    private Date createTime;

    private Date updateTime;

    private String teacherNo;

    private static final long serialVersionUID = 6043948570425722611L;

}