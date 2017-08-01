/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.view.student.formpanel;

import edu.ijse.lms.connector.ServerConnector;
import edu.ijse.lms.controller.FaceExamController;
import edu.ijse.lms.dto.ExamDTO;
import edu.ijse.lms.dto.ExamQuestionDTO;
import edu.ijse.lms.dto.StudentExamAnswersDTO;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import edu.ijse.lms.observer.FaceExamObserver;
import edu.ijse.lms.observer.Subject;
import edu.ijse.lms.view.student.StudentHome;

/**
 *
 * @author Pahansith
 */
public class FaceExamPanel extends javax.swing.JPanel implements FaceExamObserver {

    private StudentHome home;
    private final FaceExamController faceExamController;
    private ExamDTO activatedExam;
    private boolean isAttend = false;
    private ArrayList<ExamQuestionDTO> qusetionList;
    private ArrayList<StudentExamAnswersDTO> answerList;
    int index = 0;

    JLabel[] answerFields;
    private JCheckBox[] correctBoxes;
    private long timeFromMiliSeconds;
    private Timer t;

    public FaceExamPanel(StudentHome home) {
        try {
            initComponents();
            this.home = home;
            setBounds(0, 0, 800, 630);

            UnicastRemoteObject.exportObject(this, 0);
            Subject<FaceExamObserver> ob = (Subject<FaceExamObserver>) ServerConnector.getServerConnector().getExamService();
            ob.registerSpecificObserver(this, home.getStudent().getBatch());

        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(FaceExamPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        faceExamController = new FaceExamController(this);
        addAttributesToArrays();
        answerList = new ArrayList<>();
        qusetionList = new ArrayList<>();

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
        timerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionArea = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        answer2Label = new javax.swing.JLabel();
        answer3Label = new javax.swing.JLabel();
        answer4Label = new javax.swing.JLabel();
        answer5Label = new javax.swing.JLabel();
        answer5Check = new javax.swing.JCheckBox();
        answer1Check = new javax.swing.JCheckBox();
        answer2Check = new javax.swing.JCheckBox();
        answer3Check = new javax.swing.JCheckBox();
        answer4Check = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        answer1Label = new javax.swing.JLabel();
        timeLabel1 = new javax.swing.JLabel();
        proceedAnswerLabel = new javax.swing.JLabel();
        nextQuestionLabel = new javax.swing.JLabel();
        nextQuestionLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setPreferredSize(new java.awt.Dimension(800, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timerLabel.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timerLabel.setText("00:00:00");
        add(timerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 100, 40));

        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        questionArea.setRows(5);
        jScrollPane1.setViewportView(questionArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 560, 220));

        questionNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(questionNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 60, 30));

        answer2Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answer2Label.setText("Answer 2");
        add(answer2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 630, 20));

        answer3Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answer3Label.setText("Answer 3");
        add(answer3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 630, 20));

