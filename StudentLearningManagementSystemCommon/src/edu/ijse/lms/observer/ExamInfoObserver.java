/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.observer;

import edu.ijse.lms.dto.ExamDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public interface ExamInfoObserver extends Remote{
    public void update(ExamDTO exam) throws RemoteException;
}
