/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.student.formpanel;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.controller.ExamInfoController;
import edu.ijse.lms.controller.FaceExamController;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import edu.ijse.lms.observer.ExamInfoObserver;
import edu.ijse.lms.observer.FaceExamObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.view.student.StudentHome;

/**
 *
 * @author Pahansith
 */
public class ExamInfoPanel extends javax.swing.JPanel implements ExamInfoObserver{

    private StudentHome home;
    private ExamInfoController examInfoController;
    private ExamDTO activatedExam;
    private boolean isAttend = false;
    int index = 0;
    
    
    
    JLabel[] answerFields;
    private JCheckBox[] correctBoxes;
    
    
    public ExamInfoPanel(StudentHome home) {
        try {
            initComponents();
            this.home = home;
            setBounds(0, 0, 800, 630);
            examInfoController = new ExamInfoController(this);
            
            UnicastRemoteObject.exportObject(this, 0);
            Subject<ExamInfoObserver> ob = (Subject<ExamInfoObserver>) ServerConnector.getServerConnector().getExamService();
            ob.registerSpecificObserver(this, home.getStudent().getBatch());
            setActivatedExam();
            loadUpcommingExams();
            
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ExamInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        examInfoLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        numOfQuestionField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subjectField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        totalMarksField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        attendExamLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setPreferredSize(new java.awt.Dimension(800, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        examInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        examInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        examInfoLabel.setText("Today You Have no Exams...!");
        add(examInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 640, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setLayout(null);

        numOfQuestionField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numOfQuestionField.setPreferredSize(new java.awt.Dimension(6, 30));
        numOfQuestionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfQuestionFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numOfQuestionField);
        numOfQuestionField.setBounds(250, 100, 370, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Number of Questions : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 100, 160, 30);

        durationField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        durationField.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel1.add(durationField);
        durationField.setBounds(250, 50, 370, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Duration : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 50, 150, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total Marks : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 150, 160, 30);

        subjectField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subjectField.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel1.add(subjectField);
        subjectField.setBounds(250, 200, 370, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Subject : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 200, 100, 30);

        totalMarksField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalMarksField.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel1.add(totalMarksField);
        totalMarksField.setBounds(250, 150, 370, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Exam Detail");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 0, 150, 40);

        attendExamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attendExamLabel.setText("Attend Exam");
        attendExamLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 3, true));
        attendExamLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendExamLabelMouseClicked(evt);
            }
        });
        jPanel1.add(attendExamLabel);
        attendExamLabel.setBounds(320, 250, 120, 40);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 740, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.setLayout(null);

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Name", "Date", "Number of Questions", "Duration"
            }
        ));
        jScrollPane1.setViewportView(examTable);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 720, 150);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Up Comming Exams");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 0, 210, 40);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 740, 220));
    }// </editor-fold>//GEN-END:initComponents

    

    private void numOfQuestionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfQuestionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numOfQuestionFieldActionPerformed

    private void attendExamLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendExamLabelMouseClicked
        if (!isAttend) {
            examInfoController.attendToExam(home.getStudent());
            isAttend = true;
            loadFaceExamPanel();
            
        }else{
            JOptionPane.showMessageDialog(this, "You Already Attended to Exam", "Already Attended", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_attendExamLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attendExamLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField durationField;
    private javax.swing.JLabel examInfoLabel;
    private javax.swing.JTable examTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nextQuestionLabel;
    private javax.swing.JLabel nextQuestionLabel1;
    private javax.swing.JLabel nextQuestionLabel2;
    private javax.swing.JLabel nextQuestionLabel3;
    private javax.swing.JTextField numOfQuestionField;
    private javax.swing.JTextField subjectField;
    private javax.swing.JTextField totalMarksField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(ExamDTO exam) throws RemoteException {
        JOptionPane.showMessageDialog(this, "You have one exam for attention","Exam Activated",JOptionPane.INFORMATION_MESSAGE);
        this.activatedExam = exam;
        examInfoLabel.setText(exam.getName()+" Is Activated Now!");
        updateTextFields();
    }

    /*@Override
    public void update(ArrayList<ExamQuestionDTO> questionList) throws RemoteException {
    this.qusetionList = questionList;
    
    showNextQuestion(index);
    setAnswers(index);
    loadExamTable();
    }*/

    private void setActivatedExam() {
        activatedExam = examInfoController.getActivatedExam(home.getStudent());
        if (activatedExam != null) {
            examInfoLabel.setText(activatedExam.getName() + " Is Activated now");
            updateTextFields();
        }
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof ExamInfoPanel) {
            return this.home.getStudent().getNic().equals(((ExamInfoPanel) o).home.getStudent().getNic());
        }
        return false;
    }


    private void updateTextFields() {
        durationField.setText(activatedExam.getDuration());
        numOfQuestionField.setText(Integer.toString(activatedExam.getNumberOfQuestions()));
        totalMarksField.setText(Integer.toString(activatedExam.getTotalMarks()));
        subjectField.setText(activatedExam.getSubject().getName());
    }

    private void loadUpcommingExams() {
        ArrayList<ExamDTO> upcomingExams = examInfoController.loadUpcommingExams(home.getStudent().getBatch());
        DefaultTableModel model = (DefaultTableModel) examTable.getModel();
        
        for (ExamDTO upcomingExam : upcomingExams) {
            Object[] rowData ={upcomingExam.getName(),upcomingExam.getDate(),upcomingExam.getNumberOfQuestions(),upcomingExam.getDuration()};
            model.addRow(rowData);
        }
        
    }

    private void loadFaceExamPanel() {
        home.getLoadPanel().removeAll();
        FaceExamPanel faceExamPanel = new FaceExamPanel(home);
        faceExamPanel.setActivatedExam(activatedExam);
        home.getLoadPanel().add(faceExamPanel);
        home.getLoadPanel().repaint();
        home.getLoadPanel().revalidate();
    }


}