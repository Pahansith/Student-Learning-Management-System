/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.custom.StudentBusiness;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import edu.ijse.lms.observer.RegistrationObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.service.custom.StudentService;

/**
 *
 * @author Pahansith
 */
public class StudentServiceImpl extends UnicastRemoteObject implements StudentService,Subject<RegistrationObserver>{
    
    StudentBusiness business = (StudentBusiness) BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.STUDENT);
    private static ArrayList<RegistrationObserver> registrationList = new ArrayList<>();
    
    public StudentServiceImpl() throws RemoteException{
        super();
        
    }
    
    @Override
    public boolean add(StudentDTO t) throws RemoteException ,IOException{
        return business.add(t);
    }

    @Override
    public boolean update(StudentDTO t) throws RemoteException ,IOException{
        return business.update(t);
    }

    @Override
    public StudentDTO search(String t) throws RemoteException ,IOException{
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return business.delete(t);
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws RemoteException ,IOException{
        return business.getAll();
    }

    @Override
    public boolean registerStudent(StudentRegInfo regInfoDTO) throws RemoteException,IOException {
        boolean registerStudent = business.registerStudent(regInfoDTO);
        notifyAllObservers("Added");
        return registerStudent;
    }

   
    @Override
    public StudentDTO getRegisterPendingStudent() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<StudentRegInfo> getAllRegisterPendingStudent() throws RemoteException, IOException {
       
        return business.getAllRegisterPendingStudent();
    }

    @Override
    public void registerObserver(RegistrationObserver observer) throws RemoteException {
        registrationList.add(observer);
    }

    @Override
    public void unregisterObserver(RegistrationObserver observer) throws RemoteException {
        registrationList.remove(observer);
    }

    @Override
    public void notifyAllObservers(Object anObject) throws RemoteException {
        registrationList.stream().forEach((observer) -> {
            new Thread(){
                @Override
                public void run(){
                    try {
                        observer.update();
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
                
            }.start();
        });
    }

    @Override
    public void registerSpecificObserver(RegistrationObserver observer, Object identifier) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unregisterSpecificObserver(RegistrationObserver observer, Object identifier) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifySpecificObservers(Object anObject, Object identifier) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean approveStudent(StudentRegInfo info) throws RemoteException, IOException {
        return business.approveStudent(info);
    }

    
    
    
}
