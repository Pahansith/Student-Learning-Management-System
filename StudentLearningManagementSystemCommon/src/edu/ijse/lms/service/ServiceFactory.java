/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public interface ServiceFactory extends Remote{
    public enum ServiceTypes{
        STUDENT,EXAM,ASSIGNMENT,BATCH,COURSE,SUBJECT,USERACCOUNT,ADMIN
    }
    
    public SuperService getService(ServiceTypes type) throws RemoteException;
    
}
