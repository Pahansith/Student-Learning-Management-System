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
public class UserAccountDTO extends SuperDTO implements Comparable<UserAccountDTO>{
    private String userAccountId;
    private String userName;
    private String password;
    private Types type;
    
    private StudentDTO studentAccount;
    private AdministrativeDTO adminAccount;

    
    public UserAccountDTO() {
    }
    
    

    public UserAccountDTO(String userAccountId, String userName, String password) {
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
    }
    
    public UserAccountDTO(String userAccountId, String userName, String password,Types type) {
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public UserAccountDTO(String userAccountId, String userName, String password, Types type, StudentDTO studentAccount) {
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.studentAccount = studentAccount;
    }

    public UserAccountDTO(String userAccountId, String userName, String password, Types type, AdministrativeDTO adminAccount) {
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.adminAccount = adminAccount;
    }
    
    /**
     * @return the userAccountId
     */
    public String getUserAccountId() {
        return userAccountId;
    }

    /**
     * @param userAccountId the userAccountId to set
     */
    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    /**
     * @return the type
     */
    public Types getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Types type) {
        this.type = type;
    }

    /**
     * @return the studentAccount
     */
    public StudentDTO getStudentAccount() {
        return studentAccount;
    }

    /**
     * @param studentAccount the studentAccount to set
     */
    public void setStudentAccount(StudentDTO studentAccount) {
        this.studentAccount = studentAccount;
    }

    /**
     * @return the adminAccount
     */
    public AdministrativeDTO getAdminAccount() {
        return adminAccount;
    }

    /**
     * @param adminAccount the adminAccount to set
     */
    public void setAdminAccount(AdministrativeDTO adminAccount) {
        this.adminAccount = adminAccount;
    }
    
    public enum Types{
        ADMIN,STUDENT
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
    
    @Override
    public int compareTo(UserAccountDTO o) {
        return o.userAccountId.compareTo(this.userAccountId);
    }
    
    @Override
    public boolean equals(Object ob){
        if (ob instanceof UserAccountDTO) {
            UserAccountDTO dto = (UserAccountDTO) ob;
            return dto.getUserName().equals(this.userName) && dto.getPassword().equals(this.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.userName);
        hash = 17 * hash + Objects.hashCode(this.password);
        return hash;
    }

    
}
