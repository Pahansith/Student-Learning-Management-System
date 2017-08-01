/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.business.BusinessFactory;
import edu.ijse.lms.business.custom.ExamBusiness;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.ExamAttendanceDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.ExamResultsDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import edu.ijse.lms.dto.SubjectDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ijse.lms.observer.ExamInfoObserver;
import edu.ijse.lms.observer.FaceExamObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.observer.TriggerExamObserver;
import edu.ijse.lms.reservation.ExamReserver;
import edu.ijse.lms.service.custom.ExamService;

/**
 *
 * @author Pahansith
 */
public class ExamServiceImpl extends UnicastRemoteObject implements ExamService, Subject<Object> {

    //Dependacy Injection
    ExamBusiness business = (ExamBusiness) BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.EXAM);

    
    private static final ExamReserver examReserver = new ExamReserver();
    private static final ArrayList<TriggerExamObserver> triggerExamObserverList = new ArrayList<>();
    private static final ArrayList<ExamResultsDTO> studentResults = new ArrayList<>();
    
    private static final HashMap<BatchDTO, ArrayList<ExamQuestionDTO>> examQuestionMap = new HashMap<>();
    private static final HashMap<BatchDTO, ExamDTO> activatedExamsMap = new HashMap<>();
    private static final HashMap<BatchDTO, ArrayList<ExamAttendanceDTO>> examAttendanceMap = new HashMap<>();
    private static final HashMap<BatchDTO, ArrayList<FaceExamObserver>> faceExamObserverMap = new HashMap<>();
    private static final HashMap<BatchDTO, ArrayList<ExamInfoObserver>> examInfoObserverMap = new HashMap<>();
    private long timeFromMiliSeconds;

    public ExamServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean add(ExamDTO t) throws RemoteException, IOException {
        return business.add(t);
    }

    @Override
    public void triggerExam(ExamDTO exam, BatchDTO batch) throws RemoteException, IOException {
        ArrayList<FaceExamObserver> observerList = faceExamObserverMap.get(batch);
        ArrayList<ExamQuestionDTO> questionList = examQuestionMap.get(batch);
        ArrayList<ExamAttendanceDTO> attendStudentList = examAttendanceMap.get(batch);

        HashMap<FaceExamObserver, ArrayList<ExamQuestionDTO>> questionMap = business.startExam(observerList, questionList, attendStudentList, exam);
        activatedExamsMap.remove(batch);
        startCountDown(exam);
        notifyAllObservers(questionMap);
    }

    @Override
    public boolean update(ExamDTO t) throws RemoteException, IOException {
        return business.update(t);
    }

    @Override  // String key, string value
    public ExamDTO search(String t) throws RemoteException, IOException {
        return business.search(t);
    }

    @Override
    public boolean delete(String t) throws RemoteException, IOException {
        return business.delete(t);
    }

    @Override
    public ArrayList<ExamDTO> getAll() throws RemoteException, IOException {
        return business.getAll();
    }

    @Override
    public boolean addQuestion(ExamQuestionDTO question) throws RemoteException, IOException {
        return business.addQuestion(question);
    }

    @Override
    public boolean attendExam(StudentDTO student) throws RemoteException, IOException {
        boolean attendExam = business.attendExam(student);
        if (attendExam) {
            ExamAttendanceDTO examAttendanceDTO = new ExamAttendanceDTO(student.getName(), student.getNic(), new SimpleDateFormat("hh:mm").format(new Date()));
            ArrayList<ExamAttendanceDTO> attendanceList = examAttendanceMap.get(student.getBatch());
            if (attendanceList == null) {
                attendanceList = new ArrayList<>();
            }
            attendanceList.add(examAttendanceDTO);
            examAttendanceMap.put(student.getBatch(), attendanceList);
            notifyAllObservers(student);
        }
        return attendExam;
    }


    /*
    Observer methods
     */
    @Override
    public void notifyAllObservers(Object anObject) throws RemoteException {
        if (anObject instanceof StudentDTO) {
            StudentDTO student = (StudentDTO) anObject;
            for (TriggerExamObserver triggerExamObserver : triggerExamObserverList) {
                triggerExamObserver.update(student);//Update the Admin Client When student press attend button
            }
        } else if (anObject instanceof HashMap) {
            HashMap<FaceExamObserver, ArrayList<ExamQuestionDTO>> map = (HashMap) anObject;
            for (Map.Entry<FaceExamObserver, ArrayList<ExamQuestionDTO>> ob : map.entrySet()) {
                FaceExamObserver observer = ob.getKey();
                ArrayList<ExamQuestionDTO> examQuestionList = ob.getValue();
                observer.update(examQuestionList);
            }
        } else if (anObject instanceof ExamDTO) {
            ExamDTO exam = (ExamDTO) anObject;
            for (Map.Entry<BatchDTO, ArrayList<FaceExamObserver>> ob : faceExamObserverMap.entrySet()) {
                BatchDTO batch = ob.getKey();
                
                if (exam.getBatch().equals(batch)) {
                    ArrayList<FaceExamObserver> observerList = ob.getValue();
                    
                    for (FaceExamObserver faceExamObserver : observerList) {
                        faceExamObserver.endExam();
                    }
                }

            }
            
            for (TriggerExamObserver triggerExamObserver : triggerExamObserverList) {
                triggerExamObserver.update(exam);
            }
        }
    }

    @Override
    public void registerObserver(Object observer) throws RemoteException {
        if (observer instanceof TriggerExamObserver) {
            TriggerExamObserver ob = (TriggerExamObserver) observer;
            triggerExamObserverList.add(ob);
        }

    }

    @Override
    public void unregisterObserver(Object observer) throws RemoteException {
        if (observer instanceof TriggerExamObserver) {
            TriggerExamObserver ob = (TriggerExamObserver) observer;
            triggerExamObserverList.remove(ob);
        }
    }

    @Override
    public void registerSpecificObserver(Object observer, Object identifier) throws RemoteException {
        if (observer instanceof FaceExamObserver) {
            FaceExamObserver faceExamObserver = (FaceExamObserver) observer;
            if (identifier instanceof BatchDTO) {
                BatchDTO batch = (BatchDTO) identifier;

                ArrayList<FaceExamObserver> observerList = faceExamObserverMap.get(batch);
                if (observerList == null) {
                    observerList = new ArrayList<>();
                }
                observerList.add(faceExamObserver);
                faceExamObserverMap.put(batch, observerList);

            }
        } else if (observer instanceof ExamInfoObserver) {
            ExamInfoObserver examInfoObserver = (ExamInfoObserver) observer;
            if (identifier instanceof BatchDTO) {
                BatchDTO batch = (BatchDTO) identifier;

                ArrayList<ExamInfoObserver> observerList = examInfoObserverMap.get(batch);
                if (observerList == null) {
                    observerList = new ArrayList<>();
                }
                observerList.add(examInfoObserver);
                examInfoObserverMap.put(batch, observerList);

            }
        }
    }

    @Override
    public void unregisterSpecificObserver(Object observer, Object identifier) throws RemoteException {
        if (observer instanceof FaceExamObserver) {
            FaceExamObserver faceExamObserver = (FaceExamObserver) observer;
            if (identifier instanceof BatchDTO) {
                BatchDTO batch = (BatchDTO) identifier;

                ArrayList<FaceExamObserver> observerList = faceExamObserverMap.get(batch);
                if (observerList == null) {
                    return;
                }
                observerList.remove(faceExamObserver);
                faceExamObserverMap.put(batch, observerList);
            }
        } else if (observer instanceof ExamInfoObserver) {
            ExamInfoObserver examInfoObserver = (ExamInfoObserver) observer;
            if (identifier instanceof BatchDTO) {
                BatchDTO batch = (BatchDTO) identifier;

                ArrayList<ExamInfoObserver> observerList = examInfoObserverMap.get(batch);
                if (observerList == null) {
                    observerList = new ArrayList<>();
                }
                observerList.remove(examInfoObserver);
                examInfoObserverMap.put(batch, observerList);

            }
        }
    }

    @Override
    public void notifySpecificObservers(Object anObject, Object identifier) throws RemoteException {
        if (anObject instanceof ExamDTO && examInfoObserverMap.containsKey((BatchDTO) identifier)) {
            ArrayList<ExamInfoObserver> observerList = examInfoObserverMap.get((BatchDTO) identifier);
            ExamDTO exam = (ExamDTO) anObject;
            if (observerList != null && !observerList.isEmpty()) {
                for (ExamInfoObserver examInfoObserver : observerList) {
                    examInfoObserver.update(exam);
                }
            }

        }
    }

    /**
     *
     * @param exam
     * @throws RemoteException
     * @throws IOException
     *
     * synchronized
     */
    @Override
    public void activateExam(ExamDTO exam) throws RemoteException, IOException {
        notifySpecificObservers(exam, exam.getBatch());
        activatedExamsMap.put(exam.getBatch(), exam);
        ArrayList<ExamQuestionDTO> questionList = business.activateExam(exam);
        examQuestionMap.put(exam.getBatch(), questionList);
    }

    @Override
    public ExamDTO getActivatedExams(BatchDTO batch) throws RemoteException, IOException {
        return activatedExamsMap.get(batch);
    }

    @Override
    public ArrayList<ExamDTO> getAllAcivatedExamList() throws RemoteException, IOException {
        ArrayList<ExamDTO> examList = new ArrayList<>();
        for (Map.Entry<BatchDTO, ExamDTO> entry : activatedExamsMap.entrySet()) {
            ExamDTO value = entry.getValue();
            examList.add(value);
        }
        return examList;
    }

    @Override
    public HashMap<BatchDTO, ArrayList<ExamAttendanceDTO>> getExamAttendanceMap() throws RemoteException, IOException {
        return examAttendanceMap;
    }

    @Override
    public ArrayList<ExamDTO> searchUpcommingExams(BatchDTO batch) throws RemoteException, IOException {
        return business.searchUpcommingExams(batch);
    }

    private void terminateExam(ExamDTO exam) {
        try {
            notifyAllObservers(exam);
        } catch (RemoteException ex) {
            Logger.getLogger(ExamServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void startCountDown(ExamDTO exam) {
        if (exam.getDuration().contains("H")) {
            timeFromMiliSeconds = Long.parseLong(exam.getDuration().split("H")[0]) * 60 * 60 * 1000;
        }else if(exam.getDuration().contains("M")){
            timeFromMiliSeconds = Long.parseLong(exam.getDuration().split("M")[0]) * 60 * 1000;
        }
        

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeFromMiliSeconds == 0) {
                    terminateExam(exam);
                    t.cancel();
                }
                timeFromMiliSeconds -= 1000;
                System.out.println(timeFromMiliSeconds);
            }
        }, 10, 1000);
    }

    @Override
    public void uploadExamAnswer(ArrayList<StudentExamAnswersDTO> answers) throws RemoteException, IOException {
        ExamResultsDTO studentResult = business.uploadExamAnswer(answers);
        studentResults.add(studentResult);
    }

    @Override
    public boolean reserve(String id) throws RemoteException {
        return examReserver.reserveExam(id, this);
    }

    @Override
    public boolean release(String id) throws RemoteException {
        return examReserver.releaseExam(id, this);
    }

    @Override
    public ArrayList<ExamResultsDTO> getExamResults() throws RemoteException, IOException {
        return studentResults;
    }

    @Override
    public ArrayList<ExamResultsDTO> searchResults(String nic) throws RemoteException, IOException {
        return business.searchResults(nic);
    }


}
