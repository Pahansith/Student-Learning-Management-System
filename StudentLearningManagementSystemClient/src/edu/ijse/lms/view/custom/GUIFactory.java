/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.custom;

import edu.ijse.lms.dto.UserAccountDTO;
import edu.ijse.lms.view.admin.AdminHome;
import edu.ijse.lms.view.student.StudentHome;

/**
 *
 * @author Pahansith
 */
public class GUIFactory {
    
    private static GUIFactory gUIFactory;
    
    
    private GUIFactory(){
        
    }
    
    public static GUIFactory getInstance(){
        if (gUIFactory == null) {
            gUIFactory = new GUIFactory();
        }
        
        return gUIFactory;
    }
    
    public GUISuper getGui(UserAccountDTO.Types type){
        switch (type) {
            case ADMIN:
                return new AdminHome();
            case STUDENT:
                return new StudentHome();
            default:
                return null;
        }
        
    }
    
    
}
