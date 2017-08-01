/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.custom.impl;

import edu.ijse.lms.builder.BuilderManager;
import edu.ijse.lms.builder.custom.ExamBuilder;
import edu.ijse.lms.builder.custom.ExamQuestionBuilder;
import edu.ijse.lms.builder.custom.ExamResultsBuilder;
import edu.ijse.lms.dao.connection.DataListConnection;
import edu.ijse.lms.dao.custom.ExamDao;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.SuperDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.secure.SecureData;

/**
 *
 * @author Pahansith
 */
public class ExamDaoImpl implements ExamDao {

    private LinkedList<ExamDTO> listOfExams;
    private static LinkedList<ExamQuestionDTO> listOfQuestions;

    public ExamDaoImpl() {
        listOfExams = (LinkedList<ExamDTO>) DataListConnection.getInstance().getExamList();
        listOfQuestions = new LinkedList<>();
    }

    @Override
    public boolean add(ExamDTO t) throws RemoteException, IOException {
        File file = new File("filedb/examdata/Exam.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw, true);
            String data = t.getExamId() + ":" + t.getName() + ":" + t.getNumberOfQuestions() + ":" + t.getTotalMarks() + ":"
                    + t.getDuration() + ":" + t.getDate() + ":" + t.getBatch().getBatchId() + ":" + t.getSubject().getSubjectId();
            //String encryptData = SecureData.encryptData(data, 5);
            pw.println(data);
            listOfExams.add(t);
            Collections.sort(listOfExams);
        }
        return true;
    }

