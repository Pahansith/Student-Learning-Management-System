/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.BatchDao;
import edu.ijse.lms.dto.BatchDTO;
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
public class BatchDaoImpl implements BatchDao{

    

    private static LinkedList<BatchDTO> availableBatches;

    public BatchDaoImpl() {
        
        availableBatches = (LinkedList<BatchDTO>) DataListConnection.getInstance().getBatchList();
    }
    
    
    
    
    
    @Override
    public boolean add(BatchDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDTO search(String t) throws RemoteException, IOException {
        loadData();
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setBatchId(t);
        int index;
        if ((index=availableBatches.indexOf(batchDTO)) != -1) {
            return availableBatches.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws RemoteException, FileNotFoundException, IOException {
        
        File file = new File("filedb/batchdata/Batch.txt");
        if (!file.exists()) {
            System.out.println("asd");
            return null;
        }
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<BatchDTO> batchList = new ArrayList<>();
        while((line=br.readLine())!=null){
            String decryptData = SecureData.decryptData(line, 5);
            //String[] parts = decryptData.split("[:]");
            String[] parts = line.split("[:]");
            BatchDTO batchDTO = new BatchDTO(parts[0], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
            batchList.add(batchDTO);
        }
        return batchList;
        
    }

    @Override
    public void loadData() throws RemoteException, IOException {
        FileReader fr = null;
        try {
            availableBatches.clear();
            File file = new File("filedb/batchdata/Batch.txt");
            if (!file.exists()) {
                return ;
            }   
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String decryptData = SecureData.decryptData(line, 5);
                //String[] parts = decryptData.split("[:]");
                String[] parts = line.split("[:]");
                //String batchId, String year, int batchNumber, int studentCount
                BatchDTO batchDTO = new BatchDTO(parts[0], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                availableBatches.add(batchDTO);
            }
            
            Collections.sort(availableBatches);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BatchDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BatchDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(BatchDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
