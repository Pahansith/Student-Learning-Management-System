/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import edu.ijse.lms.service.SuperService;

/**
 *
 * @author Pahansith
 */
public interface ExamService extends SuperService<ExamDTO> {

    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException;

    public boolean attendExam(StudentDTO student) throws RemoteException, IOException;

    public void activateExam(ExamDTO exam) throws RemoteException, IOException;

    public ExamDTO getActivatedExams(BatchDTO batch) throws RemoteException, IOException;

    public ArrayList<ExamDTO> getAllAcivatedExamList() throws RemoteException, IOException;

    public HashMap<BatchDTO, ArrayList<ExamAttendanceDTO>> getExamAttendanceMap() throws RemoteException, IOException;

    public void triggerExam(ExamDTO exam, BatchDTO batch) throws RemoteException, IOException;
    
    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch)throws RemoteException, IOException;

    public void uploadExamAnswer(ArrayList<StudentExamAnswersDTO> answerList)throws RemoteException, IOException;
    
    public ArrayList<ExamResultsDTO> getExamResults() throws RemoteException, IOException;
    
   
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException;
}
