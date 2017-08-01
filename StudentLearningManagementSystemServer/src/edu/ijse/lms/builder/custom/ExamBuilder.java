/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder.custom;

import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class ExamBuilder extends DTOBuilder{

    private final String examId;
    private final String name;
    private final int numberOfQuestions;
    private final int totalMarks;
    private final String duration;
    private final String date;
    private final String batchId;
    private final String subjectId;
    
    public ExamBuilder(String examId, String name, int numberOfQuestions, int totalMarks, String duration, String date, String batchId, String subjectId){
        this.examId = examId;
        this.name = name;
        this.numberOfQuestions = numberOfQuestions;
        this.totalMarks = totalMarks;
        this.duration = duration;
        this.date = date;
        this.batchId = batchId;
        this.subjectId = subjectId;
    }
    
    

    @Override
    public void initAttributes() throws RemoteException, IOException {
        createNewExam();
        ExamDTO exam = (ExamDTO)superDto;
        exam.setDate(date);
        exam.setDuration(duration);
        exam.setExamId(examId);
        exam.setName(name);
        exam.setNumberOfQuestions(numberOfQuestions);
        exam.setTotalMarks(totalMarks);
        
        exam.setBatch((BatchDTO) factory.getDao(DaoFactory.DaoTypes.BATCH).search(batchId));
        exam.setSubject((SubjectDTO) factory.getDao(DaoFactory.DaoTypes.SUBJECT).search(subjectId));
        
    }
    
}
