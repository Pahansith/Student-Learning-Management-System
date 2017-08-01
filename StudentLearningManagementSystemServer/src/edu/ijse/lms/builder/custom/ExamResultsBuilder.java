/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder.custom;

import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class ExamResultsBuilder extends DTOBuilder{

    String nic;
    String examId;
    double marks;
    char grade;
    public ExamResultsBuilder(String examId,String nic,double marks, char grade) {
        this.nic = nic;
        this.examId = examId;
        this.marks = marks;
        this.grade = grade;
    }

    
    @Override
    public void initAttributes() throws RemoteException, IOException {
        createNewExamResult();
        ExamResultsDTO results = (ExamResultsDTO)superDto;
        results.setGrade(grade);
        results.setMarks(marks);
        
        results.setExam((ExamDTO) factory.getDao(DaoFactory.DaoTypes.EXAM).search(examId));
        results.setStudent((StudentDTO) factory.getDao(DaoFactory.DaoTypes.STUDENT).search(nic));
    }
    
}
