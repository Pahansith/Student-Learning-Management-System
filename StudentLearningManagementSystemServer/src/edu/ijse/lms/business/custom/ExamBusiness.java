/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom;

import edu.ijse.lms.business.SuperBusiness;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import edu.ijse.lms.observer.FaceExamObserver;

/**
 *
 * @author Pahansith
 */
public interface ExamBusiness extends SuperBusiness<ExamDTO> {

    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException;

    public boolean attendExam(StudentDTO student) throws RemoteException, IOException;

    public ArrayList<ExamQuestionDTO> activateExam(ExamDTO exam) throws RemoteException, IOException;

    public HashMap<FaceExamObserver, ArrayList<ExamQuestionDTO>> startExam(ArrayList<FaceExamObserver> observerList,
            ArrayList<ExamQuestionDTO> questionList, ArrayList<ExamAttendanceDTO> attendStudentList, ExamDTO exam) throws RemoteException, IOException;

    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch) throws RemoteException, IOException;

    public ExamResultsDTO uploadExamAnswer(ArrayList<StudentExamAnswersDTO> answerList) throws RemoteException, IOException;
    
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException;
}
