/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;

import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.SubjectDao;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class SubjectDaoImpl implements SubjectDao{
    
    private LinkedList<SubjectDTO> subjectList;

    public SubjectDaoImpl() {
        try {
            subjectList = (LinkedList<SubjectDTO>) DataListConnection.getInstance().getSubjectList();
            loadData();
            
        } catch (IOException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
    @Override
    public boolean add(SubjectDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SubjectDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubjectDTO search(String id) throws RemoteException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectId(id);
        int index;
        if ((index=subjectList.indexOf(subjectDTO)) != -1) {
            return subjectList.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SubjectDTO> getAll() throws RemoteException {
        ArrayList<SubjectDTO> subjects = new ArrayList<>();
        subjectList.stream().forEach((subjectDTO) -> {
            subjects.add(subjectDTO);
        });
        
        return subjects;
    }

    @Override
    public void loadData() throws RemoteException, IOException {
        subjectList.clear();
        File file = new File("filedb/subjectdata/Subject.txt");
        if (!file.exists()) {
            return;
        }
        try {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null){
                    String[] parts = line.split("[:]");
                    //String subjectId, String name, int numberOfCredits
                    //String subjectId, String courseId, String name, int numberOfCredits
                    SubjectDTO subjectDTO = new SubjectDTO(parts[0],parts[2],Integer.parseInt(parts[3]));
                    subjectList.add(subjectDTO);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
