package com.tensor.org.api.dao.enpity.exam;

import lombok.Data;

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

    private Date createTime;

    private Date publishTime;

    private Date deadLine;

    private Integer examDuration;

    private Integer status;

    private List<SelectQuesVO> selectQuesVOS;

    private List<AnswerQuesVO> answerQuesVOS;

}