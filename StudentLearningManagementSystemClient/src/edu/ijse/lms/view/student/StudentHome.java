/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.student;

import edu.ijse.lms.controller.StudentController;
import edu.ijse.lms.dto.StudentDTO;
import javax.swing.JPanel;
import edu.ijse.lms.view.custom.GUISuper;
import edu.ijse.lms.view.student.formpanel.ExamInfoPanel;
import edu.ijse.lms.view.student.formpanel.FaceExamPanel;
import edu.ijse.lms.view.student.panel.StudentExamOptionsPanel;

/**
 *
 * @author Pahansith
 */
public class StudentHome extends javax.swing.JFrame implements GUISuper{

    private StudentDTO student;
    private StudentController studentController;
    /**
     * Creates new form StudentHome
     * @param student
     */
    public StudentHome(StudentDTO student) {
        initComponents();
        this.student = student;
        setStudentName();
        studentController = new StudentController(this);
    }
    
    public StudentHome(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        studentLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        batchLabel = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        loadPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        graphPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        graphPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        graphPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        optionsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(990, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(990, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 700));
        jPanel1.setLayout(null);

        ButtonPanel.setBackground(new java.awt.Color(1, 179, 227));
        ButtonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentLabel.setForeground(new java.awt.Color(1, 234, 226));
        studentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel.setText("Profile");
        studentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentLabelMouseExited(evt);
            }
        });
        ButtonPanel.add(studentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 234, 226));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exam");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        ButtonPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 50));

        studentNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentNameLabel.setForeground(new java.awt.Color(82, 74, 167));
        studentNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentNameLabel.setText("asdsadsad");
        ButtonPanel.add(studentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 170, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 234, 226));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Subjects");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 60));

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        batchLabel.setForeground(new java.awt.Color(82, 74, 167));
        batchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        batchLabel.setText("Batch 12");
        ButtonPanel.add(batchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 70, 30));

        label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label.setForeground(new java.awt.Color(82, 74, 167));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Logged in As");
        ButtonPanel.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 110, 30));

        jPanel1.add(ButtonPanel);
        ButtonPanel.setBounds(0, 70, 190, 630);

        loadPanel.setBackground(new java.awt.Color(255, 255, 255));
        loadPanel.setForeground(new java.awt.Color(51, 51, 51));
        loadPanel.setMinimumSize(new java.awt.Dimension(800, 630));
        loadPanel.setPreferredSize(new java.awt.Dimension(800, 630));
        loadPanel.setLayout(null);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/admin/image/Home.jpg"))); // NOI18N
        loadPanel.add(jLabel19);
        jLabel19.setBounds(20, 20, 760, 390);

        graphPanel3.setBackground(new java.awt.Color(142, 68, 173));
        graphPanel3.setMinimumSize(new java.awt.Dimension(276, 128));
        graphPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Anadi", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(203, 180, 213));
        jLabel16.setText("Face an Exam");
        graphPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, 120, 29));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setOpaque(true);
        graphPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 3));

        jLabel18.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(203, 180, 213));
        jLabel18.setText("attend and complete exam");
        graphPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, -1));

        loadPanel.add(graphPanel3);
        graphPanel3.setBounds(40, 470, 230, 128);

        graphPanel5.setBackground(new java.awt.Color(65, 131, 215));
        graphPanel5.setMinimumSize(new java.awt.Dimension(276, 128));
        graphPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Anadi", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(157, 205, 234));
        jLabel22.setText("View your Achievements");
        graphPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, 180, 29));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setOpaque(true);
        graphPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 3));

        jLabel25.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(144, 198, 237));
        jLabel25.setText("view your grades and results");
        graphPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, -1));

        loadPanel.add(graphPanel5);
        graphPanel5.setBounds(290, 470, 230, 128);

        graphPanel4.setBackground(new java.awt.Color(255, 184, 73));
        graphPanel4.setMinimumSize(new java.awt.Dimension(276, 128));
        graphPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setOpaque(true);
        graphPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 3));

        jLabel21.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(239, 253, 140));
        jLabel21.setText("take time to look");
        graphPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Anadi", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(239, 253, 140));
        jLabel26.setText("Profile");
        graphPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, 86, 29));

        loadPanel.add(graphPanel4);
        graphPanel4.setBounds(530, 470, 230, 128);

        jPanel1.add(loadPanel);
        loadPanel.setBounds(190, 70, 800, 630);

        optionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionsPanel.setLayout(null);
        jPanel1.add(optionsPanel);
        optionsPanel.setBounds(190, 0, 800, 70);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/lms/view/student/image/LabelModel.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 190, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseClicked
        
    }//GEN-LAST:event_studentLabelMouseClicked

    private void studentLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseEntered
        
    }//GEN-LAST:event_studentLabelMouseEntered

    private void studentLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseExited
        
    }//GEN-LAST:event_studentLabelMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        loadPanel.removeAll();
        loadPanel.add(new ExamInfoPanel(this));
        loadPanel.repaint();
        loadPanel.revalidate();
        
        optionsPanel.removeAll();
        optionsPanel.add(new StudentExamOptionsPanel(this));
        optionsPanel.repaint();
        optionsPanel.repaint();
    }//GEN-LAST:event_jLabel4MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JPanel graphPanel3;
    private javax.swing.JPanel graphPanel4;
    private javax.swing.JPanel graphPanel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label;
    public static javax.swing.JPanel loadPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel studentNameLabel;
    // End of variables declaration//GEN-END:variables

    private void setStudentName() {
        studentNameLabel.setText(student.getName());
        batchLabel.setText("Batch "+Integer.toString(student.getBatch().getBatchNumber()));
    }
    
    public StudentDTO getStudent(){
        return this.student;
    }
    
    public JPanel getLoadPanel(){
        return loadPanel;
    }
}