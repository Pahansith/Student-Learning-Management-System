/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.dto.AssignmentDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.lms.service.custom.AssignmentService;

/**
 *
 * @author Pahansith
 */
public class AssignmentServiceImpl extends UnicastRemoteObject implements AssignmentService{
    SuperBusiness<AssignmentDTO> business = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.ASSIGNMENT);
    
    public AssignmentServiceImpl() throws RemoteException{
        super();    
    }
    @Override
    public boolean add(AssignmentDTO t) throws RemoteException,IOException {
        return business.add(t);
    }

    @Override
    public boolean update(AssignmentDTO t) throws RemoteException ,IOException{
        return business.update(t);
    }

    @Override
    public AssignmentDTO search(String t) throws RemoteException ,IOException{
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return business.delete(t);
    }

    @Override
    public ArrayList<AssignmentDTO> getAll() throws RemoteException ,IOException{
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
