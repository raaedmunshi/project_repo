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
public class AddStudent extends javax.swing.JFrame {

    private myDBCon mycon ;
    
    Statement statement;
    PreparedStatement prepStatement;
    PreparedStatement prepStatement2;
    ResultSet rs;
    /**
     * Creates new form AddStudent
     */
    public AddStudent() {
        mycon = new myDBCon();
        initComponents();
        this.setLocationRelativeTo(null);
        IDError.setVisible(false);
        NameError.setVisible(false);
        CreditsError.setVisible(false);
        StandingError.setVisible(false);
        GPAError.setVisible(false);
        cmbMajor.addItem("CAAD");
        cmbMajor.addItem("SBA");
        cmbMajor.addItem("CAS");
        cmbMajor.addItem("CEN");
        cmbGender.addItem("Male");
        cmbGender.addItem("Female");
    }

    void clearInputBoxes() {
        txtID.setText("");
        txtName.setText("");
        cmbMajor.setSelectedIndex(0);
        txtCredits.setText("");
        txtStanding.setText("");
        cmbGender.setSelectedIndex(0);
    }
    
    public void findStanding()
    {
        if((Integer.parseInt(txtCredits.getText()) >= 0) && (Integer.parseInt(txtCredits.getText()) < 30))
        {
            txtStanding.setText("Freshman");
        }
        else if((Integer.parseInt(txtCredits.getText()) >= 30) && (Integer.parseInt(txtCredits.getText()) < 60))
        {
            txtStanding.setText("Sophomore");
        }
        else if((Integer.parseInt(txtCredits.getText()) >= 60) && (Integer.parseInt(txtCredits.getText()) < 90))
        {
            txtStanding.setText("Junior");
        }
        else
        {
            txtStanding.setText("Senior");
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
        IDError.setText("");
        IDError.setVisible(false);
        NameError.setText("");
        NameError.setVisible(false);
        CreditsError.setText("");
        CreditsError.setVisible(false);
        StandingError.setText("");
        StandingError.setVisible(false);
        GPAError.setText("");
        GPAError.setVisible(false);
    }
    
    boolean isValidData() {

        clearErrorLabels();
        boolean result = true;
        if (txtID.getText().trim().isEmpty() || !isInteger(txtID.getText().trim())) {
            if (txtID.getText().trim().isEmpty()) {
                IDError.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtID.getText().trim())) {
                IDError.setText("Invalid. Must be integer.");
            }
            IDError.setVisible(true);
            result = false;
        }

        if (txtName.getText().isEmpty() || (txtName.getText().trim().length() > 10)) {
            if (txtName.getText().trim().isEmpty()) {
                NameError.setText("Invalid. Cannot be empty.");
            } else if ((txtName.getText().trim().length() > 50)) {
                NameError.setText("Invalid. Must be < 50 chars.");
            }
            NameError.setVisible(true);
            result = false;
        }

        if (txtCredits.getText().trim().isEmpty() || !(isInteger(txtCredits.getText().trim())) || (Integer.parseInt(txtCredits.getText().trim()) < 0) ) {
            if (txtCredits.getText().trim().isEmpty()) {
                CreditsError.setText("Invalid. Cannot be empty.");
            } else if (!(isInteger(txtCredits.getText().trim()))) {
                CreditsError.setText("Invalid. Must be an integer number.");
            } else if (Integer.parseInt(txtCredits.getText().trim()) < 0) {
                CreditsError.setText("Invalid. Must be a positive integer number");
            }
            CreditsError.setVisible(true);
            result = false;
        }

        if (txtStanding.getText().trim().isEmpty() || (txtStanding.getText().trim().length() > 10) ) {
            if(txtStanding.getText().trim().isEmpty())
                StandingError.setText("Invalid. Cannot be empty.");
            else if(txtStanding.getText().trim().length() > 25)
                StandingError.setText("Invalid. Must be < 25 chars.");
            StandingError.setVisible(true);
            result = false;
        }

        if(txtGPA.getText().trim().isEmpty() || !(isDouble(txtGPA.getText().trim()))) {
            if (txtGPA.getText().trim().isEmpty()) {
                GPAError.setText("Invalid. Cannot be empty.");
            } else if (!(isDouble(txtGPA.getText().trim()))) {
                GPAError.setText("Invalid. Must be floating point number.");
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

        Name = new javax.swing.JLabel();
        txtStanding = new javax.swing.JTextField();
        Major = new javax.swing.JLabel();
        cmbMajor = new javax.swing.JComboBox<>();
        Gender = new javax.swing.JLabel();
        btnAddNewEmp = new javax.swing.JButton();
        Credits = new javax.swing.JLabel();
        Standing = new javax.swing.JLabel();
        IDError = new javax.swing.JLabel();
        GPA = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        NameError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        Title = new javax.swing.JLabel();
        CreditsError = new javax.swing.JLabel();
        IDNo = new javax.swing.JLabel();
        txtCredits = new javax.swing.JTextField();
        StandingError = new javax.swing.JLabel();
        txtGPA = new javax.swing.JTextField();
        GPAError = new javax.swing.JLabel();
        FindStanding = new javax.swing.JButton();
        cmbGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Student");

        Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Name.setText("NAME:");

        txtStanding.setEditable(false);
        txtStanding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStanding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStandingActionPerformed(evt);
            }
        });

