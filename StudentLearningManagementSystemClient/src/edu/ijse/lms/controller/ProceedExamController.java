/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.ExamDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.view.admin.formpanel.ProceedExamPanel;
import edu.ijse.lms.view.admin.formpanel.QuestionAddPanel;
import edu.ijse.lms.view.admin.formpanel.TriggerExamPanel;

/**
 *
 * @author Pahansith
 */
public class ProceedExamController {

    private ProceedExamPanel panel;
    public ProceedExamController(ProceedExamPanel panel) {
        this.panel = panel;
    }
    
    
    public void loadAvailableExams() {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            ArrayList<ExamDTO> examList = examService.getAll();
            panel.loadTable(examList);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getTableValue(int index) {
        panel.setValues(index);
    }

    

    public void proceedExam(ExamDTO selectedExam) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            examService.activateExam(selectedExam);
            panel.home.loadPanel.removeAll();
            TriggerExamPanel addPanel = new TriggerExamPanel(panel.home);
            panel.home.loadPanel.add(addPanel);
            panel.home.loadPanel.repaint();
            panel.home.loadPanel.revalidate();
            
            addPanel.setExam(selectedExam);
            addPanel.setBatch(selectedExam.getBatch());
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean reserveExam(String examId) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            return examService.reserve(examId);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProceedExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
}
