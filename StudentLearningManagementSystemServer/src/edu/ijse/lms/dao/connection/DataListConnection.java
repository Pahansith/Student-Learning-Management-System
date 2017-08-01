/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dao.connection;

import edu.ijse.lms.dto.AdministrativeDTO;
import edu.ijse.lms.dto.AssignmentDTO;
import edu.ijse.lms.dto.BatchDTO;
import edu.ijse.lms.dto.CourseDTO;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.StudentDTO;
import edu.ijse.lms.dto.SubjectDTO;
import edu.ijse.lms.dto.UserAccountDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pahansith
 */
public class DataListConnection {

    private static DataListConnection dataConnection;

    private final LinkedList<ExamDTO> examList;
    private final LinkedList<CourseDTO> courseList;
    private final LinkedList<AssignmentDTO> assignmnetList;
    private final LinkedList<BatchDTO> batchList;
    private final LinkedList<StudentDTO> studentList;
    private final LinkedList<SubjectDTO> subjectList;
    private final LinkedList<AdministrativeDTO> adminList;
    private final LinkedList<UserAccountDTO> accountList;

    private DataListConnection() {
        examList = new LinkedList<>();
        courseList = new LinkedList<>();
        adminList = new LinkedList<>();
        accountList = new LinkedList<>();
        assignmnetList = new LinkedList<>();
        batchList = new LinkedList<>();
        studentList = new LinkedList<>();
        subjectList = new LinkedList<>();
    }

    public static DataListConnection getInstance() {
        if (dataConnection == null) {
            dataConnection = new DataListConnection();
        }
        return dataConnection;
    }

    public List<ExamDTO> getExamList() {
        return examList;
    }

    public List<CourseDTO> getCourseList() {
        return courseList;
    }

    public List<AdministrativeDTO> getAdminList() {
        return adminList;
    }

    public List<UserAccountDTO> getUserAccountList() {
        return accountList;
    }

    public List<AssignmentDTO> getAssignmentList() {
        return assignmnetList;
    }

    public List<BatchDTO> getBatchList() {
        return batchList;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public List<SubjectDTO> getSubjectList() {
        return subjectList;
    }
}
