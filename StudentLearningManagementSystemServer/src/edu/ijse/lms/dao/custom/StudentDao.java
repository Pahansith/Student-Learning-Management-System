/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author Pahansith
 */
public interface StudentDao extends SuperDao<StudentDTO>{
    public boolean registerStudent(StudentRegInfo regInfoDTO) throws RemoteException,IOException;
    
    public StudentDTO getRegisterPendingStudent(StudentRegInfo info) throws RemoteException, IOException;

    public LinkedList<StudentRegInfo> getAllRegisterPendingStudent() throws RemoteException, IOException;
}
