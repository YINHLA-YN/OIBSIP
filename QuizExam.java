/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mcq;

/**
 *
 * @author NANCY
 */
import java.sql.*;
import Project.SQL_CONNECTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.UIManager.getString;

public class QuizExam extends javax.swing.JFrame {
public String questionId="1";
public String answer;
public int min=0;
public int sec=0;
public int marks=0;

public void answerCheck(){
    String studentAnswer="";
    if(jRadioButton1.isSelected()){
        studentAnswer=jRadioButton1.getText();
        
    }
    else if(jRadioButton2.isSelected()){
     studentAnswer=jRadioButton2.getText();
    }
     else if(jRadioButton3.isSelected()){
     studentAnswer=jRadioButton3.getText();
     
     
    } else{
     studentAnswer=jRadioButton4.getText();
    }
    if(studentAnswer.equals(answer)){
    
    marks=marks+1;
    String marks1=String.valueOf(marks);
    lblMarks_Values.setText(marks1);
    
    
    }
    //question number change
     int questionId1 = Integer.parseInt(questionId); // Parse the String to an int
    questionId1 = 1 + questionId1; // Increment the int value
    questionId = String.valueOf(questionId1); // Convert the int back to a String to avoid number formats exceptions
    //clear radio buttons
    jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
                jRadioButton4.setSelected(false);
    
    
    //hide next button
    
    if(questionId.equals("10")){
    btnNext.setVisible(false);
    
    }

    
}


public void question(){
      try{  
            Connection con = SQL_CONNECTION.getcon();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs1 = st.executeQuery("SELECT  *FROM questions WHERE Id='"+questionId+"'" );
          while(rs1.next()){
          lblQuestion_Value.setText(rs1.getString(1));
          lblQuestion.setText(rs1.getString(2));
          jRadioButton1.setText(rs1.getString(3));
          jRadioButton2.setText(rs1.getString(4));
          jRadioButton3.setText(rs1.getString(5));
          jRadioButton4.setText(rs1.getString(6));
          answer=rs1.getString(7);
          }
        
        }
        
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        
        
        }
    
}

public  void submit(){
    
    String roll_number=lblRoll_No_Value.getText();
    answerCheck();
    try{
         Connection con = SQL_CONNECTION.getcon();
         Statement st = con.createStatement();
         st.executeUpdate("UPDATE Student SET marks='" + marks + "' WHERE rollNo='" + roll_number + "'");
         String marks1=String.valueOf(marks);
         JOptionPane.showMessageDialog(null,marks1);

    
    }
    
    catch(Exception e){}
}

    /**
     * Creates new form QuitExam
     */
    public QuizExam() {
        initComponents();
    }
    Timer time;
    public QuizExam(String roll_number) {
        initComponents();
        lblRoll_No_Value.setText(roll_number);
        //date
        SimpleDateFormat dFormat= new SimpleDateFormat("dd-mm-yyyy");
        Date date=new Date();
        lblDate.setText(dFormat.format(date));
        
        // first student and student details
        
        try{  
            Connection con = SQL_CONNECTION.getcon();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT  *FROM Students WHERE rollNo='"+roll_number+"'" );
        while(rs.next()){
            
            lblName_Value.setText(rs.getString(2));
            
        }
          ResultSet rs1 = st.executeQuery("SELECT  *FROM questions WHERE Id='"+questionId+"'" );
          while(rs1.next()){
          lblQuestion_Value.setText(rs1.getString(1));
          lblQuestion.setText(rs1.getString(2));
          jRadioButton1.setText(rs1.getString(3));
          jRadioButton2.setText(rs1.getString(4));
          jRadioButton3.setText(rs1.getString(5));
          jRadioButton4.setText(rs1.getString(6));
          answer=rs1.getString(7);
          }
        
        }
        
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        
        
        }
        //Time 
        
        setLocationRelativeTo(this);
        time=new Timer(1000,new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                
                lblTime_Taken_Value.setText(String.valueOf(sec));
                lblTotal_TIme_Value.setText(String.valueOf(min));
                
                if(sec==60){
                sec=0;
                min++;
                        if(min==10){
                            time.stop();
                            answerCheck();
                            submit();
                        }
                }
                sec++;
            }
        
        });
        time.start();
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTime_Taken_Value = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal_TIme_Value = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblRoll_No_Value = new javax.swing.JLabel();
        lblName_Value = new javax.swing.JLabel();
        lblQuestion_Value = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblMarks_Values = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        jLabel1.setText("WELCOME");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 440, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Date :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDate.setText("jLabel3");
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Time Taken :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, -1));

        lblTime_Taken_Value.setBackground(new java.awt.Color(255, 51, 51));
        lblTime_Taken_Value.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTime_Taken_Value.setForeground(new java.awt.Color(255, 51, 51));
        lblTime_Taken_Value.setText("00 00");
        jPanel2.add(lblTime_Taken_Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Total Time :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        lblTotal_TIme_Value.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTotal_TIme_Value.setText("10 Min");
        jPanel2.add(lblTotal_TIme_Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 100));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Roll Number :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Name :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Total Questions 10 :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Question Number :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Your Marks :");

        lblRoll_No_Value.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRoll_No_Value.setText("10000");

        lblName_Value.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName_Value.setText("Yinhla Ncenya");

        lblQuestion_Value.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuestion_Value.setText("10");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("00");

        lblMarks_Values.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMarks_Values.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarks_Values)
                    .addComponent(jLabel16)
                    .addComponent(lblQuestion_Value)
                    .addComponent(lblRoll_No_Value)
                    .addComponent(lblName_Value))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblRoll_No_Value))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblName_Value))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblQuestion_Value))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblMarks_Values))
                .addContainerGap(312, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, 670));

        lblQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuestion.setText("Question Demo");
        getContentPane().add(lblQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 170, -1));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcq/next_plan_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 660, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcq/file_save_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 660, 170, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        answerCheck();
        question();
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit the exam","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
        
        answerCheck();
        submit();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
if(jRadioButton1.isSelected()){

jRadioButton2.setSelected(false);
jRadioButton3.setSelected(false);
jRadioButton4.setSelected(false);

}        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected()){

jRadioButton1.setSelected(false);
jRadioButton3.setSelected(false);
jRadioButton4.setSelected(false);

}        // TODO add your handling code he
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton3.isSelected()){

jRadioButton1.setSelected(false);
jRadioButton2.setSelected(false);
jRadioButton4.setSelected(false);

}        // TODO add your handling code he
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton4.isSelected()){

jRadioButton1.setSelected(false);
jRadioButton3.setSelected(false);
jRadioButton4.setSelected(false);

}        // TODO add your handling code he
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMarks_Values;
    private javax.swing.JLabel lblName_Value;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestion_Value;
    private javax.swing.JLabel lblRoll_No_Value;
    private javax.swing.JLabel lblTime_Taken_Value;
    private javax.swing.JLabel lblTotal_TIme_Value;
    // End of variables declaration//GEN-END:variables
}
