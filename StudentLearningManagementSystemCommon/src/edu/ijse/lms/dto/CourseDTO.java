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
public class CourseDTO extends SuperDTO{
    private String courseId;
    private String courseName;

    public CourseDTO() {
    }

    public CourseDTO(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    
}