        Major.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Major.setText("MAJOR:");

        cmbMajor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Gender.setText("GENDER:");

        btnAddNewEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewEmp.setText("Add New");
        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmpActionPerformed(evt);
            }
        });

        Credits.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Credits.setText("CREDITS:");

        Standing.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Standing.setText("STANDING:");

        IDError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        IDError.setForeground(new java.awt.Color(255, 0, 0));
        IDError.setText("error label");

        GPA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GPA.setText("GPA:");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        NameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        NameError.setForeground(new java.awt.Color(255, 0, 0));
        NameError.setText("error label");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Title.setText("Add New Student");

        CreditsError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        CreditsError.setForeground(new java.awt.Color(255, 0, 0));
        CreditsError.setText("error label");

        IDNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDNo.setText("ID NO:");

        txtCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditsActionPerformed(evt);
            }
        });

        StandingError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        StandingError.setForeground(new java.awt.Color(255, 0, 0));
        StandingError.setText("error label");

        txtGPA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        GPAError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        GPAError.setForeground(new java.awt.Color(255, 0, 0));
        GPAError.setText("error label");

        FindStanding.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        FindStanding.setText("Find Standing");
        FindStanding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindStandingActionPerformed(evt);
            }
        });

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(Title))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Name)
                                .addComponent(IDNo)
                                .addComponent(Major)
                                .addComponent(Gender)
                                .addComponent(Credits)
                                .addComponent(Standing)
                                .addComponent(GPA))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IDError, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(txtStanding, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(txtCredits, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGPA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(cmbMajor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NameError, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(CreditsError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(StandingError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(GPAError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(291, 291, 291)
                            .addComponent(FindStanding))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(btnAddNewEmp))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Title)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDNo)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Major))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gender)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Credits)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreditsError))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Standing)
                    .addComponent(txtStanding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StandingError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GPA)
                    .addComponent(txtGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GPAError))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FindStanding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNewEmp))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewEmpActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable

            if (isValidData()) {
                findStanding();
                /*
                sid, name, sex, start_sem, major, credits, standing, gpa
                */
                prepStatement = mycon.getCon().prepareStatement("INSERT INTO students (s_id, gpa, dob, gender, standing, major, name, credits) VALUES (?,?,?,?,?,?,?,?)");
                prepStatement2 = mycon.getCon().prepareStatement("INSERT INTO users (username,password,name,type) VALUES (?,?,?,?)");
                prepStatement2.setString(1, "s"+ txtID.getText());
                prepStatement2.setString(2, "s"+ txtID.getText());
                prepStatement2.setString(3, txtName.getText());
                prepStatement2.setInt(4, 1);
                prepStatement.setInt(1, Integer.parseInt(txtID.getText()));
                prepStatement.setDouble(2, Double.parseDouble(txtGPA.getText()));
                if(cmbGender.getSelectedItem()=="Male")
                    prepStatement.setString(4,"M");
                else
                    prepStatement.setString(4,"F");
                prepStatement.setString(5, txtStanding.getText());
                prepStatement.setString(6, cmbMajor.getSelectedItem().toString());
                prepStatement.setString(7, txtName.getText());
                prepStatement.setInt(8, Integer.parseInt(txtCredits.getText()));
                
                int result = prepStatement.executeUpdate();
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New student added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearInputBoxes();
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
            JOptionPane.showMessageDialog(null, "Error adding new student.");
        }
    }//GEN-LAST:event_btnAddNewEmpActionPerformed

    private void txtCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditsActionPerformed

    private void FindStandingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindStandingActionPerformed
        // TODO add your handling code here:
        findStanding();
    }//GEN-LAST:event_FindStandingActionPerformed

    private void txtStandingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStandingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStandingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Credits;
    private javax.swing.JLabel CreditsError;
    private javax.swing.JButton FindStanding;
    private javax.swing.JLabel GPA;
    private javax.swing.JLabel GPAError;
    private javax.swing.JLabel Gender;
    private javax.swing.JLabel IDError;
    private javax.swing.JLabel IDNo;
    private javax.swing.JLabel Major;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NameError;
    private javax.swing.JLabel Standing;
    private javax.swing.JLabel StandingError;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbMajor;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStanding;
    // End of variables declaration//GEN-END:variables
}
