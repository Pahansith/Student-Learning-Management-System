/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.StudentRegInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.service.custom.BatchService;
import edu.ijse.lms.service.custom.StudentService;
import edu.ijse.lms.view.common.CreateAccountForm;

/**
 *
 * @author Pahansith
 */
public class AccountCreateController {

    private static CreateAccountForm accountForm;

    public static ArrayList<BatchDTO> getBatchDetails() {
        try {
            BatchService batchService = ServerConnector.getServerConnector().getBatchService();
            return batchService.getAll();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            accountForm.showError("Coudn't Retrive Data from DB");
            return null;
        } catch (IOException ex) {
            accountForm.showError("Coudn't Retrive Data from DB");
            return null;
        }
    }

    public AccountCreateController(CreateAccountForm accountForm) {
        AccountCreateController.accountForm = accountForm;
    }

    public static void signUp() {
        try {
            StudentRegInfo regInfo = accountForm.collectData();
            if (regInfo.getPassword().equals(regInfo.getConfPassword())) {
                StudentService studentService = ServerConnector.getServerConnector().getStudentService();
                boolean registerStudent = studentService.registerStudent(regInfo);
                if (registerStudent) {
                    accountForm.showMessage("Registered Successfully");
                } else {
                    accountForm.showMessage("Cannot Register");
                }
            }else{
                accountForm.showError("Password and Confirmation Password didn't match");
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            accountForm.showError("Error Occured");

        } catch (IOException ex) {
            accountForm.showError("Error Occured");

        }
    }

}
