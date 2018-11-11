package com.tensor.org.dao.enpity.exam;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String teacherNo;

}