/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.business.custom.SubjectBusiness;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.lms.observer.FaceExamObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.service.custom.SubjectService;

/**
 *
 * @author Pahansith
 */
public class SubjectServiceImpl extends UnicastRemoteObject implements SubjectService{
    
    SubjectBusiness business = (SubjectBusiness) BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.SUBJECT);
    
    private static ArrayList<FaceExamObserver> examObserverList = new ArrayList<>();
    
    public SubjectServiceImpl() throws RemoteException{
        super();
        
    }
    @Override
    public boolean add(SubjectDTO t) throws RemoteException ,IOException{
        return business.add(t);
    }

    @Override
    public boolean update(SubjectDTO t) throws RemoteException ,IOException{
        return business.update(t);
    }

    @Override
    public SubjectDTO search(String t) throws RemoteException ,IOException{
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return business.delete(t);
    }

    @Override
    public ArrayList<SubjectDTO> getAll() throws RemoteException ,IOException{
        return business.getAll();
    }

    @Override
    public boolean reserve(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
