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
public class StudentExamDetailDTO extends SuperDTO{
    private StudentDTO studeent;
    private ExamDTO exam;
    private int marks;
    private double gpa;

    public StudentExamDetailDTO() {
    }

    public StudentExamDetailDTO(int marks, double gpa) {

        this.marks = marks;
        this.gpa = gpa;
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
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the studeent
     */
    public StudentDTO getStudeent() {
        return studeent;
    }

    /**
     * @param studeent the studeent to set
     */
    public void setStudeent(StudentDTO studeent) {
        this.studeent = studeent;
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
    
    
    
}
