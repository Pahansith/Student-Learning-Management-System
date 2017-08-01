/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.student.panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import edu.ijse.lms.view.admin.AdminHome;
import edu.ijse.lms.view.admin.formpanel.GrantExamPanel;
import edu.ijse.lms.view.admin.formpanel.ProceedExamPanel;
import edu.ijse.lms.view.student.StudentHome;
import edu.ijse.lms.view.student.formpanel.ExamInfoPanel;
import edu.ijse.lms.view.student.formpanel.FaceExamPanel;
import edu.ijse.lms.view.student.formpanel.ViewMarksPanel;

/**
 *
 * @author Pahansith
 */
public class StudentExamOptionsPanel extends javax.swing.JPanel {
    
    private StudentHome home;
    /**
     * Creates new form StudentOptionsPanel
     * @param home
     */
    public StudentExamOptionsPanel(StudentHome home) {
        initComponents();
        this.home = home;
        setBounds(0, 0, 800, 70);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attendExamLabel = new javax.swing.JLabel();
        studentLabel3 = new javax.swing.JLabel();
        studentLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 70));
        setLayout(null);

        attendExamLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        attendExamLabel.setForeground(new java.awt.Color(165, 170, 174));
        attendExamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attendExamLabel.setText("Exam Details");
        attendExamLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        attendExamLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendExamLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                attendExamLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                attendExamLabelMouseExited(evt);
            }
        });
        add(attendExamLabel);
        attendExamLabel.setBounds(0, 0, 130, 70);

        studentLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentLabel3.setForeground(new java.awt.Color(165, 170, 174));
        studentLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel3.setText("Face Exam");
        studentLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentLabel3MouseExited(evt);
            }
        });
        add(studentLabel3);
        studentLabel3.setBounds(130, 0, 130, 70);

        studentLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentLabel1.setForeground(new java.awt.Color(165, 170, 174));
        studentLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel1.setText("View Marks");
        studentLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentLabel1MouseExited(evt);
            }
        });
        add(studentLabel1);
        studentLabel1.setBounds(260, 0, 120, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void attendExamLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendExamLabelMouseEntered
        changeColor(evt);
    }//GEN-LAST:event_attendExamLabelMouseEntered

    private void attendExamLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendExamLabelMouseExited
        setBackColor(evt);
    }//GEN-LAST:event_attendExamLabelMouseExited

    private void studentLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel3MouseEntered
        changeColor(evt);
    }//GEN-LAST:event_studentLabel3MouseEntered

    private void studentLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel3MouseExited
        setBackColor(evt);
    }//GEN-LAST:event_studentLabel3MouseExited

    private void studentLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel1MouseEntered
        changeColor(evt);   
    }//GEN-LAST:event_studentLabel1MouseEntered

    private void studentLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel1MouseExited
        setBackColor(evt);
    }//GEN-LAST:event_studentLabel1MouseExited

    private void studentLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel3MouseClicked
        home.loadPanel.removeAll();
        home.loadPanel.add(new FaceExamPanel(home));
        home.loadPanel.repaint();
        home.loadPanel.revalidate();
    }//GEN-LAST:event_studentLabel3MouseClicked

    private void studentLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabel1MouseClicked
        home.loadPanel.removeAll();
        home.loadPanel.add(new ViewMarksPanel(home));
        home.loadPanel.repaint();
        home.loadPanel.revalidate();
    }//GEN-LAST:event_studentLabel1MouseClicked

    private void attendExamLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendExamLabelMouseClicked
        home.loadPanel.removeAll();
        home.loadPanel.add(new ExamInfoPanel(home));
        home.loadPanel.repaint();
        home.loadPanel.revalidate();
    }//GEN-LAST:event_attendExamLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attendExamLabel;
    private javax.swing.JLabel studentLabel1;
    private javax.swing.JLabel studentLabel3;
    // End of variables declaration//GEN-END:variables
    private void changeColor(MouseEvent evt) {
        javax.swing.JLabel selectedLabel = (javax.swing.JLabel)evt.getSource();
        selectedLabel.setForeground(new Color(2, 150, 220));
        
    }

    private void setBackColor(MouseEvent evt) {
        javax.swing.JLabel selectedLabel = (javax.swing.JLabel)evt.getSource();
        selectedLabel.setForeground(new Color(165,170,174));
    }
}