/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.observer.RegistrationObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.service.custom.StudentService;
import edu.ijse.lms.view.admin.formpanel.StudentRegisterLoadPanel;

/**
 *
 * @author Pahansith
 */
public class StudentRegisterController {

    private static StudentRegisterLoadPanel panel;

    
    
    
    public StudentRegisterController(StudentRegisterLoadPanel panel) {
        StudentRegisterController.panel = panel;
    }
    
    public static void getAllRegisterPendingStudents(){
        try {
            StudentService studentService = ServerConnector.getServerConnector().getStudentService();
            LinkedList<StudentRegInfo> allRegisterPendingStudent = studentService.getAllRegisterPendingStudent();
            panel.setStudents(allRegisterPendingStudent);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(StudentRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /*public static boolean approveStudentRegistration(){
    StudentDTO dTO = panel.getStudent();
    }*/

    public boolean registerNewStudent(StudentRegInfo get) {
        
        try {
            StudentService studentService = ServerConnector.getServerConnector().getStudentService();
            boolean approveStudent = studentService.approveStudent(get);
            if (approveStudent) {
                
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(StudentRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
