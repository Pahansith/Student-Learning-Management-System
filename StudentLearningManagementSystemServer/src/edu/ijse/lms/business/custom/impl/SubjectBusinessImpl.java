/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.SubjectBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public class SubjectBusinessImpl implements SubjectBusiness{

    SuperDao<SubjectDTO> dao = DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.SUBJECT);
    
    @Override
    public boolean add(SubjectDTO t) throws RemoteException ,IOException{
        return dao.add(t);
    }

    @Override
    public boolean update(SubjectDTO t) throws RemoteException ,IOException{
        return dao.update(t);
    }

    @Override
    public SubjectDTO search(String t) throws RemoteException ,IOException{
        return dao.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return dao.delete(t);
    }

    @Override
    public ArrayList<SubjectDTO> getAll() throws RemoteException ,IOException{
        return dao.getAll();
    }
    
}
