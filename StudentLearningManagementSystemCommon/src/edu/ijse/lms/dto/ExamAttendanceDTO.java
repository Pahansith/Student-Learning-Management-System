/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

/**
 *
 * @author Pahansith
 */
public class ExamAttendanceDTO extends SuperDTO{
    
    private String studentName;
    private String studentNic;
    private String time;

    public ExamAttendanceDTO() {
    }

    public ExamAttendanceDTO(String studentName, String studentNic, String time) {
        this.studentName = studentName;
        this.studentNic = studentNic;
        this.time = time;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentNic
     */
    public String getStudentNic() {
        return studentNic;
    }

    /**
     * @param studentNic the studentNic to set
     */
    public void setStudentNic(String studentNic) {
        this.studentNic = studentNic;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    
            
}
