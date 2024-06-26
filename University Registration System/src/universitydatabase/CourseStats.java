package universitydatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raaed
 */
public class CourseStats extends javax.swing.JFrame {

   
    String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    String DBUSER = "b00088595";
    String DBPASS = "b00088595";

    Connection con;
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet rs;

    public CourseStats(int currUserId) {
        initComponents();
        // center form in screen 
        this.setLocationRelativeTo(null);
        // set all error labels to invisible
        MinLbl.setVisible(false);
        MaxLbl.setVisible(false);
        AvgLbl.setVisible(false);
        StdDevLbl.setVisible(false);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery("select crn, course_code" +
                                         " from sections" +
                                         " where professors_p_id = " + currUserId);
            rs.beforeFirst();
            while (rs.next()) {
                cmbCRN.addItem(rs.getString("CRN")+" - "+rs.getString("Course_code"));
            }
            
            //rs.close();
            //statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCRN = new javax.swing.JComboBox<>();
        btnAddNewEmp = new javax.swing.JButton();
        MinLbl = new javax.swing.JLabel();
        AvgLbl = new javax.swing.JLabel();
        MaxLbl = new javax.swing.JLabel();
        StdDevLbl = new javax.swing.JLabel();
        ConfirmCourse = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Course Statistics");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Course Statistics");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Average:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Maximum:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Minimum:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("CRN:");

        cmbCRN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCRNActionPerformed(evt);
            }
        });

        btnAddNewEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewEmp.setText("Close");
        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmpActionPerformed(evt);
            }
        });

        MinLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        MinLbl.setForeground(new java.awt.Color(255, 0, 0));
        MinLbl.setText("Min");

        AvgLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        AvgLbl.setForeground(new java.awt.Color(255, 0, 0));
        AvgLbl.setText("Avg");

        MaxLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        MaxLbl.setForeground(new java.awt.Color(255, 0, 0));
        MaxLbl.setText("Max");

        StdDevLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        StdDevLbl.setForeground(new java.awt.Color(255, 0, 0));
        StdDevLbl.setText("Std Dev");

        ConfirmCourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ConfirmCourse.setText("Confirm");
        ConfirmCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmCourseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Std Dev:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCRN, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaxLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StdDevLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnAddNewEmp))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MinLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MaxLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AvgLbl)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(StdDevLbl))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnAddNewEmp)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewEmpActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAddNewEmpActionPerformed

    private void cmbCRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCRNActionPerformed

    private void ConfirmCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmCourseActionPerformed
        String crn = cmbCRN.getSelectedItem().toString().substring(0,5);
        System.out.println(crn);
        //FIND ALL STATS AND POPULATE LABELS:
        try{
            rs = statement.executeQuery("SELECT MIN(grade) as mini, MAX(grade) as max, AVG(grade) as avg, STDDEV(grade) as std " +
                                        "FROM students_grades WHERE crn = "+crn);
            
            rs.beforeFirst();
            rs.next();
            MaxLbl.setText(rs.getString("max"));
            MinLbl.setText(rs.getString("mini"));
            AvgLbl.setText(rs.getString("avg"));
            StdDevLbl.setText(rs.getString("std"));
            
            MaxLbl.setVisible(true);
            MinLbl.setVisible(true);
            AvgLbl.setVisible(true);
            StdDevLbl.setVisible(true);
            
        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Error calculating.");}
    }//GEN-LAST:event_ConfirmCourseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvgLbl;
    private javax.swing.JButton ConfirmCourse;
    private javax.swing.JLabel MaxLbl;
    private javax.swing.JLabel MinLbl;
    private javax.swing.JLabel StdDevLbl;
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JComboBox<String> cmbCRN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
