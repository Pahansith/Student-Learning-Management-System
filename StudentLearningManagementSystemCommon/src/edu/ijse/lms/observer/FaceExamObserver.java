/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.observer;

import edu.ijse.lms.dto.ExamQuestionDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pahansith
 */
public interface FaceExamObserver extends Remote{   
    public void update(ArrayList<ExamQuestionDTO> questionList) throws RemoteException;
    public void endExam() throws RemoteException;
}
