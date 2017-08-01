/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.dto.BatchDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.lms.service.custom.BatchService;

/**
 *
 * @author Pahansith
 */
public class BatchServiceImpl extends UnicastRemoteObject implements BatchService{
    
    SuperBusiness<BatchDTO> business = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.BATCH);
    public BatchServiceImpl() throws RemoteException{
        
        super();
    }
    
    @Override
    public boolean add(BatchDTO t) throws RemoteException ,IOException{
        return business.add(t);
    }

    @Override
    public boolean update(BatchDTO t) throws RemoteException ,IOException{
        return business.update(t);
    }

    @Override
    public BatchDTO search(String t) throws RemoteException ,IOException{
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return business.delete(t);
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws RemoteException ,IOException{
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
