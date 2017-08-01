/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.view.student.formpanel.ViewMarksPanel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pahansith
 */
public class ViewMarksController {

    ViewMarksPanel panel;
    public ViewMarksController(ViewMarksPanel panel) {
        this.panel = panel;
                
    }

    public ArrayList<ExamResultsDTO> getMarks(StudentDTO student) {
        try {
            ExamService examService = ServerConnector.getServerConnector().getExamService();
            return examService.searchResults(student.getNic());
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ViewMarksController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewMarksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
    
    
}
