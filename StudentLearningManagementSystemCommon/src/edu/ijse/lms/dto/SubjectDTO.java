/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

import java.util.Objects;
import edu.ijse.lms.service.custom.CourseService;

/**
 *
 * @author Pahansith
 */
public class SubjectDTO extends SuperDTO implements Comparable<SubjectDTO>{
    private String subjectId;
    private String name;
    private int numberOfCredits;

    private CourseDTO course;
    public SubjectDTO() {
    }

    public SubjectDTO(String subjectId, String name, int numberOfCredits) {
        this.subjectId = subjectId;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * @return the subjectId
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numberOfCredits
     */
    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    /**
     * @param numberOfCredits the numberOfCredits to set
     */
    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public int compareTo(SubjectDTO o) {
        return o.subjectId.compareTo(this.subjectId);
    }
    
    @Override
    public boolean equals(Object ob){
        if (ob instanceof SubjectDTO) {
            return ((SubjectDTO) ob).subjectId.equals(this.subjectId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.subjectId);
        return hash;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * @return the course
     */
    public CourseDTO getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(CourseDTO course) {
        this.course = course;
    }
   
}
