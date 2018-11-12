package com.tensor.org.dao.enpity.exam;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
@Data
public class ExamVO implements Serializable {

    private static final long serialVersionUID = 5768159524272272476L;

    private String examId;

    private String orgId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deadLine;

    private Integer examDuration;

    private Integer status;

    private List<SelectQuesVO> selectQuesVOS;

    private List<AnswerQuesVO> answerQuesVOS;

}