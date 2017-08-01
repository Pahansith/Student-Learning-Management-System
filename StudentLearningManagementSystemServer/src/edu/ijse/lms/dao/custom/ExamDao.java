/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public interface ExamDao extends SuperDao<ExamDTO> {

    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException;

    public String getLastExamId() throws RemoteException, IOException;

    public boolean attendExam(StudentDTO student) throws RemoteException, IOException;

    public ArrayList<ExamQuestionDTO> activateExam(ExamDTO exam) throws RemoteException, IOException;
    
    public void writeLog(ArrayList<ExamQuestionDTO> questions,ArrayList<ExamAttendanceDTO> students)throws RemoteException, IOException;
    
    public String getLastQuestionId() throws RemoteException, IOException;
    
    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch)throws RemoteException, IOException;
    
    public boolean saveStudentResults(ExamResultsDTO results)throws RemoteException, IOException;
    
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException;
    
}
