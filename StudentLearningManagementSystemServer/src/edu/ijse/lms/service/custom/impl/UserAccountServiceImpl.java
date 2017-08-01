/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.business.custom.UserAccountBusiness;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.lms.service.custom.UserAccountService;

/**
 *
 * @author Pahansith
 */
public class UserAccountServiceImpl extends UnicastRemoteObject implements UserAccountService{
    
    public UserAccountServiceImpl()throws RemoteException{
        
    }
    
    UserAccountBusiness business = (UserAccountBusiness) BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.USERACCOUNT);
    
    @Override
    public UserAccountDTO loginUser(UserAccountDTO account) throws RemoteException, IOException {
        return business.loginUser(account);
    }

    @Override
    public boolean add(UserAccountDTO t) throws RemoteException, IOException {
        return business.add(t);
                
    }

    @Override
    public boolean update(UserAccountDTO t) throws RemoteException, IOException {
        return business.update(t);
    }

    @Override
    public UserAccountDTO search(String t) throws RemoteException, IOException {
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        return business.delete(t);
    }

    @Override
    public ArrayList<UserAccountDTO> getAll() throws RemoteException, IOException {
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
