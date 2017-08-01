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
public class StudentAssignmentDetailDTO {

    private AssignmentDTO assignment;
    private StudentDTO student;
    private String submittedDate;
    private int marks;

    public StudentAssignmentDetailDTO() {
    }

    public StudentAssignmentDetailDTO(String submittedDate, int marks) {
        this.submittedDate = submittedDate;
        this.marks = marks;
    }

    /**
     * @return the submittedDate
     */
    public String getSubmittedDate() {
        return submittedDate;
    }

    /**
     * @param submittedDate the submittedDate to set
     */
    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * @return the marks
     */
    public int getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }

    /**
     * @return the assignment
     */
    public AssignmentDTO getAssignment() {
        return assignment;
    }

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(AssignmentDTO assignment) {
        this.assignment = assignment;
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
