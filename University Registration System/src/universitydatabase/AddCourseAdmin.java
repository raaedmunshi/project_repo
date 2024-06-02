/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Keshav
 */
public class AddCourseAdmin extends javax.swing.JFrame {

    private myDBCon mycon ;
    
    Statement statement;
    PreparedStatement prepStatement;
    PreparedStatement prepStatement2;
    ResultSet rs;
    /**
     * Creates new form AddCourseAdmin
     */
    public AddCourseAdmin() {
        mycon = new myDBCon();
        initComponents();
        this.setLocationRelativeTo(null);
        CodeError.setVisible(false);
        NameError.setVisible(false);
        minCreditsError.setVisible(false);
        maxCreditsError.setVisible(false);
        try
        {
            rs = mycon.getstate().executeQuery("select course_name from courses order by course_name");
            cmbPreReq.addItem("no prerequisites");
            while(rs.next())
            {
                cmbPreReq.addItem(rs.getString("course_name"));
            }
            rs.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void clearInputBoxes() {
        txtCode.setText("");
        txtName.setText("");
        cmbPreReq.setSelectedIndex(0);
        txtMinCredits.setText("");
        txtMaxCredits.setText("");
    }
    
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
    
    void clearErrorLabels() {
        CodeError.setText("");
        CodeError.setVisible(false);
        NameError.setText("");
        NameError.setVisible(false);
        minCreditsError.setText("");
        minCreditsError.setVisible(false);
        maxCreditsError.setText("");
        maxCreditsError.setVisible(false);
    }

    boolean isValidData() {

        clearErrorLabels();
        boolean result = true;
        if (txtCode.getText().trim().isEmpty() || (txtCode.getText().trim().length() > 10)) {
            if (txtCode.getText().trim().isEmpty()) {
                CodeError.setText("Invalid. Cannot be empty.");
            } else if ((txtName.getText().trim().length() > 10)) {
                NameError.setText("Invalid. Must be < 10 characters.");
            } else if (!(isInteger(txtName.getText().trim()))) {
                NameError.setText("Invalid. Must be an integer number.");
            CodeError.setVisible(true);
            result = false;
        }

        if (txtName.getText().trim().isEmpty() || (txtName.getText().trim().length() > 25)) {
            if (txtName.getText().trim().isEmpty()) {
                NameError.setText("Invalid. Cannot be empty.");
            } else if ((txtName.getText().trim().length() > 25)) {
                NameError.setText("Invalid. Must be < 25 chars.");
            }
            NameError.setVisible(true);
            result = false;
        }

        if (txtMinCredits.getText().trim().isEmpty() || !(isInteger(txtMinCredits.getText().trim())) || (Integer.parseInt(txtMinCredits.getText().trim()) < 1) || (Integer.parseInt(txtMinCredits.getText().trim()) > 3) ) {
            if (txtMinCredits.getText().trim().isEmpty()) {
                minCreditsError.setText("Invalid. Cannot be empty.");
            } else if (!(isInteger(txtMinCredits.getText().trim()))) {
                minCreditsError.setText("Invalid. Must be an integer number.");
            } else if ((Integer.parseInt(txtMinCredits.getText().trim()) < 1) || (Integer.parseInt(txtMinCredits.getText().trim()) > 3)) {
                minCreditsError.setText("Invalid. Must be between 1 and 3");
            }
            minCreditsError.setVisible(true);
            result = false;
        }
        
        if (txtMaxCredits.getText().trim().isEmpty() || !(isInteger(txtMaxCredits.getText().trim())) || (Integer.parseInt(txtMaxCredits.getText().trim()) < 1) || (Integer.parseInt(txtMaxCredits.getText().trim()) > 3) ) {
            if (txtMaxCredits.getText().trim().isEmpty()) {
                maxCreditsError.setText("Invalid. Cannot be empty.");
            } else if (!(isInteger(txtMaxCredits.getText().trim()))) {
                maxCreditsError.setText("Invalid. Must be an integer number.");
            } else if ((Integer.parseInt(txtMaxCredits.getText().trim()) < 1) || (Integer.parseInt(txtMaxCredits.getText().trim()) > 3)) {
                maxCreditsError.setText("Invalid. Must be between 1 and 3");
            }
            maxCreditsError.setVisible(true);
            result = false;
        }
    }
        return result;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbPreReq = new javax.swing.JComboBox<>();
        btnAddNewCourse = new javax.swing.JButton();
        minCredits = new javax.swing.JLabel();
        CodeError = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        Name = new javax.swing.JLabel();
        PreRequisite = new javax.swing.JLabel();
        NameError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        Title = new javax.swing.JLabel();
        minCreditsError = new javax.swing.JLabel();
        Code = new javax.swing.JLabel();
        txtMinCredits = new javax.swing.JTextField();
        maxCreditsError = new javax.swing.JLabel();
        txtMaxCredits = new javax.swing.JTextField();
        maxCredits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Course");

        cmbPreReq.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbPreReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPreReqActionPerformed(evt);
            }
        });

