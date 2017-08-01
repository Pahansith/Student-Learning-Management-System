/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder.custom;

import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class StudentBuilder extends DTOBuilder{

    private String nic;
    private String name;
    private String dob;
    private int telephone;
    private String batchId;
    public StudentBuilder(String nic, String name, String dob, int telephone,String batchId) {
        this.nic = nic;
        this.name = name;
        this.dob = dob;
        this.telephone = telephone;
        this.batchId = batchId;
    }

    @Override
    public void initAttributes() throws RemoteException, IOException {
        createNewStudent();
        StudentDTO studentDTO = (StudentDTO)superDto;
        studentDTO.setName(name);
        studentDTO.setNic(nic);
        studentDTO.setTelephone(telephone);
        studentDTO.setDob(dob);
        studentDTO.setBatch((BatchDTO) factory.getDao(DaoFactory.DaoTypes.BATCH).search(batchId));
    }
    
}
