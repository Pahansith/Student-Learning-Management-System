/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.UserAccountBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.custom.impl.UserAccountDaoImpl;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class UserAccountBusinessImpl implements UserAccountBusiness{

    UserAccountDaoImpl dao;

    public UserAccountBusinessImpl() {
        dao = (UserAccountDaoImpl) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USERACCOUNT);
        try {
            dao.loadData();
        } catch (IOException ex) {
            Logger.getLogger(UserAccountBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public UserAccountDTO loginUser(UserAccountDTO account) throws RemoteException, IOException {
        
        return dao.loginUser(account);
    }

    @Override
    public boolean add(UserAccountDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserAccountDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAccountDTO search(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserAccountDTO> getAll() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
