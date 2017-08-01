/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.dto.AdministrativeDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.SuperDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import edu.ijse.lms.service.custom.UserAccountService;
import edu.ijse.lms.view.admin.AdminHome;
import edu.ijse.lms.view.common.CreateAccountForm;
import edu.ijse.lms.view.custom.GUIFactory;
import edu.ijse.lms.view.custom.GUISuper;
import edu.ijse.lms.view.common.Login;
import edu.ijse.lms.view.student.StudentHome;

/**
 *
 * @author Pahansith
 */
public class LoginController {

    private static Login login;

    public LoginController(Login login) {
        LoginController.login = login;
    }

    public static void createAccount() {
        login.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateAccountForm accountForm = new CreateAccountForm();
                    AccountCreateController ac = new AccountCreateController(accountForm);
                    accountForm.setVisible(true);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public static void loginUser() {
        try {
            UserAccountDTO accountDTO = login.getUser();
            
            UserAccountService userAccountService = ServerConnector.getServerConnector().getUserAccountService();
            UserAccountDTO loginUser = userAccountService.loginUser(accountDTO);
            if (loginUser == null) {
                login.showError("No Such Account Please Register or Contact Admin");
                return ;
            }else{
                
            }
            GUISuper gui = GUIFactory.getInstance().getGui(loginUser.getType());

            if (gui instanceof AdminHome) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new AdminHome(loginUser.getAdminAccount()).setVisible(true);
                            login.dispose();
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } else if (gui instanceof StudentHome) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new StudentHome(loginUser.getStudentAccount()).setVisible(true);
                            login.dispose();
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

            /*try {
            
            login.showError("Server not Found");
            } catch (IOException ex) {
            login.showError("User Data not Found");
            }*/
        } catch (NotBoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
