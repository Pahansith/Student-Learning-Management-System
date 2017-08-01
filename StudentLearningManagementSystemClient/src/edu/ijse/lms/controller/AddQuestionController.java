/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.service.custom.SubjectService;
import edu.ijse.lms.view.admin.formpanel.QuestionAddPanel;

/**
 *
 * @author Pahansith
 */
public class AddQuestionController {

    private QuestionAddPanel panel;

    public void loadComboBox() {
        try {
            SubjectService subjectService = ServerConnector.getServerConnector().getSubjectService();
            ArrayList<SubjectDTO> allSubject = subjectService.getAll();
            
            panel.setComboValues(allSubject);
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public AddQuestionController(QuestionAddPanel panel) {
        this.panel = panel;
    }

    
    public void addNewQuestion() {
        ExamQuestionDTO question = panel.getQuestion();
        saveQuestion(question);
    }
    
    private void saveQuestion(ExamQuestionDTO question){
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            boolean addQuestion = examService.addQuestion(question);
            if (addQuestion) {
                panel.showMessage("Added Succesfully");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
