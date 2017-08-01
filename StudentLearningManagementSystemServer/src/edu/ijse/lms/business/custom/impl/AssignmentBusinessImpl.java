/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.AssignmentBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.AssignmentDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public class AssignmentBusinessImpl implements AssignmentBusiness{
    
    SuperDao<AssignmentDTO> dao = DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ASSIGNMENT);
    
    @Override
    public boolean add(AssignmentDTO t) throws RemoteException ,IOException{
        return dao.add(t);
    }

    @Override
    public boolean update(AssignmentDTO t) throws RemoteException ,IOException{
        return dao.update(t);
    }

    @Override
    public AssignmentDTO search(String t) throws RemoteException ,IOException{
        return dao.search(t);
                
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return dao.delete(t);
    }

    @Override
    public ArrayList<AssignmentDTO> getAll() throws RemoteException ,IOException{
        return dao.getAll();
    }
    
}
