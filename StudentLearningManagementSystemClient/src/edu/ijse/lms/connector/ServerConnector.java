/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.AssignmentService;
import edu.ijse.lms.service.custom.BatchService;
import edu.ijse.lms.service.custom.CourseService;
import edu.ijse.lms.service.custom.ExamService;
import edu.ijse.lms.service.custom.StudentService;
import edu.ijse.lms.service.custom.SubjectService;
import edu.ijse.lms.service.custom.UserAccountService;

/**
 *
 * @author Pahansith
 */
public class ServerConnector {
    private static ServerConnector serverConnector;
    
    private final ExamService examService;
    private final AssignmentService assignmentService;
    private final BatchService batchService;
    private final CourseService courseService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final UserAccountService userAccountService;
    
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        ServiceFactory serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:3450/LMSServer");
        examService = (ExamService) serviceFactory.getService(ServiceFactory.ServiceTypes.EXAM);
        assignmentService = (AssignmentService) serviceFactory.getService(ServiceFactory.ServiceTypes.ASSIGNMENT);
        batchService = (BatchService) serviceFactory.getService(ServiceFactory.ServiceTypes.BATCH);
        courseService = (CourseService) serviceFactory.getService(ServiceFactory.ServiceTypes.COURSE);
        studentService = (StudentService) serviceFactory.getService(ServiceFactory.ServiceTypes.STUDENT);
        subjectService = (SubjectService) serviceFactory.getService(ServiceFactory.ServiceTypes.SUBJECT);
        userAccountService = (UserAccountService) serviceFactory.getService(ServiceFactory.ServiceTypes.USERACCOUNT);
    }
    
    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }
    
    public ExamService getExamService(){
        return  examService;
    }
    
    public AssignmentService getAssignmentService(){
        return  assignmentService;
    }
    
    public BatchService getBatchService(){
        return  batchService;
    }
    
    public CourseService getCourseService(){
        return  courseService;
    }
    
    public StudentService getStudentService(){
        return  studentService;
    }
    
    public SubjectService getSubjectService(){
        return  subjectService;
    }
    
    public UserAccountService getUserAccountService(){
        return userAccountService;
    }
}
