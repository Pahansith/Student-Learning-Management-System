/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.dto;

import java.util.Objects;

/**
 *
 * @author Pahansith
 */
public class ExamDTO extends SuperDTO implements Comparable<ExamDTO> {

    private String examId;
    private String name;
    private int numberOfQuestions;
    private int totalMarks;
    private String duration;
    private String date;

    private BatchDTO batch;
    private SubjectDTO subject;

    public ExamDTO() {
    }

    public ExamDTO(String examId, String name, int numberOfQuestions, int totalMarks, String duration, String date) {
        this.examId = examId;
        this.name = name;
        this.numberOfQuestions = numberOfQuestions;
        this.totalMarks = totalMarks;
        this.duration = duration;
        this.date = date;
    }

    public ExamDTO(String examId, String name, int numberOfQuestions, int totalMarks, String duration, String date, BatchDTO batch, SubjectDTO subject) {
        this.examId = examId;
        this.name = name;
        this.numberOfQuestions = numberOfQuestions;
        this.totalMarks = totalMarks;
        this.duration = duration;
        this.date = date;
        this.batch = batch;
        this.subject = subject;
    }

    @Override
    public int compareTo(ExamDTO o) {
        return o.getExamId().compareTo(this.getExamId());
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof ExamDTO) {
            return ((ExamDTO) ob).getExamId().equals(this.getExamId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.getExamId());
        return hash;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the examId
     */
    public String getExamId() {
        return examId;
    }

    /**
     * @param examId the examId to set
     */
    public void setExamId(String examId) {
        this.examId = examId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numberOfQuestions
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * @param numberOfQuestions the numberOfQuestions to set
     */
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    /**
     * @return the totalMarks
     */
    public int getTotalMarks() {
        return totalMarks;
    }

    /**
     * @param totalMarks the totalMarks to set
     */
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the batch
     */
    public BatchDTO getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }

    /**
     * @return the subject
     */
    public SubjectDTO getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

}
