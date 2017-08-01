/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.SuperService;
import edu.ijse.lms.service.custom.impl.AdminServiceImpl;
import edu.ijse.lms.service.custom.impl.AssignmentServiceImpl;
import edu.ijse.lms.service.custom.impl.BatchServiceImpl;
import edu.ijse.lms.service.custom.impl.CourseServiceImpl;
import edu.ijse.lms.service.custom.impl.ExamServiceImpl;
import edu.ijse.lms.service.custom.impl.StudentServiceImpl;
import edu.ijse.lms.service.custom.impl.SubjectServiceImpl;
import edu.ijse.lms.service.custom.impl.UserAccountServiceImpl;

/**
 *
 * @author Pahansith
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    private static ServiceFactoryImpl serviceFactoryImpl;
    private  ServiceFactoryImpl() throws RemoteException{
        super();
    }
    
    public static ServiceFactoryImpl getInstance() throws RemoteException{
        if (serviceFactoryImpl == null) {
            serviceFactoryImpl = new ServiceFactoryImpl();
        }
        return serviceFactoryImpl;
    }
    

    @Override
    public SuperService getService(ServiceTypes type) throws RemoteException {
        switch (type) {
            case STUDENT:
                return new StudentServiceImpl();
            case ASSIGNMENT:
                return new AssignmentServiceImpl();
            case EXAM:
                return new ExamServiceImpl();
            case BATCH:
                return new BatchServiceImpl();
            case COURSE:
                return new CourseServiceImpl();
            case SUBJECT:
                return new SubjectServiceImpl();
            case USERACCOUNT:
                return new UserAccountServiceImpl();
            case ADMIN:
                return new AdminServiceImpl();
            default:
                return null;
        }
    }
    
    
    
}