    @Override
    public boolean update(ExamDTO t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExamDTO search(String t) throws RemoteException {
        ExamDTO examDTO = new ExamDTO();
        examDTO.setExamId(t);
        int index = listOfExams.indexOf(examDTO);
        if (index != -1) {
            return listOfExams.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String t) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ExamDTO> getAll() throws RemoteException, IOException {
        loadData();
        ArrayList<ExamDTO> list = new ArrayList();
        listOfExams.stream().forEach((examDTO) -> {
            list.add(examDTO);
        });
        return list;
    }

    @Override
    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException {
        File file = new File("filedb/examdata/Question.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw, true);

            String[] answerList = question.getAnswerList();
            boolean[] corrects = question.getCorrect();

            String answersData = "";
            String correctData = "";
            for (String answer : answerList) {
                answersData += answer + ":";
            }

            for (boolean correct : corrects) {
                correctData += correct + ":";
            }

            
            String data = question.getSubject().getSubjectId() + ":" + question.getQuestion() + ":" + 
                    answersData + correctData+question.getQuestionId();
            //String encryptData = SecureData.encryptData(data, 5);
            pw.println(data);
        }
        return true;

    }

    @Override
    public String getLastExamId() throws RemoteException, IOException {
        if (!listOfExams.isEmpty()) {
            ExamDTO last = listOfExams.getFirst();
            if (last != null) {
                return last.getExamId();
            }
        }
        return null;
    }

    @Override
    public void loadData() throws RemoteException, IOException {
        FileReader fr = null;
        try {
            listOfExams.clear();
            File file = new File("filedb/examdata/Exam.txt");

            if (!file.exists()) {
                return;
            }
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                //line = SecureData.decryptData(line, 5);
                String[] parts = line.split("[:]");
                ExamBuilder examBuilder = new ExamBuilder(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4],
                        parts[5], parts[6], parts[7]);
                ExamDTO exam = (ExamDTO) new BuilderManager(examBuilder).getDTO();
                listOfExams.add(exam);
            }

            fr.close();

            Collections.sort(listOfExams);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean attendExam(StudentDTO student) throws RemoteException, IOException {
        File file = new File("filedb/log/StudentExamAttendLog.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw, true);
            
            
            String data = student.getNic();
            //String encryptData = SecureData.encryptData(data, 5);
            pw.println(data);
        }
        return true;
    }

    @Override
    public ArrayList<ExamQuestionDTO> activateExam(ExamDTO exam) throws RemoteException, IOException {
        addExamActivateLog(exam);
        File file = new File("filedb/examdata/Question.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<ExamQuestionDTO> questionList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            //line = SecureData.decryptData(line, 5);
            String[] parts = line.split("[:]");
            if (parts[0].equals(exam.getSubject().getSubjectId())) {
                String questionString = parts[1].replace('$', '\n');

                String[] answers = {parts[2], parts[3], parts[4], parts[5], parts[6]};
                boolean[] correct = {parts[7].contains("true"), parts[8].contains("true"), parts[9].contains("true"), parts[10].contains("true"), parts[11].contains("true")};

                ExamQuestionBuilder builder = new ExamQuestionBuilder(questionString, answers, correct, parts[0], parts[12]);
                ExamQuestionDTO question = (ExamQuestionDTO) new BuilderManager(builder).getDTO();
                questionList.add(question);
            }

        }
        return questionList;
    }

    private void addExamActivateLog(ExamDTO exam) throws IOException {
        File file = new File("filedb/log/ActivatedExamsLog.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw, true);

        String data = exam.getExamId() + ":" + exam.getName();
        //String encryptData = SecureData.encryptData(data, 5);
        
        pw.println(data);

    }

    @Override
    public void writeLog(ArrayList<ExamQuestionDTO> questions, ArrayList<ExamAttendanceDTO> students) throws RemoteException, IOException {

    }

    @Override
    public String getLastQuestionId() throws RemoteException, IOException {
        
        loadQuestionData();
        
        if (!listOfQuestions.isEmpty()) {
            ExamQuestionDTO last = listOfQuestions.getLast();
            if (last != null) {
                return last.getQuestionId();
            }
        }
        return null;

    }

    public void loadQuestionData() throws RemoteException, IOException {
        FileReader fr = null;
        try {
            listOfQuestions.clear();
            File file = new File("filedb/examdata/Question.txt");

            if (!file.exists()) {
                return;
            }
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                
                //line = SecureData.decryptData(line, 5);
                String[] parts = line.split("[:]");

                String questionString = parts[1].replace('$', '\n');

                String[] answers = {parts[2], parts[3], parts[4], parts[5], parts[6]};
                boolean[] correct = {parts[7].contains("true"), parts[8].contains("true"), parts[9].contains("true"), parts[10].contains("true"), parts[11].contains("true")};

                ExamQuestionBuilder builder = new ExamQuestionBuilder(questionString, answers, correct, parts[0], parts[12]);
                ExamQuestionDTO question = (ExamQuestionDTO) new BuilderManager(builder).getDTO();
                listOfQuestions.add(question);

            }

            fr.close();

            Collections.sort(listOfExams);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch) throws RemoteException, IOException {
        File file = new File("filedb/examdata/Exam.txt");
        if (!file.exists()) {
            return null;
        }
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<ExamDTO> examList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) { 
            //line = SecureData.decryptData(line, 5);
            String[] parts = line.split("[:]");
            if (parts[6].equals(batch.getBatchId())) {
                ExamBuilder examBuilder = new ExamBuilder(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4], parts[5], parts[6], parts[7]);
                ExamDTO exam = (ExamDTO) new BuilderManager(examBuilder).getDTO();
                examList.add(exam);
            }
        }
        return examList;
    }

    @Override
    public boolean saveStudentResults(ExamResultsDTO results) throws RemoteException, IOException {
        File file = new File("filedb/examdata/ExamResults.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw, true);
            String data = results.getExam().getExamId()+":"+results.getStudent().getNic()+":"+results.getMarks()+":"+results.getGrade();
            //SecureData.encryptData(data, 5);
            pw.println(data);
        }
        return true;
    }
    
    @Override
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException {
        File file = new File("filedb/examdata/ExamResults.txt");
        if (!file.exists()) {
            return null;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<ExamResultsDTO> resultList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) { 
            //line = SecureData.decryptData(line, 5);
            String[] parts = line.split("[:]");
            if (parts[1].equals(nic)) {
                ExamResultsBuilder examResultsBuilder = new ExamResultsBuilder(parts[0], parts[1], Double.parseDouble(parts[2]),parts[3].toCharArray()[0]);
                ExamResultsDTO dto = (ExamResultsDTO) new BuilderManager(examResultsBuilder).getDTO();
                resultList.add(dto);
            }
        }
        return resultList;
    }

}
