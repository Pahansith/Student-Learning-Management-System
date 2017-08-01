/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom;

import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author Pahansith
 */
public interface StudentBusiness extends SuperBusiness<StudentDTO> {

    public boolean registerStudent(StudentRegInfo regInfoDTO) throws RemoteException, IOException;

    public StudentDTO getRegisterPendingStudent() throws RemoteException, IOException;

    public LinkedList<StudentRegInfo> getAllRegisterPendingStudent() throws RemoteException, IOException;
    
    public boolean approveStudent(StudentRegInfo info) throws RemoteException, IOException;

}
