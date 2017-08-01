/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.CourseBusiness;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.CourseDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public class CourseBusinessImpl implements CourseBusiness{

    SuperDao<CourseDTO> dao = DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BATCH);

    public CourseBusinessImpl() {
        
    }
    
    
    @Override
    public boolean add(CourseDTO t) throws RemoteException ,IOException{
        return dao.add(t);
    }

    @Override
    public boolean update(CourseDTO t) throws RemoteException ,IOException{
        return dao.update(t);
    }

    @Override
    public CourseDTO search(String t) throws RemoteException ,IOException{
        return dao.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException ,IOException{
        return dao.delete(t);
    }

    @Override
    public ArrayList<CourseDTO> getAll() throws RemoteException ,IOException{
        return dao.getAll();
    }
    
}
