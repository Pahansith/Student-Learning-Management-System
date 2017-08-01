/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.business.custom.AdminBusiness;
import edu.ijse.lms.dto.AdministrativeDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.lms.service.custom.AdminService;

/**
 *
 * @author Pahansith
 */
public class AdminServiceImpl implements AdminService{
    
    //Dependacy Injection
    AdminBusiness business = (AdminBusiness) BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.ADMIN);
    
    @Override
    public boolean add(AdministrativeDTO t) throws RemoteException, IOException {
        return business.add(t);
    }

    @Override
    public boolean update(AdministrativeDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdministrativeDTO search(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AdministrativeDTO> getAll() throws RemoteException, IOException {
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
    
}