        answer4Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answer4Label.setText("Answer 4");
        add(answer4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 630, 20));

        answer5Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answer5Label.setText("Answer 5");
        add(answer5Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 630, 20));

        answer5Check.setBackground(new java.awt.Color(255, 255, 255));
        answer5Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer5CheckActionPerformed(evt);
            }
        });
        add(answer5Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        answer1Check.setBackground(new java.awt.Color(255, 255, 255));
        answer1Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1CheckActionPerformed(evt);
            }
        });
        add(answer1Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        answer2Check.setBackground(new java.awt.Color(255, 255, 255));
        answer2Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer2CheckActionPerformed(evt);
            }
        });
        add(answer2Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        answer3Check.setBackground(new java.awt.Color(255, 255, 255));
        answer3Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer3CheckActionPerformed(evt);
            }
        });
        add(answer3Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        answer4Check.setBackground(new java.awt.Color(255, 255, 255));
        answer4Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer4CheckActionPerformed(evt);
            }
        });
        add(answer4Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Question No", "Status"
            }
        ));
        examTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(examTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 160, 220));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Question Number");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, -1, 20));

        answer1Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answer1Label.setText("Answer 1");
        add(answer1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 630, 20));

        timeLabel1.setFont(new java.awt.Font("Open Sans Light", 1, 14)); // NOI18N
        timeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeLabel1.setText("Time Remain: ");
        add(timeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 100, 40));

        proceedAnswerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proceedAnswerLabel.setText("Finish Exam");
        proceedAnswerLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 3, true));
        proceedAnswerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedAnswerLabelMouseClicked(evt);
            }
        });
        add(proceedAnswerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, 120, 40));

        nextQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextQuestionLabel.setText("Submit Answer");
        nextQuestionLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 3, true));
        nextQuestionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuestionLabelMouseClicked(evt);
            }
        });
        add(nextQuestionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 120, 40));

        nextQuestionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextQuestionLabel1.setText("Next Question >");
        nextQuestionLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 3, true));
        nextQuestionLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuestionLabel1MouseClicked(evt);
            }
        });
        add(nextQuestionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 120, 40));
    }// </editor-fold>//GEN-END:initComponents


    private void answer5CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer5CheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer5CheckActionPerformed

    private void answer1CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer1CheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer1CheckActionPerformed

    private void answer2CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2CheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer2CheckActionPerformed

    private void answer3CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer3CheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer3CheckActionPerformed

    private void answer4CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer4CheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer4CheckActionPerformed

    private void examTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examTableMouseClicked
        int indexOfTable = examTable.getSelectedRow();
        if (indexOfTable != -1) {
            if (index < indexOfTable) {
                index += indexOfTable - 1;
            } else if (index > indexOfTable) {
                index -= indexOfTable + 1;
            }
            showNextQuestion(indexOfTable);
        }
    }//GEN-LAST:event_examTableMouseClicked

    private void proceedAnswerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedAnswerLabelMouseClicked
        
        int answer = JOptionPane.showConfirmDialog(this, "You have more time to do exam, Are you sure?", "Are you sure?", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            t.cancel();
            endAndSaveAnswers();
        }
    }//GEN-LAST:event_proceedAnswerLabelMouseClicked

    private void nextQuestionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextQuestionLabelMouseClicked
        getAnswers(index);
    }//GEN-LAST:event_nextQuestionLabelMouseClicked

    private void nextQuestionLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextQuestionLabel1MouseClicked
        if (++index < qusetionList.size()) {
            showNextQuestion(index);
        } else {
            --index;
            JOptionPane.showMessageDialog(this, "Last Question");
        }
    }//GEN-LAST:event_nextQuestionLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox answer1Check;
    private javax.swing.JLabel answer1Label;
    private javax.swing.JCheckBox answer2Check;
    private javax.swing.JLabel answer2Label;
    private javax.swing.JCheckBox answer3Check;
    private javax.swing.JLabel answer3Label;
    private javax.swing.JCheckBox answer4Check;
    private javax.swing.JLabel answer4Label;
    private javax.swing.JCheckBox answer5Check;
    private javax.swing.JLabel answer5Label;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable examTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nextQuestionLabel;
    private javax.swing.JLabel nextQuestionLabel1;
    private javax.swing.JLabel proceedAnswerLabel;
    private javax.swing.JTextArea questionArea;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel timeLabel1;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(ArrayList<ExamQuestionDTO> questionList) throws RemoteException {
        this.qusetionList = questionList;
        startCountDown(activatedExam);
        showNextQuestion(index);
        setAnswers(index);
        loadExamTable();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FaceExamPanel) {
            return this.home.getStudent().getNic().equals(((FaceExamPanel) o).home.getStudent().getNic());
        }
        return false;
    }

    private void showNextQuestion(int index) {
        ExamQuestionDTO question = qusetionList.get(index);
        questionArea.setText(question.getQuestion());
        setAnswers(index);
    }

    private void addAttributesToArrays() {
        answerFields = new JLabel[]{answer1Label, answer2Label, answer3Label, answer4Label, answer5Label};
        correctBoxes = new JCheckBox[]{answer1Check, answer2Check, answer3Check, answer4Check, answer5Check};
    }

    private void setAnswers(int index) {
        questionNumberLabel.setText(index + 1 + "/" + qusetionList.size());
        ExamQuestionDTO question = qusetionList.get(index);
        String[] answerList = question.getAnswerList();

        for (int i = 0; i < answerList.length; i++) {
            answerFields[i].setText(answerList[i]);
        }
    }

    private void getAnswers(int index) {
        ExamQuestionDTO question = qusetionList.get(index);
        boolean[] studentsAnswers = new boolean[5];
        int correctCount = 0;
        boolean[] correct = question.getCorrect();
        if (isOneChecked()) {
            for (int i = 0; i < correctBoxes.length; i++) {
                if (correct[i] == correctBoxes[i].isSelected()) { //Verfify the selection is correct
                    correctCount++;
                    studentsAnswers[i] = true;
                }
                correctBoxes[i].setSelected(false);
                StudentExamAnswersDTO studentExamAnswersDTO = new StudentExamAnswersDTO(question, studentsAnswers, correctCount, activatedExam, home.getStudent());
                answerList.add(studentExamAnswersDTO);
            }

            updateTable(index);
        } else {
            for (int i = 0; i < correctBoxes.length; i++) {
                if (correct[i] == correctBoxes[i].isSelected()) { //Verfify the selection is correct
                    correctCount++;
                    studentsAnswers[i] = true;
                }
                correctBoxes[i].setSelected(false);
                StudentExamAnswersDTO studentExamAnswersDTO = new StudentExamAnswersDTO(question, studentsAnswers, correctCount, activatedExam, home.getStudent());
                answerList.add(studentExamAnswersDTO);
            }
        }
    }

    private void loadExamTable() {
        int number = 0;
        DefaultTableModel model = (DefaultTableModel) examTable.getModel();
        if (!qusetionList.isEmpty()) {
            for (ExamQuestionDTO examQuestionDTO : qusetionList) {
                Object[] rowData = {++number, false};
                model.addRow(rowData);
            }
        }
    }

    private boolean isOneChecked() {
        int count = 0;
        for (int i = 0; i < correctBoxes.length; i++) {
            if (correctBoxes[i].isSelected()) {
                count++;
            }
        }

        return count > 0;
    }

    private void updateTable(int index) {
        DefaultTableModel model = (DefaultTableModel) examTable.getModel();
        model.setValueAt(true, index, 1);
    }

    private void endAndSaveAnswers() {
        //send answers to server
        faceExamController.uplodaAnswers(answerList);

        qusetionList.clear();
        questionArea.setText(null);
        for (int i = 0; i < answerFields.length; i++) {
            answerFields[i].setText(null);
            correctBoxes[i].setText(null);
        }
    }

    @Override
    public void endExam() throws RemoteException {
        JOptionPane.showMessageDialog(this, "Exam time is over", "Time Over", JOptionPane.INFORMATION_MESSAGE);
        endAndSaveAnswers();

    }

    private void startCountDown(ExamDTO exam) {

        if (exam.getDuration().contains("H")) {
            timeFromMiliSeconds = Long.parseLong(exam.getDuration().split("H")[0]) * 60 * 60 * 1000;
        } else if (exam.getDuration().contains("M")) {
            timeFromMiliSeconds = Long.parseLong(exam.getDuration().split("M")[0]) * 60 * 1000;
        }

        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeFromMiliSeconds == 0) {
                    t.cancel();
                }
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timeFromMiliSeconds),
                        TimeUnit.MILLISECONDS.toMinutes(timeFromMiliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeFromMiliSeconds)),
                        TimeUnit.MILLISECONDS.toSeconds(timeFromMiliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeFromMiliSeconds)));
                timerLabel.setText(hms);
                timeFromMiliSeconds -= 1000;

            }
        }, 10, 1000);
    }

    void setActivatedExam(ExamDTO activatedExam) {
        this.activatedExam = activatedExam;
    }
}
