/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public abstract class DTOBuilder {

    protected SuperDTO superDto;
    protected DaoFactory factory;

    public DTOBuilder() {
        factory = DaoFactory.getInstance();
    }

    public void createNewUserAccount() {
        superDto = new UserAccountDTO();
    }
    
    public void createNewExam() {
        superDto = new ExamDTO();
    }
    
    public void createNewStudent() {
        superDto = new StudentDTO();
    }
    
    public void createNewExamQuestion(){
        superDto = new ExamQuestionDTO();
    }
    
    public void createNewExamResult(){
        superDto = new ExamResultsDTO();
    }

    public SuperDTO getDto() {
        return superDto;
    }

    public abstract void initAttributes() throws RemoteException, IOException;

}
