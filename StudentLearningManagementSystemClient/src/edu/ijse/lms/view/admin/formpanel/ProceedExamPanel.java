/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.admin.formpanel;

import edu.ijse.lms.controller.ProceedExamController;
import edu.ijse.lms.dto.ExamDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.ijse.lms.view.admin.AdminHome;

/**
 *
 * @author Pahansith
 */
public class ProceedExamPanel extends javax.swing.JPanel {

    private ArrayList<ExamDTO> examList;
    public AdminHome home;
    private final ProceedExamController proceedExamController;
    private int index;
    private static boolean isOneReserve;

    public ProceedExamPanel(AdminHome home) {
        initComponents();
        this.home = home;
        proceedExamController = new ProceedExamController(this);
        setBounds(0, 0, 800, 630);
        loadAvailableExams();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        examNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        subjectField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        marksField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        batchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 630));
        setLayout(null);

        examNameField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(examNameField);
        examNameField.setBounds(190, 50, 210, 30);

        jLabel2.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date");
        add(jLabel2);
        jLabel2.setBounds(90, 100, 80, 30);

        jLabel3.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Subject");
        add(jLabel3);
        jLabel3.setBounds(480, 50, 80, 30);

        jLabel5.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Duration");
        add(jLabel5);
        jLabel5.setBounds(70, 150, 100, 30);

        durationField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(durationField);
        durationField.setBounds(190, 150, 210, 30);

        jLabel7.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Marks");
        add(jLabel7);
        jLabel7.setBounds(470, 150, 90, 30);

        subjectField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(subjectField);
        subjectField.setBounds(600, 50, 180, 30);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(210, 480, 120, 40);

        addButton.setText("Activate");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton);
        addButton.setBounds(40, 480, 150, 40);

        jLabel8.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Exam Name");
        add(jLabel8);
        jLabel8.setBounds(50, 50, 120, 30);

        jLabel9.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Number of Questions");
        add(jLabel9);
        jLabel9.setBounds(10, 200, 160, 30);

        questionField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(questionField);
        questionField.setBounds(190, 200, 210, 30);

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Name", "Date", "Batch", "Subject"
            }
        ));
        examTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(examTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 270, 750, 140);

        jLabel4.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Batch");
        add(jLabel4);
        jLabel4.setBounds(480, 100, 80, 30);

        marksField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(marksField);
        marksField.setBounds(600, 150, 180, 30);

        dateField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(dateField);
        dateField.setBounds(190, 100, 210, 30);

        batchField.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        add(batchField);
        batchField.setBounds(600, 100, 180, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean reserveExam = proceedExamController.reserveExam(examList.get(index).getExamId());
        if (reserveExam) {
            if (!isOneReserve) {
                isOneReserve = true;
                proceedExamController.proceedExam(examList.get(index));
            }else{
                JOptionPane.showMessageDialog(this, "One admin can monitor only one exam at a time");
            }

        } else {
            JOptionPane.showMessageDialog(this, "This exam was reserverd by other Admin");
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void examTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examTableMouseClicked
        index = examTable.getSelectedRow();
        if (index != -1) {
            proceedExamController.getTableValue(index);
        }
    }//GEN-LAST:event_examTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField batchField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextField durationField;
    private javax.swing.JTextField examNameField;
    private javax.swing.JTable examTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marksField;
    private javax.swing.JTextField questionField;
    private javax.swing.JTextField subjectField;
    // End of variables declaration//GEN-END:variables

    private void loadAvailableExams() {
        proceedExamController.loadAvailableExams();
    }

    public void loadTable(ArrayList<ExamDTO> examList) {
        this.examList = examList;
        if (examList.size() > 0) {
            DefaultTableModel model = (DefaultTableModel) examTable.getModel();
            model.setRowCount(0);
            for (ExamDTO examDTO : examList) {
                Object[] rowData = {examDTO.getName(), examDTO.getDate(), examDTO.getBatch().getBatchNumber(), examDTO.getSubject().getName()};
                model.addRow(rowData);
            }
        }

    }

    public void setValues(int index) {
        ExamDTO selectedExam = examList.get(index);

        examNameField.setText(selectedExam.getName());
        subjectField.setText(selectedExam.getSubject().getName());
        dateField.setText(selectedExam.getDate());
        batchField.setText(Integer.toString(selectedExam.getBatch().getBatchNumber()));
        examNameField.setText(selectedExam.getName());
        durationField.setText(selectedExam.getDuration());
        marksField.setText(Integer.toString(selectedExam.getTotalMarks()));
        questionField.setText(Integer.toString(selectedExam.getNumberOfQuestions()));
    }

}
