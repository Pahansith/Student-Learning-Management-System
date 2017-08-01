/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

/**
 *
 * @author Pahansith
 */
public class StudentExamAnswersDTO extends SuperDTO{
    private ExamQuestionDTO question;
    private boolean[] answerList;
    private int correctCount;
    private ExamDTO exam;
    private StudentDTO student;
    
    public StudentExamAnswersDTO() {
    }

    public StudentExamAnswersDTO(ExamQuestionDTO question,boolean[] answerList, int correctCount,ExamDTO exam,StudentDTO student) {
        this.question = question;
        this.correctCount = correctCount;
        this.answerList = answerList;
        this.exam = exam;
        this.student = student;
    }

    /**
     * @return the question
     */
    public ExamQuestionDTO getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(ExamQuestionDTO question) {
        this.question = question;
    }

   
    
    @Override
    public boolean equals(Object o){
        if (o instanceof StudentExamAnswersDTO) {
            StudentExamAnswersDTO st = (StudentExamAnswersDTO)o;
            return this.question.getQuestionId().equals(st.getQuestion().getQuestionId());
        }
        return false;
    }

    /**
     * @return the answerList
     */
    public boolean[] getAnswerList() {
        return answerList;
    }

    /**
     * @param answerList the answerList to set
     */
    public void setAnswerList(boolean[] answerList) {
        this.answerList = answerList;
    }

    /**
     * @return the correctCount
     */
    public int getCorrectCount() {
        return correctCount;
    }

    /**
     * @param correctCount the correctCount to set
     */
    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    

    /**
     * @return the exam
     */
    public ExamDTO getExam() {
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    /**
     * @return the student
     */
    public StudentDTO getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(StudentDTO student) {
        this.student = student;
    }
    
}
