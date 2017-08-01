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
public class StudentDTO extends SuperDTO implements Comparable<StudentDTO>{
    private String nic;
    private String name;
    private String dob;
    private int telephone;
    
    private BatchDTO batch;
    public StudentDTO() {
    }

    public StudentDTO(String nic, String name, String dob, int telephone) {
        this.nic = nic;
        this.name = name;
        this.dob = dob;
        this.telephone = telephone;
    }

    
    

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
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
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
    public int compareTo(StudentDTO o) {
        return o.getNic().compareTo(this.nic);
    }
    
    @Override
    public boolean equals(Object ob){
        if (ob instanceof StudentDTO) {
            return ((StudentDTO) ob).nic.equals(this.nic);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nic);
        return hash;
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
