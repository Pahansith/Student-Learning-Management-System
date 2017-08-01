/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

import java.util.Objects;

/**
 *
 * @author Pahansith
 */
public class BatchDTO extends SuperDTO implements Comparable<BatchDTO>{
    private String batchId;
    private String year;
    private int batchNumber;
    private int studentCount;

    private CourseDTO course;
    
    public BatchDTO() {
    }

    public BatchDTO(String batchId, String year, int batchNumber, int studentCount) {
        this.batchId = batchId;
        this.year = year;
        this.batchNumber = batchNumber;
        this.studentCount = studentCount;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }


    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the batchNumber
     */
    public int getBatchNumber() {
        return batchNumber;
    }

    /**
     * @param batchNumber the batchNumber to set
     */
    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * @return the studentCount
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * @param studentCount the studentCount to set
     */
    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
    
    
    @Override
    public String toString(){
        return Integer.toString(batchNumber);
    }

    @Override
    public int compareTo(BatchDTO o) {
        return o.batchId.compareTo(this.batchId);
    }
    
    @Override
    public boolean equals(Object ob){
        if (ob instanceof BatchDTO) {
            return ((BatchDTO) ob).batchId.equals(this.batchId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.batchId);
        return hash;
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


