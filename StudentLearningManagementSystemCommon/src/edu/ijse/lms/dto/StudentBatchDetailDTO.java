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
public class StudentBatchDetailDTO extends SuperDTO {

    private StudentDTO student;
    private BatchDTO batch;
    private String registrationDate;

    public StudentBatchDetailDTO() {
    }

    public StudentBatchDetailDTO(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the registrationDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
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

    /**
     * @return the batch
     */
    public BatchDTO getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }

}
