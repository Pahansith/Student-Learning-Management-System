/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao;

import edu.ijse.lms.dto.SuperDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 * @param <T>
 */
public interface SuperDao<T extends SuperDTO> {

    public boolean add(T t) throws RemoteException, IOException;

    public boolean update(T t) throws RemoteException, IOException;

    public T search(String t) throws RemoteException, IOException;

    public boolean delete(String t) throws RemoteException, IOException;

    public ArrayList<T> getAll() throws RemoteException, IOException;

    public void loadData() throws RemoteException, IOException;
}
