/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.StudentBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.custom.StudentDao;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class StudentBusinessImpl implements StudentBusiness{

    StudentDao dao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    public StudentBusinessImpl() {
        try {
            dao.loadData();
        } catch (IOException ex) {
            Logger.getLogger(StudentBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public boolean add(StudentDTO t) throws RemoteException ,IOException{
        return dao.add(t);
    }

    @Override
    public boolean update(StudentDTO t) throws RemoteException ,IOException{
        return dao.update(t);
    }

    @Override
    public StudentDTO search(String t) throws RemoteException ,IOException{
        return dao.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return dao.delete(t);
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws RemoteException ,IOException{
        return dao.getAll();
    }

    @Override
    public boolean registerStudent(StudentRegInfo regInfoDTO) throws RemoteException,IOException {
        return dao.registerStudent(regInfoDTO);
    }

    @Override
    public StudentDTO getRegisterPendingStudent() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<StudentRegInfo> getAllRegisterPendingStudent() throws RemoteException, IOException {
        return dao.getAllRegisterPendingStudent();
    }

    @Override
    public boolean approveStudent(StudentRegInfo info) throws RemoteException, IOException {
        StudentDTO registerPendingStudent = dao.getRegisterPendingStudent(info);
        return true;
    }
    
}
