/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import edu.ijse.lms.service.SuperService;

/**
 *
 * @author Pahansith
 */
public interface UserAccountService extends SuperService<UserAccountDTO>{
    public UserAccountDTO loginUser(UserAccountDTO account)throws RemoteException,IOException;
}
