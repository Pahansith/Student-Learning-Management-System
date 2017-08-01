/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder.custom;

import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.custom.AdminDao;
import edu.ijse.lms.dto.AdministrativeDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class UserAccountBuilder extends DTOBuilder{

    private final String userAccountId;
    private final String userName;
    private final String password;
    private final UserAccountDTO.Types type;
    private final String id;

    public UserAccountBuilder(String userAccountId, String userName, String password, UserAccountDTO.Types type, String id) {
        createNewUserAccount();
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.id = id;
    }
    

    
    
    @Override
    public void initAttributes() throws RemoteException, IOException {
        UserAccountDTO userAccount = (UserAccountDTO)superDto;
        
        userAccount.setPassword(password);
        if (type.equals(UserAccountDTO.Types.ADMIN)) {
            userAccount.setAdminAccount((AdministrativeDTO) factory.getDao(DaoFactory.DaoTypes.ADMIN).search(id));
        }else if(type.equals(UserAccountDTO.Types.STUDENT)){
            userAccount.setStudentAccount((StudentDTO) factory.getDao(DaoFactory.DaoTypes.STUDENT).search(id));
        }
        
        
        userAccount.setType(type);
        userAccount.setUserAccountId(userAccountId);
        userAccount.setUserName(userName);
        
        
    }

    
    
    
    
}
