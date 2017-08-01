/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.BatchBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.BatchDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class BatchBusinessImpl implements BatchBusiness{
    
    SuperDao<BatchDTO> dao = DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BATCH);

    public BatchBusinessImpl() {
        try {
            dao.loadData();
        } catch (IOException ex) {
            Logger.getLogger(BatchBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public boolean add(BatchDTO t) throws RemoteException,IOException {
        return dao.add(t);
    }

    @Override
    public boolean update(BatchDTO t) throws RemoteException ,IOException{
        return dao.update(t);
    }

    @Override
    public BatchDTO search(String t) throws RemoteException ,IOException{
        return dao.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return dao.delete(t);
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws RemoteException ,IOException{
        return dao.getAll();
    }
    
}
