package com.tensor.org.api.dao.enpity.exam;

import java.util.HashMap;
import java.util.List;

/**
 * 学生考试记录
 * @author liaochuntao
 */
public class ExamScoreVO {

    private String examId;
    private String studentNo;
    private double score;
    private HashMap<String, Boolean> judgeAnswer;
    private HashMap<String, List<Integer>> selectAnswer;
    private HashMap<String, String> answer;

    public ExamScoreVO() {}

    public ExamScoreVO(String examId, String studentNo, double score, HashMap<String, Boolean> judgeAnswer, HashMap<String, List<Integer>> selectAnswer, HashMap<String, String> answer) {
        this.examId = examId;
        this.studentNo = studentNo;
        this.score = score;
        this.judgeAnswer = judgeAnswer;
        this.selectAnswer = selectAnswer;
        this.answer = answer;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public HashMap<String, Boolean> getJudgeAnswer() {
        return judgeAnswer;
    }

    public void setJudgeAnswer(HashMap<String, Boolean> judgeAnswer) {
        this.judgeAnswer = judgeAnswer;
    }

    public HashMap<String, List<Integer>> getSelectAnswer() {
        return selectAnswer;
    }

    public void setSelectAnswer(HashMap<String, List<Integer>> selectAnswer) {
        this.selectAnswer = selectAnswer;
    }

    public HashMap<String, String> getAnswer() {
        return answer;
    }

    public void setAnswer(HashMap<String, String> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ExamScoreVO{" +
                "examId='" + examId + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", score=" + score +
                ", judgeAnswer=" + judgeAnswer +
                ", selectAnswer=" + selectAnswer +
                ", answer=" + answer +
                '}';
    }
}
