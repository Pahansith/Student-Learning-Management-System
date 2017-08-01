/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.view.admin.formpanel.TriggerExamPanel;

/**
 *
 * @author Pahansith
 */
public class TriggerExamController {

    private TriggerExamPanel panel;
    public TriggerExamController(TriggerExamPanel panel) {
        this.panel = panel;
    }

    public ArrayList<ExamDTO> getAllActivatedExams() {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            ArrayList<ExamDTO> allAcivatedExamList = examService.getAllAcivatedExamList();
            return allAcivatedExamList;
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public HashMap<BatchDTO, ArrayList<ExamAttendanceDTO>> getExamAttendanceMap() {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            return examService.getExamAttendanceMap();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void triggerExam(ExamDTO exam,BatchDTO batch) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            examService.triggerExam(exam, batch);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TriggerExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
