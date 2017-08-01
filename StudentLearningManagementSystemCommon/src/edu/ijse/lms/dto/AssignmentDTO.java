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
public class AssignmentDTO extends SuperDTO{
    private String assignmentId;
    private String lastSubmissionDate;
    private int numberOfQuestions;

    private SubjectDTO subject;
    
    public AssignmentDTO() {
    }

    public AssignmentDTO(String assignmentId, String lastSubmissionDate, int numberOfQuestions) {
        this.assignmentId = assignmentId;
        this.lastSubmissionDate = lastSubmissionDate;
        this.numberOfQuestions = numberOfQuestions;
    }

    /**
     * @return the assignmentId
     */
    public String getAssignmentId() {
        return assignmentId;
    }

    /**
     * @param assignmentId the assignmentId to set
     */
    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }


    /**
     * @return the lastSubmissionDate
     */
    public String getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    /**
     * @param lastSubmissionDate the lastSubmissionDate to set
     */
    public void setLastSubmissionDate(String lastSubmissionDate) {
        this.lastSubmissionDate = lastSubmissionDate;
    }

    /**
     * @return the numberOfQuestions
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * @param numberOfQuestions the numberOfQuestions to set
     */
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
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
