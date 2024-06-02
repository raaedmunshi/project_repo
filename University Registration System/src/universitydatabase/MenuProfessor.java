/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabase;

/**
 *
 * @author Raaed
 */
public class MenuProfessor extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private int currUserId;
    public MenuProfessor(int id) {
        initComponents();
        this.setLocationRelativeTo(null);
        currUserId=id;
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ViewStats = new javax.swing.JMenuItem();
        AddCourse = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        PersonalInfo = new javax.swing.JMenuItem();
        CourseTaught = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu - JDBC GUI");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UniSystem/employees.jpg"))); // NOI18N

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UniSystem/logout.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UniSystem/close.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Course");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        ViewStats.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ViewStats.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ViewStats.setText("View Course Statistics");
        ViewStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewStatsActionPerformed(evt);
            }
        });
        jMenu2.add(ViewStats);

        AddCourse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        AddCourse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AddCourse.setText("Add Course");
        AddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseActionPerformed(evt);
            }
        });
        jMenu2.add(AddCourse);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View Info");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        PersonalInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        PersonalInfo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PersonalInfo.setText("View Personal Info");
        PersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalInfoActionPerformed(evt);
            }
        });
        jMenu3.add(PersonalInfo);

        CourseTaught.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CourseTaught.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CourseTaught.setText("View Courses Taught");
        CourseTaught.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseTaughtActionPerformed(evt);
            }
        });
        jMenu3.add(CourseTaught);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewStatsActionPerformed
        // TODO add your handling code here:
        (new CourseStats(currUserId)).setVisible(true);
    }//GEN-LAST:event_ViewStatsActionPerformed

    private void AddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseActionPerformed
        (new AddCourseProf(currUserId)).setVisible(true);
    }//GEN-LAST:event_AddCourseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        (new LoginForm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void PersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalInfoActionPerformed
        (new ProfInfo(currUserId)).setVisible(true);
    }//GEN-LAST:event_PersonalInfoActionPerformed

    private void CourseTaughtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseTaughtActionPerformed
        (new ViewCoursesProf(currUserId)).setVisible(true);
    }//GEN-LAST:event_CourseTaughtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddCourse;
    private javax.swing.JMenuItem CourseTaught;
    private javax.swing.JMenuItem PersonalInfo;
    private javax.swing.JMenuItem ViewStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
