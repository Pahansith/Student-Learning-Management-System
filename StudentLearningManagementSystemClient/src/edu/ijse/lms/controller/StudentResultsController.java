/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.ExamResultsDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.view.admin.formpanel.StudentResultsPanel;

/**
 *
 * @author Pahansith
 */
public class StudentResultsController {

    private final StudentResultsPanel panel;
    
    public StudentResultsController(StudentResultsPanel panel) {
        this.panel = panel;
    }

    public ArrayList<ExamResultsDTO> getResults() {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            return examService.getExamResults();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(StudentResultsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
                
    }
    
    
    
}
