/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;

import edu.ijse.lms.builder.BuilderManager;
import edu.ijse.lms.builder.custom.UserAccountBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.UserAccountDao;
import edu.ijse.lms.dto.AdministrativeDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class UserAccountDaoImpl implements UserAccountDao {

    private LinkedList<UserAccountDTO> accountList;

    public UserAccountDaoImpl() {
        accountList = (LinkedList<UserAccountDTO>) DataListConnection.getInstance().getUserAccountList();
    }
    
    @Override
    public void loadData() throws RemoteException, IOException {
        FileReader fr = null;
        try {
            accountList.clear();
            File file = new File("filedb/users/UserAccount.txt");
            if (!file.exists()) {
                return;
            }

            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("[:]");

                UserAccountDTO.Types type;

                UserAccountDTO userAccountDTO;
                UserAccountBuilder userAccountBuilder;
                switch (parts[3]) {
                    case "ADMIN":
                        type = UserAccountDTO.Types.ADMIN;
                        userAccountBuilder = new UserAccountBuilder(parts[0], parts[1], parts[2], type, parts[4]);
                        userAccountDTO = (UserAccountDTO) new BuilderManager(userAccountBuilder).getDTO();
                        break;
                    case "STUDENT":
                        type = UserAccountDTO.Types.STUDENT;
                        userAccountBuilder = new UserAccountBuilder(parts[0], parts[1], parts[2], type, parts[4]);
                        userAccountDTO = (UserAccountDTO) new BuilderManager(userAccountBuilder).getDTO();
                        break;
                    default:
                        return;
                }
                accountList.add(userAccountDTO);
            }

            Collections.sort(accountList);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserAccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserAccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(UserAccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

    @Override
    public boolean add(UserAccountDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserAccountDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAccountDTO search(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserAccountDTO> getAll() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAccountDTO loginUser(UserAccountDTO account) throws RemoteException, IOException {

        int index = accountList.indexOf(account);
        if (index != -1) {
            return accountList.get(index);
        }
        return null;
    }

}
