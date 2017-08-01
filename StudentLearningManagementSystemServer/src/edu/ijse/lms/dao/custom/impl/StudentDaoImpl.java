/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;


import edu.ijse.lms.builder.BuilderManager;
import edu.ijse.lms.builder.custom.StudentBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.StudentDao;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import edu.ijse.lms.dto.SuperDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class StudentDaoImpl implements StudentDao{
    
    private static LinkedList<StudentRegInfo> pendingStudentList;
    private LinkedList<StudentDTO> studentList;

    public StudentDaoImpl() {
        studentList = (LinkedList<StudentDTO>) DataListConnection.getInstance().getStudentList();
        pendingStudentList = new LinkedList<>();
        getRegInfoData();
    }
    

    private void getRegInfoData(){
        pendingStudentList.clear();
        FileReader fr = null;
        try {
            File file = new File("filedb/tempreg/StudentRegInfo.txt");
            if (!file.exists()) {
                return ;
            }
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            while ((line = br.readLine()) != null) {
                line = SecureData.decryptData(line, 2);
                String[] parts = line.split("[:]");
                SuperDao<BatchDTO> dao = DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BATCH);
                BatchDTO selectedBatch = dao.search(parts[6]);
                StudentRegInfo studentRegInfo = new StudentRegInfo(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), selectedBatch, parts[7], parts[8], parts[9]);
                pendingStudentList.add(studentRegInfo);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
            
    
    @Override
    public boolean add(StudentDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(StudentDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentDTO search(String t) throws RemoteException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setNic(t);
        int index;
        if ((index = studentList.indexOf(studentDTO)) != -1) {
            return studentList.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registerStudent(StudentRegInfo info) throws RemoteException, IOException {
        File file = new File("filedb/tempreg/StudentRegInfo.txt");
        try (FileWriter fw = new FileWriter(file,true)) {
            PrintWriter printWriter = new PrintWriter(fw,true);
            
            String data = info.getfName()+":"+info.getlName()+":"+info.getUserName()+":"+info.getNic()+
                    ":"+info.getDob()+":"+info.getTelephone()+":"+info.getBatch().getBatchId()+":"+
                    info.getPassword()+":"+info.getEmail()+":"+info.getConfPassword();
            String encryptData = SecureData.encryptData(data, 2);
            printWriter.println(encryptData);
        }
        pendingStudentList.add(info);
        return true;
    }

    @Override
    public StudentDTO getRegisterPendingStudent(StudentRegInfo reg) throws RemoteException, IOException {
        return null;
    }

    @Override
    public LinkedList<StudentRegInfo> getAllRegisterPendingStudent() throws RemoteException, IOException {
        return pendingStudentList;
    }

    @Override
    public void loadData() throws RemoteException, IOException {
        studentList.clear();
        File file = new File("filedb/users/StudentProfile.txt");
        if (!file.exists()) {
            return;
        }
        try {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null){
                    String[] parts = line.split("[:]");
                    //String subjectId, String courseId, String name, int numberOfCredits
                    StudentDTO studentDTO = (StudentDTO) new BuilderManager(new StudentBuilder(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4])).getDTO();
                    studentList.add(studentDTO);
                }
                Collections.sort(studentList);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
