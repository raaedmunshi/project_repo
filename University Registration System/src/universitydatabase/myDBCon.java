/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Keshav
 */
public class myDBCon {
    
    String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    String DBUSER = "b00088595"; 
    String DBPASS = "b00088595"; 
    Statement statement;
    PreparedStatement prepStatement;
    Connection con;
    
    public myDBCon()
    {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
                statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
        } catch (ClassNotFoundException | SQLException e) {
                javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Connection error.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getCon () 
    {
        return con ;
    }
      
    public Statement getstate() 
    {return statement ;}
}