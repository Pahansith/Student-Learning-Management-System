/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public interface UserAccountDao extends SuperDao<UserAccountDTO>{
    public UserAccountDTO loginUser(UserAccountDTO account)throws RemoteException,IOException;
}
