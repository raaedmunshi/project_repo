/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Keshav
 */
public class UpdateDeleteCourses extends javax.swing.JFrame {

    private myDBCon mycon;
    ResultSet rs;
    ResultSet rs2;
    PreparedStatement prepStatement;
    /**
     * Creates new form UpdateDeleteCourses
     */
    public UpdateDeleteCourses() {
        mycon = new myDBCon();
        initComponents();
        this.setLocationRelativeTo(null);
        CodeError.setVisible(false);
        NameError.setVisible(false);
        minCreditsError.setVisible(false);
        try
        {
            rs = mycon.getstate().executeQuery("select * from courses c left outer join prereq p on c.c_id=p.course_code order by c.c_id");
            cmbPreReq.addItem("no prerequisites");
            while(rs.next())
            {
                cmbPreReq.addItem(rs.getString("course_code"));
            }
            //rs.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        getNewData();
    }
    
    private void getNewData() {

        try {
            rs = mycon.getstate().executeQuery("select * from courses c left outer join prereq p on c.c_id=p.course_code order by c.c_id");
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected course_code.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateFields() {
        try {
            txtCode.setText(rs.getString("c_id"));
            txtName.setText(rs.getString("course_name"));
            txtMinCredits.setText(rs.getString("min_credit"));
            txtMaxCredits.setText(rs.getString("max_credit"));
            if(rs.getString("prereq_code")==null)
                cmbPreReq.setSelectedItem("no prerequisites");
            else
                cmbPreReq.setSelectedItem(rs.getString("prereq_code"));
            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void EnableDisableButtons() {
        try {
            if (rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }
            if (rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void MoveNext() {
        try {
            // TODO add your handling code here:

            if (!rs.isLast()) {
                rs.next();
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void MovePrevious() {
        try {
            // TODO add your handling code here:

            if (!rs.isFirst()) {
                rs.previous();
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                NameError.setText("Invalid. Must be < 10 chars.");
            }
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

        txtCode = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        CodeError = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        NameError = new javax.swing.JLabel();
        Code = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        minCreditsError = new javax.swing.JLabel();
        PreReq = new javax.swing.JLabel();
        minCredits = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMinCredits = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbPreReq = new javax.swing.JComboBox<>();
        maxCreditsError = new javax.swing.JLabel();
        txtMaxCredits = new javax.swing.JTextField();
        maxCredits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update/Delete Course");

        txtCode.setEditable(false);
        txtCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        CodeError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        CodeError.setForeground(new java.awt.Color(255, 0, 0));
        CodeError.setText("error label");

        Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Title.setText("Update/Delete Course");

        NameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        NameError.setForeground(new java.awt.Color(255, 0, 0));
        NameError.setText("error label");

        Code.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Code.setText("CODE:");

        Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Name.setText("NAME:");

        minCreditsError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        minCreditsError.setForeground(new java.awt.Color(255, 0, 0));
        minCreditsError.setText("error label");

        PreReq.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PreReq.setText("PRE-REQUISITE:");

        minCredits.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minCredits.setText("MIN CREDITS:");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtMinCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbPreReq.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        maxCreditsError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        maxCreditsError.setForeground(new java.awt.Color(255, 0, 0));
        maxCreditsError.setText("error label");

        txtMaxCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        maxCredits.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        maxCredits.setText("MAX CREDITS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(Title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Name)
                                            .addComponent(Code)
                                            .addComponent(PreReq)
                                            .addComponent(minCredits))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmbPreReq, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                                .addComponent(txtCode, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMinCredits, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(maxCredits)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaxCredits)
                                        .addGap(53, 53, 53)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxCreditsError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CodeError, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(NameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(minCreditsError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Title)
                .addGap(18, 18, 18)
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
                    .addComponent(PreReq)
                    .addComponent(cmbPreReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minCredits)
                    .addComponent(txtMinCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minCreditsError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxCredits)
                    .addComponent(txtMaxCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxCreditsError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            //            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (isValidData()) {
                prepStatement = mycon.getCon().prepareStatement("UPDATE courses c_id = ?, min_credit=?, max_credit=?, course_name=? where c_id = ?");
                
                prepStatement.setString(1, txtName.getText());
                prepStatement.setInt(2, Integer.parseInt(txtMinCredits.getText()));
                prepStatement.setInt(3, Integer.parseInt(txtMaxCredits.getText()));
                prepStatement.setString(4, txtCode.getText());
                
                int result = prepStatement.executeUpdate();
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("Course No " + txtCode.getText() + " updated successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    getNewData();

                } else {
                    // check validation errors
                }
                prepStatement.close();
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error updating course." + e.getMessage());

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            prepStatement = mycon.getCon().prepareStatement("DELETE courses WHERE c_id = '" + txtCode.getText().trim() + "'");
            int result = prepStatement.executeUpdate();
            if (result > 0) {
                javax.swing.JLabel label = new javax.swing.JLabel("Course No " + txtCode.getText().trim() + " deleted successfully.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                getNewData();
            }
            prepStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting course.");

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Code;
    private javax.swing.JLabel CodeError;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NameError;
    private javax.swing.JLabel PreReq;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
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
