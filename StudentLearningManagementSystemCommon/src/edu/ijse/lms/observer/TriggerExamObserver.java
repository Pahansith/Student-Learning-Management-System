/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.observer;

import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.StudentDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public interface TriggerExamObserver extends Remote{
    public void update(StudentDTO student) throws RemoteException;
    public void update(ExamDTO exam) throws RemoteException;
}
