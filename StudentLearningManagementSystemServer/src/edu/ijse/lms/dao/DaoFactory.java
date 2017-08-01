/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao;

import edu.ijse.lms.dao.custom.impl.AdminDaoImpl;
import edu.ijse.lms.dao.custom.impl.AssignmentDaoImpl;
import edu.ijse.lms.dao.custom.impl.BatchDaoImpl;
import edu.ijse.lms.dao.custom.impl.CourseDaoImpl;
import edu.ijse.lms.dao.custom.impl.ExamDaoImpl;
import edu.ijse.lms.dao.custom.impl.StudentDaoImpl;
import edu.ijse.lms.dao.custom.impl.SubjectDaoImpl;
import edu.ijse.lms.dao.custom.impl.UserAccountDaoImpl;

/**
 *
 * @author Pahansith
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    public enum DaoTypes{
        EXAM, ASSIGNMENT, STUDENT, COURSE, BATCH, SUBJECT, USERACCOUNT, ADMIN
    }
    
    public static DaoFactory getInstance(){
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes type){
        switch (type) {
            case EXAM:
                return new ExamDaoImpl();
            case ASSIGNMENT:
                return new AssignmentDaoImpl();
            case BATCH:
                return new BatchDaoImpl();
            case COURSE:
                return new CourseDaoImpl();
            case STUDENT:
                return new StudentDaoImpl();
            case SUBJECT:
                return new SubjectDaoImpl();
            case USERACCOUNT:
                return new UserAccountDaoImpl();
            case ADMIN:
                return new AdminDaoImpl();
            default:
                return null;
        }
    }
    
}
