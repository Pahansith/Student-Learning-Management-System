/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder.custom;

import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Pahansith
 */
public class ExamQuestionBuilder extends DTOBuilder{

    private String question;
    private String[] answerList;
    private boolean[] correct;
    private String questionId;
    
    private String subjectId;
    public ExamQuestionBuilder(String question, String[] answerList, boolean[] correct,String subjectId,String questionId) {
        this.question = question;
        this.answerList = answerList;
        this.correct = correct;
        this.subjectId = subjectId;
        this.questionId = questionId;
    }

    
    @Override
    public void initAttributes() throws RemoteException, IOException {
        createNewExamQuestion();
        ExamQuestionDTO examQuestion = (ExamQuestionDTO)superDto;
        examQuestion.setAnswerList(answerList);
        examQuestion.setCorrect(correct);
        examQuestion.setQuestion(question);
        examQuestion.setQuestionId(questionId);
        
        examQuestion.setSubject((SubjectDTO) factory.getDao(DaoFactory.DaoTypes.SUBJECT).search(subjectId));
    }
    
}
