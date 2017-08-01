/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.business.custom.impl;

import edu.ijse.lms.business.custom.ExamBusiness;
import edu.ijse.lms.other.IDGenerator;
import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.dao.custom.BatchDao;
import edu.ijse.lms.dao.custom.ExamDao;
import edu.ijse.lms.dao.custom.SubjectDao;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.observer.FaceExamObserver;

/**
 *
 * @author Pahansith
 */
public class ExamBusinessImpl implements ExamBusiness {

    //Dependancies
    ExamDao examDao = (ExamDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.EXAM);

    public ExamBusinessImpl() {
        try {
            examDao.loadData();
        } catch (IOException ex) {
            //ReportError
            Logger.getLogger(ExamBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(ExamDTO t) throws RemoteException, IOException {

        String lastExamId = getLastExamId();
        String nextId = IDGenerator.getNextId(lastExamId, "E");
        t.setExamId(nextId);
        return examDao.add(t);
    }

    @Override
    public boolean update(ExamDTO t) throws RemoteException, IOException {

        return examDao.update(t);
    }

    @Override
    public ExamDTO search(String t) throws RemoteException, IOException {

        return examDao.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {

        return examDao.delete(t);
    }

    @Override
    public ArrayList<ExamDTO> getAll() throws RemoteException, IOException {
        return examDao.getAll();
    }

    @Override
    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException {

        String lastQuestionId = examDao.getLastQuestionId();
        IDGenerator.getNextId(lastQuestionId, "Q");
        return examDao.addQuestion(question);
    }

    private String getLastExamId() throws RemoteException, IOException {

        return examDao.getLastExamId();
    }

    @Override
    public boolean attendExam(StudentDTO student) throws RemoteException, IOException {

        return examDao.attendExam(student);
    }

    @Override
    public ArrayList<ExamQuestionDTO> activateExam(ExamDTO exam) throws RemoteException, IOException {

        return examDao.activateExam(exam);
    }

    @Override
    public HashMap<FaceExamObserver, ArrayList<ExamQuestionDTO>> startExam(ArrayList<FaceExamObserver> observerList,
            ArrayList<ExamQuestionDTO> questionList, ArrayList<ExamAttendanceDTO> attendStudentList, ExamDTO exam) throws RemoteException, IOException {

        int numberOfQuestions = exam.getNumberOfQuestions();
        HashMap<FaceExamObserver, ArrayList<ExamQuestionDTO>> questionMap = new HashMap<>();
        if (observerList != null && !observerList.isEmpty()) {
            for (FaceExamObserver observer : observerList) {

                ArrayList<ExamQuestionDTO> questions = new ArrayList<>();
                LinkedHashSet<Integer> differenceNumbers = getDifferenceNumbers(questionList.size(), numberOfQuestions);
                Iterator<Integer> itr = differenceNumbers.iterator();

                while (itr.hasNext()) {
                    Integer next = itr.next();
                    ExamQuestionDTO question = questionList.get(next);
                    questions.add(question);
                }
                questionMap.put(observer, questions);

            }
        }

        return questionMap;
    }

    private LinkedHashSet<Integer> getDifferenceNumbers(int totalQuestionsInBank, int numberOfQuestionsPerPaper) {
        Random rand = new Random();
        LinkedHashSet<Integer> generator = new LinkedHashSet<>();
        while (generator.size() < numberOfQuestionsPerPaper) {
            Integer next = rand.nextInt(totalQuestionsInBank);
            generator.add(next);
        }
        return generator;

    }

    @Override
    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch) throws RemoteException, IOException {
        return examDao.searchUpcommingExams(batch);
    }

    @Override
    public ExamResultsDTO uploadExamAnswer(ArrayList<StudentExamAnswersDTO> answerList) throws RemoteException, IOException {
        ExamResultsDTO generateResults = generateResults(answerList);
        examDao.saveStudentResults(generateResults);
        return generateResults;
        
    }

    private ExamResultsDTO generateResults(ArrayList<StudentExamAnswersDTO> answerList) {
        int correctAnswers = 0;
        ExamDTO exam = answerList.get(0).getExam();
        StudentDTO student = answerList.get(0).getStudent();
        for (StudentExamAnswersDTO answer : answerList) {
            if (answer.getCorrectCount() == 5) {
                correctAnswers++;
            }

        }

        int numberOfQuestions = exam.getNumberOfQuestions();
        int totalMarks = exam.getTotalMarks();

        int marksPerQuestion = totalMarks / numberOfQuestions;
        int studentMarks = marksPerQuestion * correctAnswers;

        char grade = generateGrade(studentMarks);

        ExamResultsDTO examResultsDTO = new ExamResultsDTO(studentMarks, grade);
        examResultsDTO.setExam(exam);
        examResultsDTO.setStudent(student);
        
        return examResultsDTO;
    }

    private char generateGrade(int studentMarks) {
        char grade;
        if (studentMarks >= 75) {
            grade = 'A';
        } else if (studentMarks >= 65) {
            grade = 'B';
        } else if (studentMarks >= 55) {
            grade = 'C';
        } else if (studentMarks >= 45) {
            grade = 'S';
        } else {
            grade = 'F';
        }
        return grade;
    }

    @Override
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException {
        return examDao.searchResults(nic);
    }

}
