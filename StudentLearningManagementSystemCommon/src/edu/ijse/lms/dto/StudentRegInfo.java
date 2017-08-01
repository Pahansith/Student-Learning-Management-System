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
public class StudentRegInfo extends SuperDTO{
    private String fName;
    private String lName;
    private String userName;
    private String nic;
    private String dob;
    private int telephone;
    private BatchDTO batch;
    private String password;
    private String email;
    private String confPassword;
    
    public StudentRegInfo() {
    }

    public StudentRegInfo(String fName, String lName, String userName, String nic, String dob, 
            int telephone, BatchDTO batch, String password, String email, String confPassword) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.nic = nic;
        this.dob = dob;
        this.telephone = telephone;
        this.batch = batch;
        this.password = password;
        this.email = email;
        this.confPassword = confPassword;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the confPassword
     */
    public String getConfPassword() {
        return confPassword;
    }

    /**
     * @param confPassword the confPassword to set
     */
    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
    
    

    
}
