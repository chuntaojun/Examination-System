package com.tensor.org.dao.enpity.exam;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String teacherNo;

    private static final long serialVersionUID = 6043948570425722611L;

}