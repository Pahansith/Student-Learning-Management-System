/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.BatchService;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.service.custom.SubjectService;
import edu.ijse.lms.view.admin.formpanel.GrantExamPanel;

/**
 *
 * @author Pahansith
 */
public class AddExamController {
    private GrantExamPanel panel;
    public AddExamController(GrantExamPanel panel){
        this.panel = panel;
    }

    public void addNewQuestion() {
        try {
            ExamDTO exam = panel.getExamDetail();
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            boolean add = examService.add(exam);
            if (add) {
                panel.showMessage("Added Succesfully");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadSubjectCombo() {
        try {
            
            SubjectService subjectService = ServerConnector.getServerConnector().getSubjectService();
            ArrayList<SubjectDTO> subjectList = subjectService.getAll();
            panel.setComboValues(subjectList);
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadBatchCombo() {
        try {
            BatchService batchService = ServerConnector.getServerConnector().getBatchService();
            ArrayList<BatchDTO> batchList = batchService.getAll();
            panel.setBatchComboValues(batchList);
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ExamDTO> getAllExams() {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            return examService.getAll();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
