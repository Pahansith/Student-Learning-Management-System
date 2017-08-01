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
public class ExamResultsDTO extends SuperDTO{
    private ExamDTO exam;
    private StudentDTO student;
    private double marks;
    private char grade;

    public ExamResultsDTO() {
    }

    public ExamResultsDTO(double marks, char grade) {
        this.marks = marks;
        this.grade = grade;
    }

    
    
    /**
     * @return the marks
     */
    public double getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(double marks) {
        this.marks = marks;
    }

    /**
     * @return the grade
     */
    public char getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(char grade) {
        this.grade = grade;
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
