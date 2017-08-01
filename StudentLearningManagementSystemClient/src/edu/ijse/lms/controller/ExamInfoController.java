/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.view.student.formpanel.ExamInfoPanel;

/**
 *
 * @author Pahansith
 */
public class ExamInfoController {

    private ExamInfoPanel panel;
    public ExamInfoController(ExamInfoPanel panel) {
        this.panel = panel;
    }
    public void attendToExam(StudentDTO student) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            boolean attendExam = examService.attendExam(student);
            if (attendExam) {
                //panel.showMessage();
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(FaceExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FaceExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ExamDTO getActivatedExam(StudentDTO student) {
        ExamDTO activatedExam = null;
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            activatedExam = examService.getActivatedExams(student.getBatch());
            
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(FaceExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FaceExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activatedExam;
    }

    public ArrayList<ExamDTO> loadUpcommingExams(BatchDTO batch) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            ArrayList<ExamDTO> upccomingExams = examService.searchUpcommingExams(batch);
            return upccomingExams;
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ExamInfoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