        btnAddNewCourse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewCourse.setText("Add New");
        btnAddNewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCourseActionPerformed(evt);
            }
        });

        minCredits.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minCredits.setText("MIN CREDITS:");

        CodeError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        CodeError.setForeground(new java.awt.Color(255, 0, 0));
        CodeError.setText("error label");

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Name.setText("NAME:");

        PreRequisite.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PreRequisite.setText("PRE-REQUISITE:");

        NameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        NameError.setForeground(new java.awt.Color(255, 0, 0));
        NameError.setText("error label");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Title.setText("Add New Course");

        minCreditsError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        minCreditsError.setForeground(new java.awt.Color(255, 0, 0));
        minCreditsError.setText("error label");

        Code.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Code.setText("CODE:");

        txtMinCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMinCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinCreditsActionPerformed(evt);
            }
        });

        maxCreditsError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        maxCreditsError.setForeground(new java.awt.Color(255, 0, 0));
        maxCreditsError.setText("error label");

        txtMaxCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaxCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxCreditsActionPerformed(evt);
            }
        });

        maxCredits.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        maxCredits.setText("MAX CREDITS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(Title))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Name)
                            .addComponent(Code)
                            .addComponent(PreRequisite)
                            .addComponent(minCredits)
                            .addComponent(maxCredits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CodeError, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cmbPreReq, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMinCredits, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NameError, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minCreditsError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaxCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxCreditsError, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addGap(14, 14, 14)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddNewCourse)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Title)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Code)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPreReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreRequisite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minCreditsError)
                    .addComponent(minCredits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxCredits)
                    .addComponent(maxCreditsError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnAddNewCourse)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMinCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinCreditsActionPerformed

    private void txtMaxCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxCreditsActionPerformed

    private void btnAddNewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCourseActionPerformed
        // TODO add your handling code here:
        try {
            // make the result set scrolable forward/backward updatable

            if (isValidData()) {
                prepStatement = mycon.getCon().prepareStatement("INSERT INTO courses (c_id, course_name, min_credit, max_credit) VALUES (?,?,?,?)");
                prepStatement.setString(1, txtCode.getText());
                prepStatement.setString(2, txtName.getText());
                prepStatement.setInt(3, Integer.parseInt(txtMinCredits.getText()));
                prepStatement.setInt(3, Integer.parseInt(txtMaxCredits.getText()));
                
                int result2 = 1;
                
                if (!cmbPreReq.getSelectedItem().toString().equals("no prerequisites")){
                    prepStatement2 = mycon.getCon().prepareStatement("INSERT INTO prereq (course_code, prereq_code) values (?,?)");
                    prepStatement2.setString(1, txtCode.getText());
                    prepStatement2.setString(2, cmbPreReq.getSelectedItem().toString());
                    result2 = prepStatement2.executeUpdate();
                }
                
                int result1 = prepStatement.executeUpdate();

                if (result1 > 0 && result2 > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New course added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearInputBoxes();
                } else {
                    // check validation errors
                }
                prepStatement.close();
                
                if (!cmbPreReq.getSelectedItem().toString().equals("no prerequisites"))
                    prepStatement2.close();
            } else {
                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new course.");
        }
    }//GEN-LAST:event_btnAddNewCourseActionPerformed

    private void cmbPreReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPreReqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPreReqActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Code;
    private javax.swing.JLabel CodeError;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NameError;
    private javax.swing.JLabel PreRequisite;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnAddNewCourse;
    private javax.swing.JComboBox<String> cmbPreReq;
    private javax.swing.JLabel maxCredits;
    private javax.swing.JLabel maxCreditsError;
    private javax.swing.JLabel minCredits;
    private javax.swing.JLabel minCreditsError;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtMaxCredits;
    private javax.swing.JTextField txtMinCredits;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
