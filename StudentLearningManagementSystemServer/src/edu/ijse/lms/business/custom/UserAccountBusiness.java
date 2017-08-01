/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom;

import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public interface UserAccountBusiness extends SuperBusiness<UserAccountDTO>{
    public UserAccountDTO loginUser(UserAccountDTO account)throws RemoteException,IOException;
}
