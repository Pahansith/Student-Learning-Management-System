/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;

import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.AdminDao;
import edu.ijse.lms.dto.AdministrativeDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.secure.SecureData;

/**
 *
 * @author Pahansith
 */
public class AdminDaoImpl implements AdminDao{
    
    private LinkedList<AdministrativeDTO> adminList;
    public AdminDaoImpl() {
        adminList = (LinkedList<AdministrativeDTO>) DataListConnection.getInstance().getAdminList();
    }
    

    @Override
    public boolean add(AdministrativeDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(AdministrativeDTO t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdministrativeDTO search(String t) throws RemoteException, IOException {
        loadData();
        AdministrativeDTO administrativeDTO = new AdministrativeDTO();
        administrativeDTO.setNic(t);
        int index;
        if ((index=adminList.indexOf(administrativeDTO)) != -1) {
            return adminList.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AdministrativeDTO> getAll() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadData() throws RemoteException, IOException {
        adminList.clear();
        File file = new File("filedb/users/AdministrativeProfile.txt");
        if (!file.exists()) {
            return;
        }
        try {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null){
                    String decryptData = SecureData.decryptData(line, 5);
                    //String[] parts = decryptData.split("[:]");
                    String[] parts = line.split("[:]");
                    //String subjectId, String courseId, String name, int numberOfCredits
                    AdministrativeDTO adminDTO = new AdministrativeDTO(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                    adminList.add(adminDTO);
                }
                Collections.sort(adminList);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
