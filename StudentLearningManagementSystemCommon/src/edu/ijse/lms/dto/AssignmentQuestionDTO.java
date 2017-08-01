/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public class AssignmentQuestionDTO {
    private String questionId;
    private String question;
    private ArrayList<String> answerList;
    private boolean[] correct;
    
    private SubjectDTO subject;

    public AssignmentQuestionDTO() {
    }

    public AssignmentQuestionDTO(String questionId, String question, ArrayList<String> answerList, boolean[] correcr) {
        this.questionId = questionId;
        this.question = question;
        this.answerList = answerList;
        this.correct = correcr;
    }

    public AssignmentQuestionDTO(String questionId, String subjectId, String question, ArrayList<String> answerList, boolean[] correct, SubjectDTO subject) {
        this.questionId = questionId;
        this.question = question;
        this.answerList = answerList;
        this.correct = correct;
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
    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    /**
     * @param answerList the answerList to set
     */
    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    /**
     * @return the correcr
     */
    public boolean[] getCorrecr() {
        return correct;
    }

    /**
     * @param correcr the correcr to set
     */
    public void setCorrecr(boolean[] correcr) {
        this.correct = correcr;
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

    
}
