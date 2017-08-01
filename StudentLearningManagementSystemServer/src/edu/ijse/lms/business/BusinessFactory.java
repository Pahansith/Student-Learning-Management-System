/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business;

import edu.ijse.lms.business.custom.impl.AdminBusinessImpl;
import edu.ijse.lms.business.custom.impl.AssignmentBusinessImpl;
import edu.ijse.lms.business.custom.impl.BatchBusinessImpl;
import edu.ijse.lms.business.custom.impl.CourseBusinessImpl;
import edu.ijse.lms.business.custom.impl.ExamBusinessImpl;
import edu.ijse.lms.business.custom.impl.StudentBusinessImpl;
import edu.ijse.lms.business.custom.impl.SubjectBusinessImpl;
import edu.ijse.lms.business.custom.impl.UserAccountBusinessImpl;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class BusinessFactory {
    private static BusinessFactory businessFactory;
    
    public enum BusinessTypes{
        EXAM,ASSIGNMENT,STUDENT,COURSE,SUBJECT,BATCH,USERACCOUNT,ADMIN
    }
    
    private BusinessFactory(){
        
    }
    
    public static BusinessFactory getInstance(){
        if (businessFactory == null) {
            businessFactory = new BusinessFactory();
        }
        return businessFactory;
    }
    
    public SuperBusiness getBusiness(BusinessTypes type){
        switch (type) {
            case EXAM:
                return new ExamBusinessImpl();
            case ASSIGNMENT:
                return new AssignmentBusinessImpl();
            case BATCH:
                return new BatchBusinessImpl();
            case COURSE:
                return new CourseBusinessImpl();
            case STUDENT:
                return new StudentBusinessImpl();
            case SUBJECT:
                return new SubjectBusinessImpl();
            case USERACCOUNT:
                return new UserAccountBusinessImpl();
            case ADMIN:
                return new AdminBusinessImpl();
            default:
                return null;
        }
    }
    
    
}
