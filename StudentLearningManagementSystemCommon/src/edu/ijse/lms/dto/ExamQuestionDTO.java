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
public class ExamQuestionDTO extends SuperDTO{
    private String question;
    private String[] answerList;
    private boolean[] correct;
    private String questionId;
    
    private SubjectDTO subject;
    
    
    
    public ExamQuestionDTO() {
        
    }

    public ExamQuestionDTO(SubjectDTO subject,String question, String[] answerList, boolean[] correct,String questionId) {
        this.question = question;
        this.answerList = answerList;
        this.correct = correct;
        this.subject = subject;
        this.questionId = questionId;
    }


    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answerList
     */
    public String[] getAnswerList() {
        return answerList;
    }

    /**
     * @param answerList the answerList to set
     */
    public void setAnswerList(String[] answerList) {
        this.answerList = answerList;
    }

    /**
     * @return the correct
     */
    public boolean[] getCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    public void setCorrect(boolean[] correct) {
        this.correct = correct;
    }

    /**
     * @return the subject
     */
    public SubjectDTO getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    /**
     * @return the questionId
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId the questionId to set
     */
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    
}
