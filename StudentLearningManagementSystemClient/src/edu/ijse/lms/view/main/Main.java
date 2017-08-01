/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.main;

import edu.ijse.lms.view.common.Login;
import edu.ijse.lms.controller.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pahansith
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Login login = new Login();
                LoginController con = new LoginController(login);
                login.setVisible(true);
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}
