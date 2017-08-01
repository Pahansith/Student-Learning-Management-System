/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.reservation;

import java.util.HashMap;
import edu.ijse.lms.service.custom.ExamService;

/**
 *
 * @author Pahansith
 */
public class ExamReserver {
    private HashMap<String, ExamService> reservedata = new HashMap<>();

    public boolean reserveExam(String id, ExamService examService) {
        if (reservedata.containsKey(id)) {
            return reservedata.get(id) == examService;
        }else{
            reservedata.put(id, examService);
            return true;
        }
    }

    public boolean releaseExam(String id, ExamService examService) {
        if (reservedata.get(id) == examService) {
            reservedata.remove(id);
            return true;
        }
        return false;
    }
}
