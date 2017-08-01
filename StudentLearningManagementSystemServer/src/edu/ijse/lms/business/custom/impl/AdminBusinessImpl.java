/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.AdminBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dao.custom.AdminDao;
import edu.ijse.lms.dto.AdministrativeDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class AdminBusinessImpl implements AdminBusiness{

    AdminDao dao = (AdminDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ADMIN);

    public AdminBusinessImpl() {
        try {
            dao.loadData();
        } catch (IOException ex) {
            Logger.getLogger(AdminBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public boolean add(AdministrativeDTO t) throws RemoteException, IOException {
        return dao.add(t);
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
    
}
